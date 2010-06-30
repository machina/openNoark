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



package no.friark.ds

/**
* CRUD opereasjoner for arkivskapere.
*/
class ArkivskaperController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ fondsCreatorInstanceList: FondsCreator.list( params ), fondsCreatorInstanceTotal: FondsCreator.count() ]
   }

    def show = {
        def fondsCreatorInstance = FondsCreator.get( params.id )

        if(!fondsCreatorInstance) {
            flash.message = "FondsCreator not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ fondsCreatorInstance : fondsCreatorInstance ] }
   }

    def delete = {
        def fondsCreatorInstance = FondsCreator.get( params.id )
        if(fondsCreatorInstance) {
            try {
                fondsCreatorInstance.delete(flush:true)
                flash.message = "FondsCreator ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "FondsCreator ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "FondsCreator not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def fondsCreatorInstance = FondsCreator.get( params.id )

        if(!fondsCreatorInstance) {
            flash.message = "FondsCreator not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ fondsCreatorInstance : fondsCreatorInstance ]
       }
   }

    def update = {
        def fondsCreatorInstance = FondsCreator.get( params.id )
        if(fondsCreatorInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(fondsCreatorInstance.version > version) {
                    
                    fondsCreatorInstance.errors.rejectValue("version", "arkivskaper.optimistic.locking.failure", "Another user has updated this FondsCreator while you were editing.")
                    render(view:'edit',model:[fondsCreatorInstance:fondsCreatorInstance])
                    return
               }
           }
            fondsCreatorInstance.properties = params
            if(!fondsCreatorInstance.hasErrors() && fondsCreatorInstance.save()) {
                flash.message = "FondsCreator ${params.id} updated"
                redirect(action:show,id:fondsCreatorInstance.id)
           }
            else {
                render(view:'edit',model:[fondsCreatorInstance:fondsCreatorInstance])
           }
       }
        else {
            flash.message = "FondsCreator not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def fondsCreatorInstance = new FondsCreator()
        fondsCreatorInstance.properties = params
        return ['fondsCreatorInstance':fondsCreatorInstance]
   }

    def save = {
        def fondsCreatorInstance = new FondsCreator(params)
        if(!fondsCreatorInstance.hasErrors() && fondsCreatorInstance.save()) {
            flash.message = "FondsCreator ${fondsCreatorInstance.id} created"
            redirect(action:show,id:fondsCreatorInstance.id)
       }
        else {
            render(view:'create',model:[fondsCreatorInstance:fondsCreatorInstance])
       }
   }
}
