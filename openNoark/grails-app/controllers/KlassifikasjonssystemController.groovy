

class KlassifikasjonssystemController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ klassifikasjonssystemInstanceList: Klassifikasjonssystem.list( params ), klassifikasjonssystemInstanceTotal: Klassifikasjonssystem.count() ]
    }

    def show = {
        def klassifikasjonssystemInstance = Klassifikasjonssystem.get( params.id )

        if(!klassifikasjonssystemInstance) {
            flash.message = "Klassifikasjonssystem not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ klassifikasjonssystemInstance : klassifikasjonssystemInstance ] }
    }

    def delete = {
        def klassifikasjonssystemInstance = Klassifikasjonssystem.get( params.id )
        if(klassifikasjonssystemInstance) {
            try {
                klassifikasjonssystemInstance.delete(flush:true)
                flash.message = "Klassifikasjonssystem ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Klassifikasjonssystem ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Klassifikasjonssystem not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def klassifikasjonssystemInstance = Klassifikasjonssystem.get( params.id )

        if(!klassifikasjonssystemInstance) {
            flash.message = "Klassifikasjonssystem not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ klassifikasjonssystemInstance : klassifikasjonssystemInstance ]
        }
    }

    def update = {
        def klassifikasjonssystemInstance = Klassifikasjonssystem.get( params.id )
        if(klassifikasjonssystemInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(klassifikasjonssystemInstance.version > version) {
                    
                    klassifikasjonssystemInstance.errors.rejectValue("version", "klassifikasjonssystem.optimistic.locking.failure", "Another user has updated this Klassifikasjonssystem while you were editing.")
                    render(view:'edit',model:[klassifikasjonssystemInstance:klassifikasjonssystemInstance])
                    return
                }
            }
            klassifikasjonssystemInstance.properties = params
            if(!klassifikasjonssystemInstance.hasErrors() && klassifikasjonssystemInstance.save()) {
                flash.message = "Klassifikasjonssystem ${params.id} updated"
                redirect(action:show,id:klassifikasjonssystemInstance.id)
            }
            else {
                render(view:'edit',model:[klassifikasjonssystemInstance:klassifikasjonssystemInstance])
            }
        }
        else {
            flash.message = "Klassifikasjonssystem not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def klassifikasjonssystemInstance = new Klassifikasjonssystem()
        klassifikasjonssystemInstance.properties = params
        return ['klassifikasjonssystemInstance':klassifikasjonssystemInstance]
    }

    def save = {
        def klassifikasjonssystemInstance = new Klassifikasjonssystem(params)
				klassifikasjonssystemInstance.systemid = UUID.randomUUID().toString()
        if(!klassifikasjonssystemInstance.hasErrors() && klassifikasjonssystemInstance.save()) {
            flash.message = "Klassifikasjonssystem ${klassifikasjonssystemInstance.id} created"
            redirect(action:show,id:klassifikasjonssystemInstance.id)
        }
        else {
            render(view:'create',model:[klassifikasjonssystemInstance:klassifikasjonssystemInstance])
        }
    }
}
