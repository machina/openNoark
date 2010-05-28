

package no.friark.ds

class ClientController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ korrespondansepartInstanceList: Client.list( params ), korrespondansepartInstanceTotal: Client.count() ]
   }

    def show = {
        def korrespondansepartInstance = Client.get( params.id )

        if(!korrespondansepartInstance) {
            flash.message = "Client not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ korrespondansepartInstance : korrespondansepartInstance ] }
   }

    def delete = {
        def korrespondansepartInstance = Client.get( params.id )
        if(korrespondansepartInstance) {
            try {
                korrespondansepartInstance.delete(flush:true)
                flash.message = "Client ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Client ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "Client not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def korrespondansepartInstance = Client.get( params.id )

        if(!korrespondansepartInstance) {
            flash.message = "Client not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ korrespondansepartInstance : korrespondansepartInstance ]
       }
   }

    def update = {
        def korrespondansepartInstance = Client.get( params.id )
        if(korrespondansepartInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(korrespondansepartInstance.version > version) {
                    
                    korrespondansepartInstance.errors.rejectValue("version", "korrespondansepart.optimistic.locking.failure", "Another user has updated this Client while you were editing.")
                    render(view:'edit',model:[korrespondansepartInstance:korrespondansepartInstance])
                    return
               }
           }
            korrespondansepartInstance.properties = params
            if(!korrespondansepartInstance.hasErrors() && korrespondansepartInstance.save()) {
                flash.message = "Client ${params.id} updated"
                redirect(action:show,id:korrespondansepartInstance.id)
           }
            else {
                render(view:'edit',model:[korrespondansepartInstance:korrespondansepartInstance])
           }
       }
        else {
            flash.message = "Client not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def korrespondansepartInstance = new Client()
        korrespondansepartInstance.properties = params
        return ['korrespondansepartInstance':korrespondansepartInstance]
   }

    def save = {
        def korrespondansepartInstance = new Client(params)
        if(!korrespondansepartInstance.hasErrors() && korrespondansepartInstance.save()) {
            flash.message = "Client ${korrespondansepartInstance.id} created"
            redirect(action:show,id:korrespondansepartInstance.id)
       }
        else {
            render(view:'create',model:[korrespondansepartInstance:korrespondansepartInstance])
       }
   }
}
