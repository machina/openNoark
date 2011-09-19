package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Screening

class ScreeningController {
	def skjermingService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ screeningInstanceList: Screening.list( params ), screeningInstanceTotal: Screening.count() ]
			}
			xml{
				render Screening.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ screeningInstance: Screening.get( params.id )]
			}
			xml{
				render Screening.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def screeningInstance = new Screening()
		screeningInstance.properties = params
		return [screeningInstance: screeningInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(skjermingService && (skjermingService.metaClass.pickMethod("create", [Object.class] as Class[]) || skjermingService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def screeningInstance
			def success
			if(skjermingService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (screeningInstance, success) = skjermingService.create( params, request )
			else (screeningInstance, success) = skjermingService.create( params )
			withFormat {
				html { render(view: "show", model: [screeningInstance: screeningInstance]) }
                xml { render screeningInstance as XML }
			
			}
		} else {
			def _params = params.screening ? params.screening : params
			
			def screeningInstance = new Screening(_params)
    	    if (screeningInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'screening.label', default: ' Screening'), screeningInstance.id])}"
            	redirect(action: "show", id: screeningInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [screeningInstance: screeningInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(skjermingService && (skjermingService.metaClass.pickMethod("update", [Object.class] as Class[]) || skjermingService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def screeningInstance
			def success
			if(skjermingService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (screeningInstance, success) = skjermingService.update( params, request )
			else (screeningInstance, success) = skjermingService.update( params )
			
			withFormat {
				html { render(view: "show", model: [screeningInstance: screeningInstance]) }
                xml { render screeningInstance as XML }
			
			}
		} else {
			def screeningInstance = Screening.get(params.id)
			if (screeningInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (screeningInstance.version > version) {

                    	screeningInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'screening.label', default: 'screening')] as Object[], "Another user has updated this screening while you were editing")
 	                   render(view: "edit", model: [screeningInstance: screeningInstance])
    	                return
        	        }
            	}
	            screeningInstance.properties = params
    	        if (!screeningInstance.hasErrors() && screeningInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'screening.label', default: 'screening'), screeningInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [screeningInstance: screeningInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [screeningInstance: screeningInstance])
            			}
            			xml { render screeningInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [screeningInstance: screeningInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [screeningInstance: screeningInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'screening.label', default: 'screening'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}
