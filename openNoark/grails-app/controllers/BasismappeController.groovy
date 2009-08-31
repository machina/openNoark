import grails.converters.*

class BasismappeController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
			  params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)

				withFormat {
						html {
			 	      return [ basismappeInstanceList: Basismappe.list( params ), basismappeInstanceTotal: Basismappe.count() ]
						}
						xml {
							render Basismappe.list() as XML
						}
						json {
							render Basismappe.list() as JSON
						}
				}
    }

    def show = {
        def basismappeInstance = Basismappe.get( params.id )
		
        if(!basismappeInstance) {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ basismappeInstance : basismappeInstance ] }
    }

    def delete = {
        def basismappeInstance = Basismappe.get( params.id )
        if(basismappeInstance) {
            try {
                basismappeInstance.delete(flush:true)
                flash.message = "Basismappe ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Basismappe ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def basismappeInstance = Basismappe.get( params.id )

        if(!basismappeInstance) {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ basismappeInstance : basismappeInstance ]
        }
    }

    def update = {
        def basismappeInstance = Basismappe.get( params.id )
        if(basismappeInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(basismappeInstance.version > version) {
                    
                    basismappeInstance.errors.rejectValue("version", "basismappe.optimistic.locking.failure", "Another user has updated this Basismappe while you were editing.")
                    render(view:'edit',model:[basismappeInstance:basismappeInstance])
                    return
                }
            }
            basismappeInstance.properties = params
            if(!basismappeInstance.hasErrors() && basismappeInstance.save()) {
                flash.message = "Basismappe ${params.id} updated"
                redirect(action:show,id:basismappeInstance.id)
            }
            else {
                render(view:'edit',model:[basismappeInstance:basismappeInstance])
            }
        }
        else {
            flash.message = "Basismappe not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def basismappeInstance = new Basismappe()
        basismappeInstance.properties = params
        return ['basismappeInstance':basismappeInstance]
    }

    def save = {
        def basismappeInstance = new Basismappe(params)
				basismappeInstance.systemid = UUID.randomUUID().toString()

        if(!basismappeInstance.hasErrors() && basismappeInstance.save()) {
            flash.message = "Basismappe ${basismappeInstance.id} created"
						withFormat {
	            html {
		            redirect(action:show,id:basismappeInstance.id)
							}
							xml {
								render basismappeInstance as XML
							}
						}
        }
        else {
            render(view:'create',model:[basismappeInstance:basismappeInstance])
        }
    }
}
