

class KryssreferanseController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ kryssreferanseInstanceList: Kryssreferanse.list( params ), kryssreferanseInstanceTotal: Kryssreferanse.count() ]
    }

    def show = {
        def kryssreferanseInstance = Kryssreferanse.get( params.id )

        if(!kryssreferanseInstance) {
            flash.message = "Kryssreferanse not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ kryssreferanseInstance : kryssreferanseInstance ] }
    }

    def delete = {
        def kryssreferanseInstance = Kryssreferanse.get( params.id )
        if(kryssreferanseInstance) {
            try {
                kryssreferanseInstance.delete(flush:true)
                flash.message = "Kryssreferanse ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Kryssreferanse ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Kryssreferanse not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def kryssreferanseInstance = Kryssreferanse.get( params.id )

        if(!kryssreferanseInstance) {
            flash.message = "Kryssreferanse not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ kryssreferanseInstance : kryssreferanseInstance ]
        }
    }

    def update = {
        def kryssreferanseInstance = Kryssreferanse.get( params.id )
        if(kryssreferanseInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(kryssreferanseInstance.version > version) {
                    
                    kryssreferanseInstance.errors.rejectValue("version", "kryssreferanse.optimistic.locking.failure", "Another user has updated this Kryssreferanse while you were editing.")
                    render(view:'edit',model:[kryssreferanseInstance:kryssreferanseInstance])
                    return
                }
            }
            kryssreferanseInstance.properties = params
            if(!kryssreferanseInstance.hasErrors() && kryssreferanseInstance.save()) {
                flash.message = "Kryssreferanse ${params.id} updated"
                redirect(action:show,id:kryssreferanseInstance.id)
            }
            else {
                render(view:'edit',model:[kryssreferanseInstance:kryssreferanseInstance])
            }
        }
        else {
            flash.message = "Kryssreferanse not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def kryssreferanseInstance = new Kryssreferanse()
        kryssreferanseInstance.properties = params
        return ['kryssreferanseInstance':kryssreferanseInstance]
    }

    def save = {
        def kryssreferanseInstance = new Kryssreferanse(params)
        if(!kryssreferanseInstance.hasErrors() && kryssreferanseInstance.save()) {
            flash.message = "Kryssreferanse ${kryssreferanseInstance.id} created"
            redirect(action:show,id:kryssreferanseInstance.id)
        }
        else {
            render(view:'create',model:[kryssreferanseInstance:kryssreferanseInstance])
        }
    }
}
