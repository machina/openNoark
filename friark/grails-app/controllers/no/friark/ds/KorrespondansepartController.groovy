

package no.friark.ds

class KorrespondansepartController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ korrespondansepartInstanceList: Korrespondansepart.list( params ), korrespondansepartInstanceTotal: Korrespondansepart.count() ]
    }

    def show = {
        def korrespondansepartInstance = Korrespondansepart.get( params.id )

        if(!korrespondansepartInstance) {
            flash.message = "Korrespondansepart not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ korrespondansepartInstance : korrespondansepartInstance ] }
    }

    def delete = {
        def korrespondansepartInstance = Korrespondansepart.get( params.id )
        if(korrespondansepartInstance) {
            try {
                korrespondansepartInstance.delete(flush:true)
                flash.message = "Korrespondansepart ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Korrespondansepart ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Korrespondansepart not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def korrespondansepartInstance = Korrespondansepart.get( params.id )

        if(!korrespondansepartInstance) {
            flash.message = "Korrespondansepart not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ korrespondansepartInstance : korrespondansepartInstance ]
        }
    }

    def update = {
        def korrespondansepartInstance = Korrespondansepart.get( params.id )
        if(korrespondansepartInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(korrespondansepartInstance.version > version) {
                    
                    korrespondansepartInstance.errors.rejectValue("version", "korrespondansepart.optimistic.locking.failure", "Another user has updated this Korrespondansepart while you were editing.")
                    render(view:'edit',model:[korrespondansepartInstance:korrespondansepartInstance])
                    return
                }
            }
            korrespondansepartInstance.properties = params
            if(!korrespondansepartInstance.hasErrors() && korrespondansepartInstance.save()) {
                flash.message = "Korrespondansepart ${params.id} updated"
                redirect(action:show,id:korrespondansepartInstance.id)
            }
            else {
                render(view:'edit',model:[korrespondansepartInstance:korrespondansepartInstance])
            }
        }
        else {
            flash.message = "Korrespondansepart not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def korrespondansepartInstance = new Korrespondansepart()
        korrespondansepartInstance.properties = params
        return ['korrespondansepartInstance':korrespondansepartInstance]
    }

    def save = {
        def korrespondansepartInstance = new Korrespondansepart(params)
        if(!korrespondansepartInstance.hasErrors() && korrespondansepartInstance.save()) {
            flash.message = "Korrespondansepart ${korrespondansepartInstance.id} created"
            redirect(action:show,id:korrespondansepartInstance.id)
        }
        else {
            render(view:'create',model:[korrespondansepartInstance:korrespondansepartInstance])
        }
    }
}
