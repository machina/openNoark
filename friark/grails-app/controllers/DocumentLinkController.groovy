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
class DocumentLinkController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ dokumentlinkInstanceList: DocumentLink.list( params ), dokumentlinkInstanceTotal: DocumentLink.count() ]
    }

    def show = {
        def dokumentlinkInstance = DocumentLink.get( params.id )

        if(!dokumentlinkInstance) {
            flash.message = "DocumentLink not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ dokumentlinkInstance : dokumentlinkInstance ] }
    }

    def delete = {
        def dokumentlinkInstance = DocumentLink.get( params.id )
        if(dokumentlinkInstance) {
            try {
                dokumentlinkInstance.delete(flush:true)
                flash.message = "DocumentLink ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "DocumentLink ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "DocumentLink not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def dokumentlinkInstance = DocumentLink.get( params.id )

        if(!dokumentlinkInstance) {
            flash.message = "DocumentLink not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ dokumentlinkInstance : dokumentlinkInstance ]
        }
    }

    def update = {
        def dokumentlinkInstance = DocumentLink.get( params.id )
        if(dokumentlinkInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(dokumentlinkInstance.version > version) {
                    
                    dokumentlinkInstance.errors.rejectValue("version", "dokumentlink.optimistic.locking.failure", "Another user has updated this DocumentLink while you were editing.")
                    render(view:'edit',model:[dokumentlinkInstance:dokumentlinkInstance])
                    return
                }
            }
            dokumentlinkInstance.properties = params
            if(!dokumentlinkInstance.hasErrors() && dokumentlinkInstance.save()) {
                flash.message = "DocumentLink ${params.id} updated"
                redirect(action:show,id:dokumentlinkInstance.id)
            }
            else {
                render(view:'edit',model:[dokumentlinkInstance:dokumentlinkInstance])
            }
        }
        else {
            flash.message = "DocumentLink not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def dokumentlinkInstance = new DocumentLink()
        dokumentlinkInstance.properties = params
        return ['dokumentlinkInstance':dokumentlinkInstance]
    }

    def save = {
        def dokumentlinkInstance = new DocumentLink(params)
        if(!dokumentlinkInstance.hasErrors() && dokumentlinkInstance.save()) {
            flash.message = "DocumentLink ${dokumentlinkInstance.id} created"
            redirect(action:show,id:dokumentlinkInstance.id)
        }
        else {
            render(view:'create',model:[dokumentlinkInstance:dokumentlinkInstance])
        }
    }
}
