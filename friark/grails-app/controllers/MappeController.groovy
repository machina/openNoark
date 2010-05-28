import grails.converters.*
import no.friark.ds.*

/**
* Her gjøres CRUD operasjoner for forskjellige mappeer.
*/
class MappeController {
    
    def index = { redirect(action:list,params:params) }
		def mappeService
    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
			  params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)

				withFormat {
						html {
			 	      return [ basismappeInstanceList: BasicFile.list( params ), basismappeInstanceTotal: BasicFile.count() ]
						}
						xml {
							render (text: BasicFile.list() as XML, encoding: "UTF-8")
						}
						json {
							render BasicFile.list() as JSON
						}
				}
   }

    def show = {
        def basismappeInstance = BasicFile.get( params.id )
        if(!basismappeInstance) {
            flash.message = "BasicFile not found with id ${params.id}"
            redirect(action:list)
       }
        else { 
					withFormat {
            html {
							return [ basismappeInstance : basismappeInstance ] 
						}
						xml {
							render (text: basismappeInstance as XML, encoding: "UTF-8")
						}
					}
				}
   }

    def delete = {
        def basismappeInstance = BasicFile.get( params.id )
        if(basismappeInstance) {
            try {
                basismappeInstance.delete(flush:true)
                flash.message = "BasicFile ${params.id} deleted"
                redirect(action:list)
           }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "BasicFile ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
           }
       }
        else {
            flash.message = "BasicFile not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def edit = {
        def basismappeInstance = BasicFile.get( params.id )

        if(!basismappeInstance) {
            flash.message = "BasicFile not found with id ${params.id}"
            redirect(action:list)
       }
        else {
            return [ basismappeInstance : basismappeInstance ]
       }
   }

    def update = {
        def basismappeInstance = BasicFile.get( params.id )
        if(basismappeInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(basismappeInstance.version > version) {
                    
                    basismappeInstance.errors.rejectValue("version", "basismappe.optimistic.locking.failure", "Another user has updated this BasicFile while you were editing.")
                    render(view:'edit',model:[basismappeInstance:basismappeInstance])
                    return
               }
           }
            basismappeInstance.properties = params
            if(!basismappeInstance.hasErrors() && basismappeInstance.save()) {
                flash.message = "BasicFile ${params.id} updated"
                redirect(action:show,id:basismappeInstance.id)
           }
            else {
                render(view:'edit',model:[basismappeInstance:basismappeInstance])
           }
       }
        else {
            flash.message = "BasicFile not found with id ${params.id}"
            redirect(action:list)
       }
   }

    def create = {
        def basismappeInstance = new BasicFile()
        basismappeInstance.properties = params
        return ['basismappeInstance':basismappeInstance, typer: mappeService.fileTyper]
   }

    def save = {
				def (mappeInstance, success) = mappeService.save(params)
        if(success) {
            flash.message = "Mappe ${mappeInstance.id} created"
						withFormat {
	            html {
		            render(view:"show",[ basismappeInstance : mappeInstance ])
							}
							xml {
								render basismappeInstance as XML
							}
						}
					 if(!response.isCommitted()){ //content negotioation failed, default to html
						render(view:"show", model: [ basismappeInstance : mappeInstance ])
					 }
       }
        else {
						println mappeInstance.errors
            render(view:'create',model:[basismappeInstance:mappeInstance, typer: mappeService.fileTyper])
       }
   }

		def sekundærKlass = {
			return [mappe: BasicFile.get(params.id)]
		}
}
