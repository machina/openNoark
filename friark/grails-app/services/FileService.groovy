/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

import org.friark.ds.*

/**
* Tilbyr diverse operasjoner på mapper.
*/
class FileService {

    boolean transactional = true
		def commonService
    def mappeIdGeneratorService

    /**
    * Lager en ny mappe med de inkommende paramerterene.
    * @param params Et Map som inneholder metadata for Mappen.
    */
		def create(params) {
				params = fixParams(params) 
				if(!getFileTypes().contains(params.fileType)){
					return [[errors: ["Mappetype er ikke tillatt"]], false]
				}
				def mappe
				switch(params.fileType){
					case 'BasicFile':
						mappe =  new BasicFile(params)
						break
					case 'CaseFile':
						mappe =  new CaseFile(params)

				}
				mappe.fileID = mappeIdGeneratorService.generatorForMappe(mappe).call()
				commonService.setNewSystemID mappe
				commonService.setCreated(mappe)
				
				def (delOk, error) = checkSeries(params, mappe)
				if(!delOk){
					//println error
					mappe.errors.reject 'org.friark.noexistingKey', error
					return [mappe, false]
				}
				if(params.keyword && params.keyword instanceof String) mappe.keyword = params.keyword.tokenize(" ")
				
				if(!mappe.hasErrors() && mappe.save()) {
					return [mappe, true]
				}
				//println mappe.errors
				
				return [mappe, false]
		}
	
		def update(params){
			params = fixParams(params)
		
			def file = BasicFile.get( params.id )			
			params.createdDate = file.createdDate //creatdDate can not be changed
			file.properties = params
			if(!file.hasErrors() && file.save()) {
				return [file,true]
			}

			return [file, false]
		}
		
		/**
		* returns a usable params
		*/
		private def fixParams(def params){
			if(params.basicFile) params = params.basicFile
      if(params.caseFile) params = params.caseFile
      params.recordSection = Series.get(params.'recordSection.id')
			commonService.trimAll(params)
			return params
		}

		
		private def checkSeries(params, mappe){
			if(mappe.recordSection.recordSectionStatus == "Opprettet"  && (mappe.recordSection.periodStatus == null  || mappe.recordSection.periodStatus == "Aktiv periode")){
				mappe.recordSection.addToFile(mappe)
				return [true]
			}

			return [false, "Kan ikke lege til en mappe i et arkiv med periodestatus ${mappe.recordSection.periodStatus}"]
		}

		def getFileTypes(){
			commonService.getParameter("tilgjengelige_fileTypes").split(",").collect{it.trim()}
  }
}
