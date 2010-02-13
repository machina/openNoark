

package no.friark.ds

class ArkivskaperController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ arkivskaperInstanceList: Arkivskaper.list( params ), arkivskaperInstanceTotal: Arkivskaper.count() ]
    }

    def show = {
        def arkivskaperInstance = Arkivskaper.get( params.id )

        if(!arkivskaperInstance) {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ arkivskaperInstance : arkivskaperInstance ] }
    }

    def delete = {
        def arkivskaperInstance = Arkivskaper.get( params.id )
        if(arkivskaperInstance) {
            try {
                arkivskaperInstance.delete(flush:true)
                flash.message = "Arkivskaper ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Arkivskaper ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def arkivskaperInstance = Arkivskaper.get( params.id )

        if(!arkivskaperInstance) {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ arkivskaperInstance : arkivskaperInstance ]
        }
    }

    def update = {
        def arkivskaperInstance = Arkivskaper.get( params.id )
        if(arkivskaperInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(arkivskaperInstance.version > version) {
                    
                    arkivskaperInstance.errors.rejectValue("version", "arkivskaper.optimistic.locking.failure", "Another user has updated this Arkivskaper while you were editing.")
                    render(view:'edit',model:[arkivskaperInstance:arkivskaperInstance])
                    return
                }
            }
            arkivskaperInstance.properties = params
            if(!arkivskaperInstance.hasErrors() && arkivskaperInstance.save()) {
                flash.message = "Arkivskaper ${params.id} updated"
                redirect(action:show,id:arkivskaperInstance.id)
            }
            else {
                render(view:'edit',model:[arkivskaperInstance:arkivskaperInstance])
            }
        }
        else {
            flash.message = "Arkivskaper not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def arkivskaperInstance = new Arkivskaper()
        arkivskaperInstance.properties = params
        return ['arkivskaperInstance':arkivskaperInstance]
    }

    def save = {
        def arkivskaperInstance = new Arkivskaper(params)
        if(!arkivskaperInstance.hasErrors() && arkivskaperInstance.save()) {
            flash.message = "Arkivskaper ${arkivskaperInstance.id} created"
            redirect(action:show,id:arkivskaperInstance.id)
        }
        else {
            render(view:'create',model:[arkivskaperInstance:arkivskaperInstance])
        }
    }
}
