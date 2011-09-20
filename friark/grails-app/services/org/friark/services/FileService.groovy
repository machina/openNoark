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

package org.friark.services

import org.friark.ds.*
import org.friark.services.MappeIdGeneratorService;

/**
* Offers misc operations on the files
*/
class FileService {

	boolean transactional = true
	def commonService
	def mappeIdGeneratorService

    	/**
	* Creates a file with the incoming parameters
	* @param params A map containing the file's metadata
    	*/
	def create(params) {
		params = fixParams(params) 
		if(!getFileTypes().contains(params.fileType)){
			/** TODO externalise strings*/
			return [[errors: ["File type not allowed"]], false]
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
			mappe.errors.reject 'org.friark.noexistingKey', error
			return [mappe, false]
		}

		if(params.keyword && params.keyword instanceof String) mappe.keyword = params.keyword.tokenize(" ")
			if(!mappe.hasErrors() && mappe.save()) {
				return [mappe, true]
			}
				
			return [mappe, false]
		}
	
		def update(params){
			params = fixParams(params)
		
			def file = BasicFile.get( params.id )			
			//createdDate can not be changed
			params.createdDate = file.createdDate 
			file.properties = params

			if(!file.hasErrors() && file.save()) {
				return [file,true]
			}

			return [file, false]
		}
		
		/**
		* Returns a usable parameter
		*/
		private def fixParams(def params){
			if(params.basicFile) params = params.basicFile
      			if(params.caseFile) params = params.caseFile

      			params.recordSection = Series.get(params.'recordSection.id')
			commonService.trimAll(params)
			return params
		}
		
		private def checkSeries(params, mappe){
			if(mappe.recordSection.recordSectionStatus == "Opprettet"  
			&& (mappe.recordSection.periodStatus == null  || mappe.recordSection.periodStatus == "Aktiv periode"))
			{
				mappe.recordSection.addToFile(mappe)
				return [true]
			}

			return [false, "Cannot add a file to a fonds with periodstatus ${mappe.recordSection.periodStatus}"]
		}

		def getFileTypes(){
			commonService.getParameter("tilgjengelige_fileTypes").split(",").collect{it.trim()}
  }
}
