package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.CrossReference

class CrossReferenceController {
	def crossReferenceService
	 
	
	@Generated
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ crossReferenceInstanceList: CrossReference.list( params ), crossReferenceInstanceTotal: CrossReference.count() ]
			}
			xml{
				render CrossReference.list() as XML
			}
		}
		
	}
		
	
	@Generated
	def show = {
		
		withFormat{
			html{ 
				return [ crossReferenceInstance: CrossReference.get( params.id )]
			}
			xml{
				render CrossReference.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated
	def create = {
		
		crossReferenceInstance = new CrossReference()
		crossReferenceInstance.properties = params
		return [crossReferenceInstance: crossReferenceInstance]
		
	}
		
	
	@Generated
	def save = {
		
		if(crossReferenceService && crossReferenceService.metaClass.pickMethod("create", [Object.class] as Class[])){
			def (crossReferenceInstance, success) = crossReferenceService.create( params )
			withFormat {
				html { render(view: "show", model: [crossReferenceInstance: crossReferenceInstance]) }
                xml { render crossReferenceInstance as XML }
			
			}
		} else {
			def _params = params.crossReference ? params.crossReference : params
			
			def crossReferenceInstance = new CrossReference(_params)
    	    if (crossReferenceInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'crossReference.label', default: ' CrossReference'), crossReferenceInstance.id])}"
            	redirect(action: "show", id: crossReferenceInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [crossReferenceInstance: crossReferenceInstance])
	        }
	    }		
		
	}
		
	
	@Generated
	def update = {
		
		if(crossReferenceService && crossReferenceService.metaClass.pickMethod("update", [Object.class] as Class[])){
			def (crossReferenceInstance, success) = crossReferenceService.update( params )
			withFormat {
				html { render(view: "show", model: [crossReferenceInstance: crossReferenceInstance]) }
                xml { render crossReferenceInstance as XML }
			
			}
		} else {
			def crossReferenceInstance = crossReference.get(params.id)
			if (crossReferenceInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (crossReferenceInstance.version > version) {

                    	crossReferenceInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'crossReference.label', default: 'crossReference')] as Object[], "Another user has updated this crossReference while you were editing")
 	                   render(view: "edit", model: [crossReferenceInstance: crossReferenceInstance])
    	                return
        	        }
            	}
	            crossReferenceInstance.properties = params
    	        if (!crossReferenceInstance.hasErrors() && crossReferenceInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'crossReference.label', default: 'crossReference'), crossReferenceInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		redirect(action: "show", id: crossReferenceInstance.id)
            			}
            			xml { render crossReferenceInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [crossReferenceInstance: crossReferenceInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'crossReference.label', default: 'crossReference'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}