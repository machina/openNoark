

class DokumentobjektController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ dokumentobjektInstanceList: Dokumentobjekt.list( params ), dokumentobjektInstanceTotal: Dokumentobjekt.count() ]
    }

    def show = {
        def dokumentobjektInstance = Dokumentobjekt.get( params.id )

        if(!dokumentobjektInstance) {
            flash.message = "Dokumentobjekt not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ dokumentobjektInstance : dokumentobjektInstance ] }
    }

    def delete = {
        def dokumentobjektInstance = Dokumentobjekt.get( params.id )
        if(dokumentobjektInstance) {
            try {
                dokumentobjektInstance.delete(flush:true)
                flash.message = "Dokumentobjekt ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Dokumentobjekt ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Dokumentobjekt not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def dokumentobjektInstance = Dokumentobjekt.get( params.id )

        if(!dokumentobjektInstance) {
            flash.message = "Dokumentobjekt not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ dokumentobjektInstance : dokumentobjektInstance ]
        }
    }

    def update = {
        def dokumentobjektInstance = Dokumentobjekt.get( params.id )
        if(dokumentobjektInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(dokumentobjektInstance.version > version) {
                    
                    dokumentobjektInstance.errors.rejectValue("version", "dokumentobjekt.optimistic.locking.failure", "Another user has updated this Dokumentobjekt while you were editing.")
                    render(view:'edit',model:[dokumentobjektInstance:dokumentobjektInstance])
                    return
                }
            }
            dokumentobjektInstance.properties = params
            if(!dokumentobjektInstance.hasErrors() && dokumentobjektInstance.save()) {
                flash.message = "Dokumentobjekt ${params.id} updated"
                redirect(action:show,id:dokumentobjektInstance.id)
            }
            else {
                render(view:'edit',model:[dokumentobjektInstance:dokumentobjektInstance])
            }
        }
        else {
            flash.message = "Dokumentobjekt not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def dokumentobjektInstance = new Dokumentobjekt()
        dokumentobjektInstance.properties = params
        return ['dokumentobjektInstance':dokumentobjektInstance]
    }

    def save = {
        def dokumentobjektInstance = new Dokumentobjekt(params)
        if(!dokumentobjektInstance.hasErrors() && dokumentobjektInstance.save()) {
            flash.message = "Dokumentobjekt ${dokumentobjektInstance.id} created"
            redirect(action:show,id:dokumentobjektInstance.id)
        }
        else {
            render(view:'create',model:[dokumentobjektInstance:dokumentobjektInstance])
        }
    }
}
