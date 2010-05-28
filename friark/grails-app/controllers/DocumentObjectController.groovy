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

import grails.converters.*
import java.text.SimpleDateFormat
import no.friark.ds.*

/**
* CRUD operasjoner på DocumentObject.
*/
class DocumentObjectController {
 		def commonService   
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ dokumentobjektInstanceList: DocumentObject.list( params ), dokumentobjektInstanceTotal: DocumentObject.count() ]
   }

    def show = {
        def dokumentobjektInstance = DocumentObject.get( params.id )

        if(!dokumentobjektInstance) {
            flash.message = "DocumentObject not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ dokumentobjektInstance : dokumentobjektInstance ] }
   }

    def delete = {
        def dokumentobjektInstance = DocumentObject.get( params.id )
        if(dokumentobjektInstance) {
            try {
                dokumentobjektInstance.delete(flush:true)
                flash.message = "DocumentObject ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "DocumentObject ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "DocumentObject not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def dokumentobjektInstance = DocumentObject.get( params.id )

        if(!dokumentobjektInstance) {
            flash.message = "DocumentObject not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ dokumentobjektInstance : dokumentobjektInstance ]
       }
   }

    def update = {
        def dokumentobjektInstance = DocumentObject.get( params.id )
        if(dokumentobjektInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(dokumentobjektInstance.version > version) {
                    
                    dokumentobjektInstance.errors.rejectValue("version", "dokumentobjekt.optimistic.locking.failure", "Another user has updated this DocumentObject while you were editing.")
                    render(view:'edit',model:[dokumentobjektInstance:dokumentobjektInstance])
                    return
               }
           }
            dokumentobjektInstance.properties = params
            if(!dokumentobjektInstance.hasErrors() && dokumentobjektInstance.save()) {
                flash.message = "DocumentObject ${params.id} updated"
                redirect(action:show,id:dokumentobjektInstance.id)
           }
            else {
                render(view:'edit',model:[dokumentobjektInstance:dokumentobjektInstance])
           }
       }
        else {
            flash.message = "DocumentObject not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def dokumentobjektInstance = new DocumentObject()
        dokumentobjektInstance.properties = params
        return ['dokumentobjektInstance':dokumentobjektInstance]
   }

    def save = {
				println params
				def df = new SimpleDateFormat("dd-MM-yyyy")
				def dokumentobjektInstance = null
				if(params.dokumentobjekt != null){
					params.dokumentobjekt.createdDate = df.parse(params.dokumentobjekt.createdDate)
					params.dokumentobjekt.referanseregistrering = SimplifiedRecord.findBySystemID(params.dokumentobjekt.referanseregistrering)
					dokumentobjektInstance = new DocumentObject(params.dokumentobjekt)
				} else {
	        dokumentobjektInstance = new DocumentObject(params)
				}
				commonService.setNewSystemID dokumentobjektInstance
				if(params.dokumentobjekt) dokumentobjektInstance.referanseregistrering = params.dokumentobjekt.referanseregistrering
        if(!dokumentobjektInstance.hasErrors() && dokumentobjektInstance.save()) {
					flash.message = "DocumentObject ${dokumentobjektInstance.id} created"
					withFormat {
  	        html {
           	 redirect(action:show,id:dokumentobjektInstance.id)
						}
						form {redirect(action:show,id:dokumentobjektInstance.id) }
						xml { render dokumentobjektInstance as XML }
						json { render dokumentobjektInstance as JSON}
					}
       }
        else {
						println dokumentobjektInstance.errors
            render(view:'create',model:[dokumentobjektInstance:dokumentobjektInstance])
       }
   }
}
