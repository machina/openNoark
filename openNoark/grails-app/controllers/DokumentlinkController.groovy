
import no.friark.ds.*
class DokumentlinkController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ dokumentlinkInstanceList: Dokumentlink.list( params ), dokumentlinkInstanceTotal: Dokumentlink.count() ]
    }

    def show = {
        def dokumentlinkInstance = Dokumentlink.get( params.id )

        if(!dokumentlinkInstance) {
            flash.message = "Dokumentlink not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ dokumentlinkInstance : dokumentlinkInstance ] }
    }

    def delete = {
        def dokumentlinkInstance = Dokumentlink.get( params.id )
        if(dokumentlinkInstance) {
            try {
                dokumentlinkInstance.delete(flush:true)
                flash.message = "Dokumentlink ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Dokumentlink ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Dokumentlink not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def dokumentlinkInstance = Dokumentlink.get( params.id )

        if(!dokumentlinkInstance) {
            flash.message = "Dokumentlink not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ dokumentlinkInstance : dokumentlinkInstance ]
        }
    }

    def update = {
        def dokumentlinkInstance = Dokumentlink.get( params.id )
        if(dokumentlinkInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(dokumentlinkInstance.version > version) {
                    
                    dokumentlinkInstance.errors.rejectValue("version", "dokumentlink.optimistic.locking.failure", "Another user has updated this Dokumentlink while you were editing.")
                    render(view:'edit',model:[dokumentlinkInstance:dokumentlinkInstance])
                    return
                }
            }
            dokumentlinkInstance.properties = params
            if(!dokumentlinkInstance.hasErrors() && dokumentlinkInstance.save()) {
                flash.message = "Dokumentlink ${params.id} updated"
                redirect(action:show,id:dokumentlinkInstance.id)
            }
            else {
                render(view:'edit',model:[dokumentlinkInstance:dokumentlinkInstance])
            }
        }
        else {
            flash.message = "Dokumentlink not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def dokumentlinkInstance = new Dokumentlink()
        dokumentlinkInstance.properties = params
        return ['dokumentlinkInstance':dokumentlinkInstance]
    }

    def save = {
        def dokumentlinkInstance = new Dokumentlink(params)
        if(!dokumentlinkInstance.hasErrors() && dokumentlinkInstance.save()) {
            flash.message = "Dokumentlink ${dokumentlinkInstance.id} created"
            redirect(action:show,id:dokumentlinkInstance.id)
        }
        else {
            render(view:'create',model:[dokumentlinkInstance:dokumentlinkInstance])
        }
    }
}
