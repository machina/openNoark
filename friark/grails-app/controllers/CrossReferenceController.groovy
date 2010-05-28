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
* CRUD-operasjoner for CrossReference
*
* @author Kent Inge Fagerland Simonsen
*/
class CrossReferenceController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ kryssreferanseInstanceList: CrossReference.list( params ), kryssreferanseInstanceTotal: CrossReference.count() ]
    }

    def show = {
        def kryssreferanseInstance = CrossReference.get( params.id )

        if(!kryssreferanseInstance) {
            flash.message = "CrossReference not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ kryssreferanseInstance : kryssreferanseInstance ] }
    }

    def delete = {
        def kryssreferanseInstance = CrossReference.get( params.id )
        if(kryssreferanseInstance) {
            try {
                kryssreferanseInstance.delete(flush:true)
                flash.message = "CrossReference ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CrossReference ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "CrossReference not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def kryssreferanseInstance = CrossReference.get( params.id )

        if(!kryssreferanseInstance) {
            flash.message = "CrossReference not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ kryssreferanseInstance : kryssreferanseInstance ]
        }
    }

    def update = {
        def kryssreferanseInstance = CrossReference.get( params.id )
        if(kryssreferanseInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(kryssreferanseInstance.version > version) {
                    
                    kryssreferanseInstance.errors.rejectValue("version", "kryssreferanse.optimistic.locking.failure", "Another user has updated this CrossReference while you were editing.")
                    render(view:'edit',model:[kryssreferanseInstance:kryssreferanseInstance])
                    return
                }
            }
            kryssreferanseInstance.properties = params
            if(!kryssreferanseInstance.hasErrors() && kryssreferanseInstance.save()) {
                flash.message = "CrossReference ${params.id} updated"
                redirect(action:show,id:kryssreferanseInstance.id)
            }
            else {
                render(view:'edit',model:[kryssreferanseInstance:kryssreferanseInstance])
            }
        }
        else {
            flash.message = "CrossReference not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def kryssreferanseInstance = new CrossReference()
        kryssreferanseInstance.properties = params
        return ['kryssreferanseInstance':kryssreferanseInstance]
    }

    def save = {
        def kryssreferanseInstance = new CrossReference(params)
        if(!kryssreferanseInstance.hasErrors() && kryssreferanseInstance.save()) {
            flash.message = "CrossReference ${kryssreferanseInstance.id} created"
            redirect(action:show,id:kryssreferanseInstance.id)
        }
        else {
            render(view:'create',model:[kryssreferanseInstance:kryssreferanseInstance])
        }
    }
}
