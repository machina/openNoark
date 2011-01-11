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
package org.friark
import org.friark.ds.*

/**
* Metoder for å gjøre operasjoner på Series objekter.
*/
class DocumentDescriptionService {

	boolean transactional = true
	def commonService


	def create(def params){
		def documentDescription
		if(params.documentDescription) params = params.documentDescription
		
		
		documentDescription = new DocumentDescription(params)
		commonService.setNewSystemID(documentDescription)
		commonService.setCreated(documentDescription)
		
                        
		if(documentDescription.save()){
			return [documentDescription, true]
		} else {
			println documentDescription.errors
			println "NOT SAVED"
			return [documentDescription, false]
		}
	}
	

	def update(def params){
		if(params.documentDescription) params = params.documentDescription

		def documentDescription = DocumentDescription.get(params.id)
		params.createdDate = documentDescription.createdDate
		params.createdBy = documentDescription.createdBy
		documentDescription.properties = params
		if(!documentDescription.hasErrors() && documentDescription.validate() && documentDescription.save()){
			println "saved"
			return [documentDescription, true]
		} else {
			println "error: ${arkivdel.errors}"
			return [documentDescription, false]
		}
	}


}
