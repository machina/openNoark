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
* CRUD-operasjoner for Parameter
*
* @author Kent Inge Fagerland Simonsen
*/
class ParameterController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ parameterInstanceList: Parameter.list( params ), parameterInstanceTotal: Parameter.count() ]
    }

    def show = {
        def parameterInstance = Parameter.get( params.id )

        if(!parameterInstance) {
            flash.message = "Parameter not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ parameterInstance : parameterInstance ] }
    }

    def delete = {
        def parameterInstance = Parameter.get( params.id )
        if(parameterInstance) {
            try {
                parameterInstance.delete(flush:true)
                flash.message = "Parameter ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Parameter ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Parameter not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def parameterInstance = Parameter.get( params.id )

        if(!parameterInstance) {
            flash.message = "Parameter not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ parameterInstance : parameterInstance ]
        }
    }

    def update = {
        def parameterInstance = Parameter.get( params.id )
        if(parameterInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(parameterInstance.version > version) {
                    
                    parameterInstance.errors.rejectValue("version", "parameter.optimistic.locking.failure", "Another user has updated this Parameter while you were editing.")
                    render(view:'edit',model:[parameterInstance:parameterInstance])
                    return
                }
            }
            parameterInstance.properties = params
            if(!parameterInstance.hasErrors() && parameterInstance.save()) {
                flash.message = "Parameter ${params.id} updated"
                redirect(action:show,id:parameterInstance.id)
            }
            else {
                render(view:'edit',model:[parameterInstance:parameterInstance])
            }
        }
        else {
            flash.message = "Parameter not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def parameterInstance = new Parameter()
        parameterInstance.properties = params
        return ['parameterInstance':parameterInstance]
    }

    def save = {
        def parameterInstance = new Parameter(params)
        if(!parameterInstance.hasErrors() && parameterInstance.save()) {
            flash.message = "Parameter ${parameterInstance.id} created"
            redirect(action:show,id:parameterInstance.id)
        }
        else {
            render(view:'create',model:[parameterInstance:parameterInstance])
        }
    }
}
