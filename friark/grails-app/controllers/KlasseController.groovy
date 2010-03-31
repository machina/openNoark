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
class KlasseController {
    def commonService
		def klasseService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
				withFormat {
            html {
              return [ klasseInstanceList: Klasse.list( params ), klasseInstanceTotal: Klasse.count() ]
            }
            xml {
              render Klasse.list() as XML
            }
            json {
							println Klasse.list() as JSON
              render Klasse.list() as JSON
            }
        }
    }

    def show = {
        def klasseInstance = Klasse.get( params.id )

        if(!klasseInstance) {
            flash.message = "Klasse not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ klasseInstance : klasseInstance ] }
    }

    def delete = {
        def klasseInstance = Klasse.get( params.id )
        if(klasseInstance) {
            try {
                klasseInstance.delete(flush:true)
                flash.message = "Klasse ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Klasse ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Klasse not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def klasseInstance = Klasse.get( params.id )

        if(!klasseInstance) {
            flash.message = "Klasse not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ klasseInstance : klasseInstance ]
        }
    }

    def update = {
        def klasseInstance = Klasse.get( params.id )
				boolean success = false
        if(klasseInstance) {
						(klasseInstance, success) = klasseService.update(klasseInstance, params)
            if(success) {
                flash.message = "Klasse ${params.id} updated"
                redirect(action:show,id:klasseInstance.id)
            }
            else {
                render(view:'edit',model:[klasseInstance:klasseInstance])
            }
        }
        else {
            flash.message = "Klasse not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def klasseInstance = new Klasse()
        klasseInstance.properties = params
        return ['klasseInstance':klasseInstance]
    }

    def save = {
				def (klasseInstance, success) = klasseService.save(params)
				if(success) {
            flash.message = "Klasse ${klasseInstance.id} created"
            redirect(action:show,id:klasseInstance.id)
        }
        else {
            render(view:'create',model:[klasseInstance:klasseInstance])
        }
    }
}
