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
import no.friark.ds.*

/**
* Her gjøres CRUD operasjoner for Basismappe.
*/
class BasismappeController {
    
    def index = { redirect(action:list,params:params) }
		def mappeService
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
			  params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)

				withFormat {
						html {
			 	      return [ basismappeInstanceList: Basismappe.list( params ), basismappeInstanceTotal: Basismappe.count() ]
						}
						xml {
							render (text: Basismappe.list() as XML, encoding: "UTF-8")
						}
						json {
							render Basismappe.list() as JSON
						}
				}
    }

    def show = {
        def basismappeInstance = Basismappe.get( params.id )
		
        if(!basismappeInstance) {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
        else { 
					withFormat {
            html {
							return [ basismappeInstance : basismappeInstance ] 
						}
						xml {
							render (text: basismappeInstance as XML, encoding: "UTF-8")
						}
					}
				}
    }

    def delete = {
        def basismappeInstance = Basismappe.get( params.id )
        if(basismappeInstance) {
            try {
                basismappeInstance.delete(flush:true)
                flash.message = "Basismappe ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Basismappe ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def basismappeInstance = Basismappe.get( params.id )

        if(!basismappeInstance) {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ basismappeInstance : basismappeInstance ]
        }
    }

    def update = {
        def basismappeInstance = Basismappe.get( params.id )
        if(basismappeInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(basismappeInstance.version > version) {
                    
                    basismappeInstance.errors.rejectValue("version", "basismappe.optimistic.locking.failure", "Another user has updated this Basismappe while you were editing.")
                    render(view:'edit',model:[basismappeInstance:basismappeInstance])
                    return
                }
            }
            basismappeInstance.properties = params
            if(!basismappeInstance.hasErrors() && basismappeInstance.save()) {
                flash.message = "Basismappe ${params.id} updated"
                redirect(action:show,id:basismappeInstance.id)
            }
            else {
                render(view:'edit',model:[basismappeInstance:basismappeInstance])
            }
        }
        else {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def basismappeInstance = new Basismappe()
        basismappeInstance.properties = params
        return ['basismappeInstance':basismappeInstance]
    }

    def save = {
				println params
				def (basismappeInstance, success) = mappeService.save(params)
	
        if(success) {
            flash.message = "Basismappe ${basismappeInstance.id} created"
						withFormat {
	            html {
		            render(view:"show",[ basismappeInstance : basismappeInstance ])
							}
							xml {
								render basismappeInstance as XML
							}
						}
					 if(!response.isCommitted()){ //content negotioation failed, default to html
						render(view:"show", model: [ basismappeInstance : basismappeInstance ])
					 }
        }
        else {
						println basismappeInstance.errors
            render(view:'create',model:[basismappeInstance:basismappeInstance])
        }
    }
}
