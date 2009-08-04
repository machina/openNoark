

class ForenkletRegistreringController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ forenkletRegistreringInstanceList: ForenkletRegistrering.list( params ), forenkletRegistreringInstanceTotal: ForenkletRegistrering.count() ]
    }

    def show = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )

        if(!forenkletRegistreringInstance) {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ forenkletRegistreringInstance : forenkletRegistreringInstance ] }
    }

    def delete = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )
        if(forenkletRegistreringInstance) {
            try {
                forenkletRegistreringInstance.delete(flush:true)
                flash.message = "ForenkletRegistrering ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "ForenkletRegistrering ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )

        if(!forenkletRegistreringInstance) {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ forenkletRegistreringInstance : forenkletRegistreringInstance ]
        }
    }

    def update = {
        def forenkletRegistreringInstance = ForenkletRegistrering.get( params.id )
        if(forenkletRegistreringInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(forenkletRegistreringInstance.version > version) {
                    
                    forenkletRegistreringInstance.errors.rejectValue("version", "forenkletRegistrering.optimistic.locking.failure", "Another user has updated this ForenkletRegistrering while you were editing.")
                    render(view:'edit',model:[forenkletRegistreringInstance:forenkletRegistreringInstance])
                    return
                }
            }
            forenkletRegistreringInstance.properties = params
            if(!forenkletRegistreringInstance.hasErrors() && forenkletRegistreringInstance.save()) {
                flash.message = "ForenkletRegistrering ${params.id} updated"
                redirect(action:show,id:forenkletRegistreringInstance.id)
            }
            else {
                render(view:'edit',model:[forenkletRegistreringInstance:forenkletRegistreringInstance])
            }
        }
        else {
            flash.message = "ForenkletRegistrering not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def forenkletRegistreringInstance = new ForenkletRegistrering()
        forenkletRegistreringInstance.properties = params
        return ['forenkletRegistreringInstance':forenkletRegistreringInstance]
    }

    def save = {
        def forenkletRegistreringInstance = new ForenkletRegistrering(params)
        if(!forenkletRegistreringInstance.hasErrors() && forenkletRegistreringInstance.save()) {
            flash.message = "ForenkletRegistrering ${forenkletRegistreringInstance.id} created"
            redirect(action:show,id:forenkletRegistreringInstance.id)
        }
        else {
            render(view:'create',model:[forenkletRegistreringInstance:forenkletRegistreringInstance])
        }
    }
}
