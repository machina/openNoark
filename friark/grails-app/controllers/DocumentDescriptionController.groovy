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


import no.friark.ds.*

/**
* CRUD opereasjoner på DocumentDescription
*/
class DocumentDescriptionController {
 		def commonService  
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ documentDescriptionInstanceList: DocumentDescription.list( params ), documentDescriptionInstanceTotal: DocumentDescription.count() ]
   }

    def show = {
        def documentDescriptionInstance = DocumentDescription.get( params.id )

        if(!documentDescriptionInstance) {
            flash.message = "DocumentDescription not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ documentDescriptionInstance : documentDescriptionInstance ] }
   }

    def delete = {
        def documentDescriptionInstance = DocumentDescription.get( params.id )
        if(documentDescriptionInstance) {
            try {
                documentDescriptionInstance.delete(flush:true)
                flash.message = "DocumentDescription ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "DocumentDescription ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "DocumentDescription not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def documentDescriptionInstance = DocumentDescription.get( params.id )

        if(!documentDescriptionInstance) {
            flash.message = "DocumentDescription not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ documentDescriptionInstance : documentDescriptionInstance ]
       }
   }

    def update = {
        def documentDescriptionInstance = DocumentDescription.get( params.id )
        if(documentDescriptionInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(documentDescriptionInstance.version > version) {
                    
                    documentDescriptionInstance.errors.rejectValue("version", "documentDescription.optimistic.locking.failure", "Another user has updated this DocumentDescription while you were editing.")
                    render(view:'edit',model:[documentDescriptionInstance:documentDescriptionInstance])
                    return
               }
           }
            documentDescriptionInstance.properties = params
            if(!documentDescriptionInstance.hasErrors() && documentDescriptionInstance.save()) {
                flash.message = "DocumentDescription ${params.id} updated"
                redirect(action:show,id:documentDescriptionInstance.id)
           }
            else {
                render(view:'edit',model:[documentDescriptionInstance:documentDescriptionInstance])
           }
       }
        else {
            flash.message = "DocumentDescription not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def documentDescriptionInstance = new DocumentDescription()
        documentDescriptionInstance.properties = params
        return ['documentDescriptionInstance':documentDescriptionInstance]
   }

    def save = {
        def documentDescriptionInstance = new DocumentDescription(params)
				commonService.setNewSystemID documentDescriptionInstance
        if(!documentDescriptionInstance.hasErrors() && documentDescriptionInstance.save()) {
            flash.message = "DocumentDescription ${documentDescriptionInstance.id} created"
            redirect(action:show,id:documentDescriptionInstance.id)
       }
        else {
            render(view:'create',model:[documentDescriptionInstance:documentDescriptionInstance])
       }
   }
}
