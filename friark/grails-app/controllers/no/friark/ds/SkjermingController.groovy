package no.friark.ds

class SkjermingController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ skjermingInstanceList: Screening.list( params ), skjermingInstanceTotal: Screening.count() ]
   }

    def show = {
        def skjermingInstance = Screening.get( params.id )

        if(!skjermingInstance) {
            flash.message = "Skjerming not found with id ${params.id}"
            redirect(action:list)
       }
        else { return [ skjermingInstance : skjermingInstance ] }
   }

    def delete = {
        def skjermingInstance = Screening.get( params.id )
        if(skjermingInstance) {
            try {
                skjermingInstance.delete(flush:true)
                flash.message = "Skjerming ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Skjerming ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "Skjerming not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def skjermingInstance = Screening.get( params.id )

        if(!skjermingInstance) {
            flash.message = "Skjerming not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ skjermingInstance : skjermingInstance ]
       }
   }

    def update = {
        def skjermingInstance = Screening.get( params.id )
        if(skjermingInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(skjermingInstance.version > version) {
                    
                    skjermingInstance.errors.rejectValue("version", "skjerming.optimistic.locking.failure", "Another user has updated this Skjerming while you were editing.")
                    render(view:'edit',model:[skjermingInstance:skjermingInstance])
                    return
               }
           }
            skjermingInstance.properties = params
            if(!skjermingInstance.hasErrors() && skjermingInstance.save()) {
                flash.message = "Skjerming ${params.id} updated"
                redirect(action:show,id:skjermingInstance.id)
           }
            else {
                render(view:'edit',model:[skjermingInstance:skjermingInstance])
           }
       }
        else {
            flash.message = "Skjerming not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def skjermingInstance = new Screening()
        skjermingInstance.properties = params
        return ['skjermingInstance':skjermingInstance]
   }

    def save = {
        def skjermingInstance = new Screening(params)
				println params
        if(!skjermingInstance.hasErrors() && skjermingInstance.save()) {
            flash.message = "Skjerming ${skjermingInstance.id} created"
						params.klasser.each {
							it.skjerming = skjermingInstance
							it.save()
						}
            redirect(action:show,id:skjermingInstance.id)
       }
        else {
            render(view:'create',model:[skjermingInstance:skjermingInstance])
       }
   }
}
