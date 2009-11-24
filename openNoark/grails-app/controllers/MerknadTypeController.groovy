

class MerknadTypeController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ merknadTypeInstanceList: MerknadType.list( params ), merknadTypeInstanceTotal: MerknadType.count() ]
    }

    def show = {
        def merknadTypeInstance = MerknadType.get( params.id )

        if(!merknadTypeInstance) {
            flash.message = "MerknadType not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ merknadTypeInstance : merknadTypeInstance ] }
    }

    def delete = {
        def merknadTypeInstance = MerknadType.get( params.id )
        if(merknadTypeInstance) {
            try {
                merknadTypeInstance.delete(flush:true)
                flash.message = "MerknadType ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "MerknadType ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "MerknadType not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def merknadTypeInstance = MerknadType.get( params.id )

        if(!merknadTypeInstance) {
            flash.message = "MerknadType not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ merknadTypeInstance : merknadTypeInstance ]
        }
    }

    def update = {
        def merknadTypeInstance = MerknadType.get( params.id )
        if(merknadTypeInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(merknadTypeInstance.version > version) {
                    
                    merknadTypeInstance.errors.rejectValue("version", "merknadType.optimistic.locking.failure", "Another user has updated this MerknadType while you were editing.")
                    render(view:'edit',model:[merknadTypeInstance:merknadTypeInstance])
                    return
                }
            }
            merknadTypeInstance.properties = params
            if(!merknadTypeInstance.hasErrors() && merknadTypeInstance.save()) {
                flash.message = "MerknadType ${params.id} updated"
                redirect(action:show,id:merknadTypeInstance.id)
            }
            else {
                render(view:'edit',model:[merknadTypeInstance:merknadTypeInstance])
            }
        }
        else {
            flash.message = "MerknadType not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def merknadTypeInstance = new MerknadType()
        merknadTypeInstance.properties = params
        return ['merknadTypeInstance':merknadTypeInstance]
    }

    def save = {
        def merknadTypeInstance = new MerknadType(params)
        if(!merknadTypeInstance.hasErrors() && merknadTypeInstance.save()) {
            flash.message = "MerknadType ${merknadTypeInstance.id} created"
            redirect(action:show,id:merknadTypeInstance.id)
        }
        else {
            render(view:'create',model:[merknadTypeInstance:merknadTypeInstance])
        }
    }
}
