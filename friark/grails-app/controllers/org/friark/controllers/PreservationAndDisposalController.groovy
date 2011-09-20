package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.PreservationAndDisposal

class PreservationAndDisposalController {
	def preservationAndDisposalService
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ preservationAndDisposalInstanceList: PreservationAndDisposal.list( params ), preservationAndDisposalInstanceTotal: PreservationAndDisposal.count() ]
			}
			xml{
				render PreservationAndDisposal.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ preservationAndDisposalInstance: PreservationAndDisposal.get( params.id )]
			}
			xml{
				render PreservationAndDisposal.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def preservationAndDisposalInstance = new PreservationAndDisposal()
		preservationAndDisposalInstance.properties = params
		return [preservationAndDisposalInstance: preservationAndDisposalInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(preservationAndDisposalService && (preservationAndDisposalService.metaClass.pickMethod("create", [Object.class] as Class[]) || preservationAndDisposalService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def preservationAndDisposalInstance
			def success
			if(preservationAndDisposalService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (preservationAndDisposalInstance, success) = preservationAndDisposalService.create( params, request )
			else (preservationAndDisposalInstance, success) = preservationAndDisposalService.create( params )
			withFormat {
				html { render(view: "show", model: [preservationAndDisposalInstance: preservationAndDisposalInstance]) }
                xml { render preservationAndDisposalInstance as XML }
			
			}
		} else {
			def _params = params.preservationAndDisposal ? params.preservationAndDisposal : params
			
			def preservationAndDisposalInstance = new PreservationAndDisposal(_params)
    	    if (preservationAndDisposalInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'preservationAndDisposal.label', default: ' PreservationAndDisposal'), preservationAndDisposalInstance.id])}"
            	redirect(action: "show", id: preservationAndDisposalInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [preservationAndDisposalInstance: preservationAndDisposalInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(preservationAndDisposalService && (preservationAndDisposalService.metaClass.pickMethod("update", [Object.class] as Class[]) || preservationAndDisposalService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def preservationAndDisposalInstance
			def success
			if(preservationAndDisposalService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (preservationAndDisposalInstance, success) = preservationAndDisposalService.update( params, request )
			else (preservationAndDisposalInstance, success) = preservationAndDisposalService.update( params )
			
			withFormat {
				html { render(view: "show", model: [preservationAndDisposalInstance: preservationAndDisposalInstance]) }
                xml { render preservationAndDisposalInstance as XML }
			
			}
		} else {
			def preservationAndDisposalInstance = PreservationAndDisposal.get(params.id)
			if (preservationAndDisposalInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (preservationAndDisposalInstance.version > version) {

                    	preservationAndDisposalInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'preservationAndDisposal.label', default: 'preservationAndDisposal')] as Object[], "Another user has updated this preservationAndDisposal while you were editing")
 	                   render(view: "edit", model: [preservationAndDisposalInstance: preservationAndDisposalInstance])
    	                return
        	        }
            	}
	            preservationAndDisposalInstance.properties = params
    	        if (!preservationAndDisposalInstance.hasErrors() && preservationAndDisposalInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'preservationAndDisposal.label', default: 'preservationAndDisposal'), preservationAndDisposalInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [preservationAndDisposalInstance: preservationAndDisposalInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [preservationAndDisposalInstance: preservationAndDisposalInstance])
            			}
            			xml { render preservationAndDisposalInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [preservationAndDisposalInstance: preservationAndDisposalInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [preservationAndDisposalInstance: preservationAndDisposalInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'preservationAndDisposal.label', default: 'preservationAndDisposal'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}
