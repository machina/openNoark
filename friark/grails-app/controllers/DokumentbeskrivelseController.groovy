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
* CRUD opereasjoner på Dokumentbeskrivelse
*/
class DokumentbeskrivelseController {
 		def commonService  
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ dokumentbeskrivelseInstanceList: Dokumentbeskrivelse.list( params ), dokumentbeskrivelseInstanceTotal: Dokumentbeskrivelse.count() ]
    }

    def show = {
        def dokumentbeskrivelseInstance = Dokumentbeskrivelse.get( params.id )

        if(!dokumentbeskrivelseInstance) {
            flash.message = "Dokumentbeskrivelse not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ dokumentbeskrivelseInstance : dokumentbeskrivelseInstance ] }
    }

    def delete = {
        def dokumentbeskrivelseInstance = Dokumentbeskrivelse.get( params.id )
        if(dokumentbeskrivelseInstance) {
            try {
                dokumentbeskrivelseInstance.delete(flush:true)
                flash.message = "Dokumentbeskrivelse ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Dokumentbeskrivelse ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Dokumentbeskrivelse not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def dokumentbeskrivelseInstance = Dokumentbeskrivelse.get( params.id )

        if(!dokumentbeskrivelseInstance) {
            flash.message = "Dokumentbeskrivelse not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ dokumentbeskrivelseInstance : dokumentbeskrivelseInstance ]
        }
    }

    def update = {
        def dokumentbeskrivelseInstance = Dokumentbeskrivelse.get( params.id )
        if(dokumentbeskrivelseInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(dokumentbeskrivelseInstance.version > version) {
                    
                    dokumentbeskrivelseInstance.errors.rejectValue("version", "dokumentbeskrivelse.optimistic.locking.failure", "Another user has updated this Dokumentbeskrivelse while you were editing.")
                    render(view:'edit',model:[dokumentbeskrivelseInstance:dokumentbeskrivelseInstance])
                    return
                }
            }
            dokumentbeskrivelseInstance.properties = params
            if(!dokumentbeskrivelseInstance.hasErrors() && dokumentbeskrivelseInstance.save()) {
                flash.message = "Dokumentbeskrivelse ${params.id} updated"
                redirect(action:show,id:dokumentbeskrivelseInstance.id)
            }
            else {
                render(view:'edit',model:[dokumentbeskrivelseInstance:dokumentbeskrivelseInstance])
            }
        }
        else {
            flash.message = "Dokumentbeskrivelse not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def dokumentbeskrivelseInstance = new Dokumentbeskrivelse()
        dokumentbeskrivelseInstance.properties = params
        return ['dokumentbeskrivelseInstance':dokumentbeskrivelseInstance]
    }

    def save = {
        def dokumentbeskrivelseInstance = new Dokumentbeskrivelse(params)
				commonService.setNewSystemID dokumentbeskrivelseInstance
        if(!dokumentbeskrivelseInstance.hasErrors() && dokumentbeskrivelseInstance.save()) {
            flash.message = "Dokumentbeskrivelse ${dokumentbeskrivelseInstance.id} created"
            redirect(action:show,id:dokumentbeskrivelseInstance.id)
        }
        else {
            render(view:'create',model:[dokumentbeskrivelseInstance:dokumentbeskrivelseInstance])
        }
    }
}
