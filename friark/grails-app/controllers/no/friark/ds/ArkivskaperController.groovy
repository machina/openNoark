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
        [ arkivskaperInstanceList: Arkivskaper.list( params ), arkivskaperInstanceTotal: Arkivskaper.count() ]
   }

    def show = {
        def arkivskaperInstance = Arkivskaper.get( params.id )

        if(!arkivskaperInstance) {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ arkivskaperInstance : arkivskaperInstance ] }
   }

    def delete = {
        def arkivskaperInstance = Arkivskaper.get( params.id )
        if(arkivskaperInstance) {
            try {
                arkivskaperInstance.delete(flush:true)
                flash.message = "Arkivskaper ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Arkivskaper ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def arkivskaperInstance = Arkivskaper.get( params.id )

        if(!arkivskaperInstance) {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ arkivskaperInstance : arkivskaperInstance ]
       }
   }

    def update = {
        def arkivskaperInstance = Arkivskaper.get( params.id )
        if(arkivskaperInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(arkivskaperInstance.version > version) {
                    
                    arkivskaperInstance.errors.rejectValue("version", "arkivskaper.optimistic.locking.failure", "Another user has updated this Arkivskaper while you were editing.")
                    render(view:'edit',model:[arkivskaperInstance:arkivskaperInstance])
                    return
               }
           }
            arkivskaperInstance.properties = params
            if(!arkivskaperInstance.hasErrors() && arkivskaperInstance.save()) {
                flash.message = "Arkivskaper ${params.id} updated"
                redirect(action:show,id:arkivskaperInstance.id)
           }
            else {
                render(view:'edit',model:[arkivskaperInstance:arkivskaperInstance])
           }
       }
        else {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def arkivskaperInstance = new FondsCreator()
        arkivskaperInstance.properties = params
        return ['arkivskaperInstance':arkivskaperInstance]
   }

    def save = {
        def arkivskaperInstance = new FondsCreator(params)
        if(!arkivskaperInstance.hasErrors() && arkivskaperInstance.save()) {
            flash.message = "Arkivskaper ${arkivskaperInstance.id} created"
            redirect(action:show,id:arkivskaperInstance.id)
       }
        else {
            render(view:'create',model:[arkivskaperInstance:arkivskaperInstance])
       }
   }
}
