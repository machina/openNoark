package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.SimplifiedRecord

class RegistreringController {
	def registreringService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ simplifiedRecordInstanceList: SimplifiedRecord.list( params ), simplifiedRecordInstanceTotal: SimplifiedRecord.count() ]
			}
			xml{
				render SimplifiedRecord.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ simplifiedRecordInstance: SimplifiedRecord.get( params.id )]
			}
			xml{
				render SimplifiedRecord.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def simplifiedRecordInstance = new SimplifiedRecord()
		simplifiedRecordInstance.properties = params
		return [simplifiedRecordInstance: simplifiedRecordInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(registreringService && (registreringService.metaClass.pickMethod("create", [Object.class] as Class[]) || registreringService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def simplifiedRecordInstance
			def success
			if(registreringService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (simplifiedRecordInstance, success) = registreringService.create( params, request )
			else (simplifiedRecordInstance, success) = registreringService.create( params )
			withFormat {
				html { render(view: "show", model: [simplifiedRecordInstance: simplifiedRecordInstance]) }
                xml { render simplifiedRecordInstance as XML }
			
			}
		} else {
			def _params = params.simplifiedRecord ? params.simplifiedRecord : params
			
			def simplifiedRecordInstance = new SimplifiedRecord(_params)
    	    if (simplifiedRecordInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'simplifiedRecord.label', default: ' SimplifiedRecord'), simplifiedRecordInstance.id])}"
            	redirect(action: "show", id: simplifiedRecordInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [simplifiedRecordInstance: simplifiedRecordInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(registreringService && (registreringService.metaClass.pickMethod("update", [Object.class] as Class[]) || registreringService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def simplifiedRecordInstance
			def success
			if(registreringService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (simplifiedRecordInstance, success) = registreringService.update( params, request )
			else (simplifiedRecordInstance, success) = registreringService.update( params )
			
			withFormat {
				html { render(view: "show", model: [simplifiedRecordInstance: simplifiedRecordInstance]) }
                xml { render simplifiedRecordInstance as XML }
			
			}
		} else {
			def simplifiedRecordInstance = SimplifiedRecord.get(params.id)
			if (simplifiedRecordInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (simplifiedRecordInstance.version > version) {

                    	simplifiedRecordInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'simplifiedRecord.label', default: 'simplifiedRecord')] as Object[], "Another user has updated this simplifiedRecord while you were editing")
 	                   render(view: "edit", model: [simplifiedRecordInstance: simplifiedRecordInstance])
    	                return
        	        }
            	}
	            simplifiedRecordInstance.properties = params
    	        if (!simplifiedRecordInstance.hasErrors() && simplifiedRecordInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'simplifiedRecord.label', default: 'simplifiedRecord'), simplifiedRecordInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [simplifiedRecordInstance: simplifiedRecordInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [simplifiedRecordInstance: simplifiedRecordInstance])
            			}
            			xml { render simplifiedRecordInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [simplifiedRecordInstance: simplifiedRecordInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [simplifiedRecordInstance: simplifiedRecordInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'simplifiedRecord.label', default: 'simplifiedRecord'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def delete = {
		
		def simplifiedRecordInstance = SimplifiedRecord.get(params.id)
        if (simplifiedRecordInstance) {
            try {
                simplifiedRecordInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'simplifiedRecord.label', default: 'simplifiedRecord'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'simplifiedRecord.label', default: 'simplifiedRecord'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'simplifiedRecord.label', default: 'simplifiedRecord'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}