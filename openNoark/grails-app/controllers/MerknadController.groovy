
import no.friark.ds.*
/**
* CRUD-operasjoner for Merknad
*
* @author Kent Inge Fagerland Simonsen
*/
class MerknadController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ merknadInstanceList: Merknad.list( params ), merknadInstanceTotal: Merknad.count() ]
    }

    def show = {
        def merknadInstance = Merknad.get( params.id )

        if(!merknadInstance) {
            flash.message = "Merknad not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ merknadInstance : merknadInstance ] }
    }

    def delete = {
        def merknadInstance = Merknad.get( params.id )
        if(merknadInstance) {
            try {
                merknadInstance.delete(flush:true)
                flash.message = "Merknad ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Merknad ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Merknad not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def merknadInstance = Merknad.get( params.id )

        if(!merknadInstance) {
            flash.message = "Merknad not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ merknadInstance : merknadInstance ]
        }
    }

    def update = {
        def merknadInstance = Merknad.get( params.id )
        if(merknadInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(merknadInstance.version > version) {
                    
                    merknadInstance.errors.rejectValue("version", "merknad.optimistic.locking.failure", "Another user has updated this Merknad while you were editing.")
                    render(view:'edit',model:[merknadInstance:merknadInstance])
                    return
                }
            }
            merknadInstance.properties = params
            if(!merknadInstance.hasErrors() && merknadInstance.save()) {
                flash.message = "Merknad ${params.id} updated"
                redirect(action:show,id:merknadInstance.id)
            }
            else {
                render(view:'edit',model:[merknadInstance:merknadInstance])
            }
        }
        else {
            flash.message = "Merknad not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def merknadInstance = new Merknad()
        merknadInstance.properties = params
        return ['merknadInstance':merknadInstance]
    }

    def save = {
        def merknadInstance = new Merknad(params)
        if(!merknadInstance.hasErrors() && merknadInstance.save()) {
            flash.message = "Merknad ${merknadInstance.id} created"
            redirect(action:show,id:merknadInstance.id)
        }
        else {
            render(view:'create',model:[merknadInstance:merknadInstance])
        }
    }
}
