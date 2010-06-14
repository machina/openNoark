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
import org.apache.shiro.SecurityUtils
/**
* CRUD-operasjoner for klasser.
*
* @author Kent Inge Fagerland Simonsen
*/
class KlassController {
    def commonService
		def klasseService
    def index = { redirect(action:list,params:params) }


    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				withFormat {
            html {
              return [ klasseInstanceList: Klass.list( params ), klasseInstanceTotal: Klass.count() ]
            }
            xml {
              render Klass.list() as XML
            }
            json {
							println Klass.list() as JSON
              render Klass.list() as JSON
            }
        }
    }

    def show = {
        def klasseInstance = Klass.get( params.id )

        if(!klasseInstance) {
            flash.message = "Klass not found with id ${params.id}"
            redirect(action:list)
        }
        else {
					withFormat {
						html {return [ klasseInstance : klasseInstance ]}
						xml { render klasseInstance as XML}
					}
			 }
    }

    def delete = {
        def klasseInstance = Klass.get( params.id )
        if(klasseInstance) {
            try {
                klasseInstance.delete(flush:true)
                flash.message = "Klass ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Klass ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Klass not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def klasseInstance = Klass.get( params.id )

        if(!klasseInstance) {
            flash.message = "Klass not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ klasseInstance : klasseInstance ]
        }
    }

    def update = {
        def klasseInstance = Klass.get( params.id != null ? params.id : params.klass.id )
				boolean success = false
        if(klasseInstance) {
						(klasseInstance, success) = klasseService.update(klasseInstance, params)
            if(success) {
							println "Saved Klass: ${klasseInstance}"
                flash.message = "Klass ${params.id} updated"
							withFormat{
		            html {  redirect(action:show,id:klasseInstance.id) }
								xml {render klasseInstance as XML }
							}
            }
            else {
								withFormat{
			            html { render(view:'edit',model:[klasseInstance:klasseInstance]) }
									xml { render text:"<errors>${klasseInstance.errors}</errors>", contentType:"text/xml",encoding:"UTF-8" }
								}
            }
        }
        else {
            flash.message = "Klass not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def klasseInstance = new Klass()
        klasseInstance.properties = params
        return ['klasseInstance':klasseInstance]
    }

    def save = {
				def (klasseInstance, success) = klasseService.save(params)
				if(success) {
            flash.message = "Klass ${klasseInstance.id} created"
						withFormat{
							html{ redirect(action:show,id:klasseInstance.id) }
							xml { render klasseInstance as XML }
						}
        }
        else {
					withFormat{
						html { render(view:'create',model:[klasseInstance:klasseInstance]) }
						xml { render text:"<errors>${klasseInstance.errors}</errors>", contentType:"text/xml",encoding:"UTF-8" }
					}
        }
    }
}
