import grails.converters.*
import no.friark.ds.*

/**
 * Her gjøres CRUD operasjoner for forskjellige mappeer.
 */
class MappeController {
    
    def index = { redirect(action:list,params:params) }
    def mappeService
    // the delete, save and update actions only accept POST requests
    //static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)

        withFormat {
            html {
                return [ basismappeInstanceList: BasicFile.list( params ), basismappeInstanceTotal: BasicFile.count() ]
            }
            xml {
                render BasicFile.list() as XML
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
                    render basismappeInstance as XML
                }
            }
        }
    }

    def delete = {
				println "DELETE: ${params}"
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
			def (file, success) = mappeService.update(params)
			if(success) {
				withFormat{
					html{ render(view:"show",[ basismappeInstance : file ])}
					xml { render file as XML }
				}
		
			} else {
				withFormat{
					html{ render(view:"edit",[ basismappeInstance : file ])}
					xml { render text:"<errors>${file.errors}</errors>", contentType:"text/xml",encoding:"UTF-8" }
				}
	
			}
    }

    def create = {
        def basismappeInstance = new BasicFile()
        basismappeInstance.properties = params
        return ['basismappeInstance':basismappeInstance, typer: mappeService.fileTypes]
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
                    render mappeInstance as XML
                }
            }
            if(!response.isCommitted()){ //content negotioation failed, default to html
                render(view:"show", model: [ basismappeInstance : mappeInstance ])
            }
        }
        else {
            println mappeInstance.errors
            render(view:'create',model:[basismappeInstance:mappeInstance, typer: mappeService.fileTypes])
        }
    }

    def sekundærKlass = {
        return [mappe: BasicFile.get(params.id)]
    }
}
