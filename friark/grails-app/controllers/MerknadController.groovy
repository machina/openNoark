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
* CRUD-operasjoner for Remark
*
* @author Kent Inge Fagerland Simonsen
*/
class MerknadController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ merknadInstanceList: Remark.list( params ), merknadInstanceTotal: Remark.count() ]
   }

    def show = {
        def merknadInstance = Remark.get( params.id )

        if(!merknadInstance) {
            flash.message = "Remark not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ merknadInstance : merknadInstance ] }
   }

    def delete = {
        def merknadInstance = Remark.get( params.id )
        if(merknadInstance) {
            try {
                merknadInstance.delete(flush:true)
                flash.message = "Remark ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Remark ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "Remark not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def merknadInstance = Remark.get( params.id )

        if(!merknadInstance) {
            flash.message = "Remark not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ merknadInstance : merknadInstance ]
       }
   }

    def update = {
        def merknadInstance = Remark.get( params.id )
        if(merknadInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(merknadInstance.version > version) {
                    
                    merknadInstance.errors.rejectValue("version", "merknad.optimistic.locking.failure", "Another user has updated this Remark while you were editing.")
                    render(view:'edit',model:[merknadInstance:merknadInstance])
                    return
               }
           }
            merknadInstance.properties = params
            if(!merknadInstance.hasErrors() && merknadInstance.save()) {
                flash.message = "Remark ${params.id} updated"
                redirect(action:show,id:merknadInstance.id)
           }
            else {
                render(view:'edit',model:[merknadInstance:merknadInstance])
           }
       }
        else {
            flash.message = "Remark not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def merknadInstance = new Remark()
        merknadInstance.properties = params
        return ['merknadInstance':merknadInstance]
   }

    def save = {
        def merknadInstance = new Remark(params)
        if(!merknadInstance.hasErrors() && merknadInstance.save()) {
            flash.message = "Remark ${merknadInstance.id} created"
            redirect(action:show,id:merknadInstance.id)
       }
        else {
            render(view:'create',model:[merknadInstance:merknadInstance])
       }
   }
}
