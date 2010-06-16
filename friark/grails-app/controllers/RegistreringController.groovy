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

import java.text.SimpleDateFormat
import grails.converters.*
import no.friark.ds.*

/**
* CRUD-operasjoner for SimplifiedRecord
*
* @author Kent Inge Fagerland Simonsen
*/
class RegistreringController {

	def commonService
 	def registreringService   
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
//    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				withFormat{
	        html {return [ forenkletRegistreringInstanceList: SimplifiedRecord.list( params ), forenkletRegistreringInstanceTotal: SimplifiedRecord.count() ] }
					xml { render SimplifiedRecord.list() as XML }
				}
   }

    def show = {
        def forenkletRegistreringInstance = SimplifiedRecord.get( params.id )

        if(!forenkletRegistreringInstance) {
            flash.message = "SimplifiedRecord not found with id ${params.id}"
            redirect(action:list)
       }
        else {
					withFormat{
						html{ return [ forenkletRegistreringInstance : forenkletRegistreringInstance ] }
						xml{ render forenkletRegistreringInstance as XML }
					}
			 }
   }

    def delete = {
        def forenkletRegistreringInstance = SimplifiedRecord.get( params.id )
        if(forenkletRegistreringInstance) {
            try {
                forenkletRegistreringInstance.delete(flush:true)
                flash.message = "SimplifiedRecord ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "SimplifiedRecord ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "SimplifiedRecord not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def forenkletRegistreringInstance = SimplifiedRecord.get( params.id )

        if(!forenkletRegistreringInstance) {
            flash.message = "SimplifiedRecord not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ forenkletRegistreringInstance : forenkletRegistreringInstance, typer: registreringService.registreringTyper ]
       }
   }

    def update = {
        def (forenkletRegistreringInstance, success) = registreringService.update(params)
            if(success) {
                flash.message = "SimplifiedRecord ${params.id} updated"
								withFormat{
									html{ redirect(action:show,id:forenkletRegistreringInstance.id) }
									xml{ render forenkletRegistreringInstance as XML  }
								}
           }
            else {
							withFormat{
		              html { render(view:'edit',model:[forenkletRegistreringInstance:forenkletRegistreringInstance]) }
									xml { render text:"<errors>${forenkletRegistreringInstance.errors}</errors>", contentType:"text/xml",encoding:"UTF-8" }
							}
           }
   }

    def create = {
        def forenkletRegistreringInstance = new SimplifiedRecord()
        forenkletRegistreringInstance.properties = params
        return ['forenkletRegistreringInstance':forenkletRegistreringInstance, typer: registreringService.registreringTyper]
   }

    def save = {
				println params

				def (forenkletRegistreringInstance, error) = registreringService.registrer(params)
        if(!error) {
            flash.message = "SimplifiedRecord ${forenkletRegistreringInstance.id} created"
						withFormat {
	            html {
		            render(view: "show", model: [forenkletRegistreringInstance:forenkletRegistreringInstance] )
							}
							form {
                render(view: "show", model: [forenkletRegistreringInstance:forenkletRegistreringInstance] )
    					}          
							xml {
								render forenkletRegistreringInstance as XML
							}
							json {
								render forenkletRegistreringInstance as JSON
							}
						}
       }
        else {
            withFormat{
							html{ render(view:'create',model:[forenkletRegistreringInstance:forenkletRegistreringInstance, typer: registreringService.registreringTyper]) }
							form{ render(view:'create',model:[forenkletRegistreringInstance:forenkletRegistreringInstance, typer: registreringService.registreringTyper]) }
							xml{render text:"<errors>${forenkletRegistreringInstance.errors}</errors>", contentType:"text/xml",encoding:"UTF-8"}
						}
       }
   }
}
