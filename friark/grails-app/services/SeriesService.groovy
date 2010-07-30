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
* Metoder for å gjøre operasjoner på Series objekter.
*/
class SeriesService {

    boolean transactional = true
		def commonService


	def create(def params){
		def arkivdel
		def parent
		if(params.series) params = params.series
		
		parent = params.parent
		params.parent = null
		
		arkivdel = new Series(params)
		arkivdel.recordSectionStatus = "Opprettet"
		commonService.setNewSystemID(arkivdel)
		commonService.setCreated(arkivdel)
		
		if(parent == null || parent == "null") {
			arkivdel.parent = null
		} else {
			arkivdel.parent = Fonds.get(parent)
		}
                        
		if(arkivdel.save()){
			return [arkivdel, true]
		} else {
			return [arkivdel, false]
		}
	}
	

	def update(def params){
		if(params.series) params = params.series
		def arkivdel = Series.get(params.id)
		params.createdDate = arkivdel.createdDate
		params.recordSectionStatus = params.recordSectionStatus.trim()
		params.parent = Fonds.get(params.'parent.id')
		println params.parent
		arkivdel.properties = params
		println arkivdel.parent
		if(!arkivdel.hasErrors() && arkivdel.validate() && arkivdel.save()){
			println "saved"
			return [arkivdel, true]
		} else {
			println "error: ${arkivdel.errors}"
			return [arkivdel, false]
		}
	}
		/**
		* Finner alle Mapper under den inkommende arkivdelen som ikke er avsluttet.
    * @param del Seriesen som inneholder mapppene
    * @return en Liste av alle mappene under del som har finalisedDate lik null
		*/
		def findOpenMappe(Series del){
			def retval = []
			del.file.each{
				if(it.finalisedDate == null) retval << it
			}
			return retval
		}
	
}
