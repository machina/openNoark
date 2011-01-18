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

class DocumentObjectService {

	boolean transactional = true
	def commonService

	def create(def params){
		def documentObject
		if(params.documentObject) params = params.documentObject

		params.documentDescription = DocumentDescription.get( params."documentDescription.id" )

		documentObject = new DocumentObject(params)
		commonService.setNewSystemID(documentObject)
		commonService.setCreated(documentObject)
                        
		if(documentObject.save()){
			return [documentObject, true]
		} else {
			println documentObject.errors
			return [documentObject, false]
		}
	}

	def update(def params){
		if(params.documentObject) params = params.documentObject

		params.documentDescription = DocumentDescription.get( params."documentDescription.id" )

		def documentObject = DocumentObject.get(params.id)
		params.createdDate = documentObject.createdDate
		params.createdBy = documentObject.createdBy
		documentObject.properties = params

		if(!documentObject.hasErrors() && documentObject.validate() && documentObject.save()){
			println "saved"
			return [documentObject, true]
		} else {
			println "error: ${documentObject.errors}"
			return [documentObject, false]
		}
	}
}
