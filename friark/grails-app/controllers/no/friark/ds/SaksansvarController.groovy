

package no.friark.ds

class SaksansvarController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ saksansvarInstanceList: CaseResponsibility.list( params ), saksansvarInstanceTotal: CaseResponsibility.count() ]
   }

    def show = {
        def saksansvarInstance = CaseResponsibility.get( params.id )

        if(!saksansvarInstance) {
            flash.message = "CaseResponsibility not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ saksansvarInstance : saksansvarInstance ] }
   }

    def delete = {
        def saksansvarInstance = CaseResponsibility.get( params.id )
        if(saksansvarInstance) {
            try {
                saksansvarInstance.delete(flush:true)
                flash.message = "CaseResponsibility ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "CaseResponsibility ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "CaseResponsibility not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def saksansvarInstance = CaseResponsibility.get( params.id )

        if(!saksansvarInstance) {
            flash.message = "CaseResponsibility not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ saksansvarInstance : saksansvarInstance ]
       }
   }

    def update = {
        def saksansvarInstance = CaseResponsibility.get( params.id )
        if(saksansvarInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(saksansvarInstance.version > version) {
                    
                    saksansvarInstance.errors.rejectValue("version", "saksansvar.optimistic.locking.failure", "Another user has updated this CaseResponsibility while you were editing.")
                    render(view:'edit',model:[saksansvarInstance:saksansvarInstance])
                    return
               }
           }
            saksansvarInstance.properties = params
            if(!saksansvarInstance.hasErrors() && saksansvarInstance.save()) {
                flash.message = "CaseResponsibility ${params.id} updated"
                redirect(action:show,id:saksansvarInstance.id)
           }
            else {
                render(view:'edit',model:[saksansvarInstance:saksansvarInstance])
           }
       }
        else {
            flash.message = "CaseResponsibility not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def saksansvarInstance = new CaseResponsibility()
        saksansvarInstance.properties = params
        return ['saksansvarInstance':saksansvarInstance]
   }

    def save = {
        def saksansvarInstance = new CaseResponsibility(params)
        if(!saksansvarInstance.hasErrors() && saksansvarInstance.save()) {
            flash.message = "CaseResponsibility ${saksansvarInstance.id} created"
            redirect(action:show,id:saksansvarInstance.id)
       }
        else {
            render(view:'create',model:[saksansvarInstance:saksansvarInstance])
       }
   }
}
