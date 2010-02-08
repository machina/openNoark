
import no.friark.ds.*

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
