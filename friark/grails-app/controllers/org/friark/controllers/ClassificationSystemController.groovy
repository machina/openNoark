package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.ClassificationSystem

class ClassificationSystemController {
	def classificationSystemService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
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
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
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
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def classificationSystemInstance = new ClassificationSystem()
		classificationSystemInstance.properties = params
		return [classificationSystemInstance: classificationSystemInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(classificationSystemService && (classificationSystemService.metaClass.pickMethod("create", [Object.class] as Class[]) || classificationSystemService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def classificationSystemInstance
			def success
			if(classificationSystemService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (classificationSystemInstance, success) = classificationSystemService.create( params, request )
			else (classificationSystemInstance, success) = classificationSystemService.create( params )
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
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(classificationSystemService && (classificationSystemService.metaClass.pickMethod("update", [Object.class] as Class[]) || classificationSystemService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def classificationSystemInstance
			def success
			if(classificationSystemService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (classificationSystemInstance, success) = classificationSystemService.update( params, request )
			else (classificationSystemInstance, success) = classificationSystemService.update( params )
			
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
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
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