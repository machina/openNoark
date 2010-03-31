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
* CRUD-operasjoner for ForenkletRegistrering
*
* @author Kent Inge Fagerland Simonsen
*/
class RegistreringController {

	def commonService
 	def registreringService   
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ forenkletRegistreringInstanceList: ForenkletRegistrering.list( params ), forenkletRegistreringInstanceTotal: ForenkletRegistrering.count() ]
    }

    def show = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )

        if(!forenkletRegistreringInstance) {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ forenkletRegistreringInstance : forenkletRegistreringInstance ] }
    }

    def delete = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )
        if(forenkletRegistreringInstance) {
            try {
                forenkletRegistreringInstance.delete(flush:true)
                flash.message = "ForenkletRegistrering ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "ForenkletRegistrering ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )

        if(!forenkletRegistreringInstance) {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ forenkletRegistreringInstance : forenkletRegistreringInstance ]
        }
    }

    def update = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )
        if(forenkletRegistreringInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(forenkletRegistreringInstance.version > version) {
                    
                    forenkletRegistreringInstance.errors.rejectValue("version", "forenkletRegistrering.optimistic.locking.failure", "Another user has updated this ForenkletRegistrering while you were editing.")
                    render(view:'edit',model:[forenkletRegistreringInstance:forenkletRegistreringInstance])
                    return
                }
            }
            forenkletRegistreringInstance.properties = params
            if(!forenkletRegistreringInstance.hasErrors() && forenkletRegistreringInstance.save()) {
                flash.message = "ForenkletRegistrering ${params.id} updated"
                redirect(action:show,id:forenkletRegistreringInstance.id)
            }
            else {
                render(view:'edit',model:[forenkletRegistreringInstance:forenkletRegistreringInstance])
            }
        }
        else {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def forenkletRegistreringInstance = new ForenkletRegistrering()
        forenkletRegistreringInstance.properties = params
        return ['forenkletRegistreringInstance':forenkletRegistreringInstance]
    }

    def save = {
				println params

				def (forenkletRegistreringInstance, error) = registreringService.registrer(params)
        if(!error) {
            flash.message = "ForenkletRegistrering ${forenkletRegistreringInstance.id} created"
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
            render(view:'create',model:[forenkletRegistreringInstance:forenkletRegistreringInstance])
        }
    }
}
