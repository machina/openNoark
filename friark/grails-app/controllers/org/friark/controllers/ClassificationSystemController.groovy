package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.ClassificationSystem

class ClassificationSystemController {
	def classificationSystemService
	 
	
	@Generated
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ classificationSystemInstanceList: ClassificationSystem.list( params ), classificationSystemInstanceTotal: ClassificationSystem.count() ]
			}
			xml{
				render ClassificationSystem.list() as XML
			}
		}
		
	}
		
	
	@Generated
	def show = {
		
		withFormat{
			html{ 
				return [ classificationSystemInstance: ClassificationSystem.get( params.id )]
			}
			xml{
				render ClassificationSystem.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated
	def create = {
		
		def classificationSystemInstance = new ClassificationSystem()
		classificationSystemInstance.properties = params
		return [classificationSystemInstance: classificationSystemInstance]
		
	}
		
	
	@Generated
	def save = {
		
		if(classificationSystemService && classificationSystemService.metaClass.pickMethod("create", [Object.class] as Class[])){
			def (classificationSystemInstance, success) = classificationSystemService.create( params )
			withFormat {
				html { render(view: "show", model: [classificationSystemInstance: classificationSystemInstance]) }
                xml { render classificationSystemInstance as XML }
			
			}
		} else {
			def _params = params.classificationSystem ? params.classificationSystem : params
			
			def classificationSystemInstance = new ClassificationSystem(_params)
    	    if (classificationSystemInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'classificationSystem.label', default: ' ClassificationSystem'), classificationSystemInstance.id])}"
            	redirect(action: "show", id: classificationSystemInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [classificationSystemInstance: classificationSystemInstance])
	        }
	    }		
		
	}
		
	
	@Generated
	def update = {
		
		if(classificationSystemService && classificationSystemService.metaClass.pickMethod("update", [Object.class] as Class[])){
			def (classificationSystemInstance, success) = classificationSystemService.update( params )
			withFormat {
				html { render(view: "show", model: [classificationSystemInstance: classificationSystemInstance]) }
                xml { render classificationSystemInstance as XML }
			
			}
		} else {
			def classificationSystemInstance = ClassificationSystem.get(params.id)
			if (classificationSystemInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (classificationSystemInstance.version > version) {

                    	classificationSystemInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'classificationSystem.label', default: 'classificationSystem')] as Object[], "Another user has updated this classificationSystem while you were editing")
 	                   render(view: "edit", model: [classificationSystemInstance: classificationSystemInstance])
    	                return
        	        }
            	}
	            classificationSystemInstance.properties = params
    	        if (!classificationSystemInstance.hasErrors() && classificationSystemInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'classificationSystem.label', default: 'classificationSystem'), classificationSystemInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [classificationSystemInstance: classificationSystemInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [classificationSystemInstance: classificationSystemInstance])
            			}
            			xml { render classificationSystemInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [classificationSystemInstance: classificationSystemInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [classificationSystemInstance: classificationSystemInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'classificationSystem.label', default: 'classificationSystem'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated
	def delete = {
		
		def classificationSystemInstance = ClassificationSystem.get(params.id)
        if (classificationSystemInstance) {
            try {
                classificationSystemInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'classificationSystem.label', default: 'classificationSystem'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'classificationSystem.label', default: 'classificationSystem'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'classificationSystem.label', default: 'classificationSystem'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}