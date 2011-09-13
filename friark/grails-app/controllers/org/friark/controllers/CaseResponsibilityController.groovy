package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.CaseResponsibility

class CaseResponsibilityController {
	def caseResponsibilityService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ caseResponsibilityInstanceList: CaseResponsibility.list( params ), caseResponsibilityInstanceTotal: CaseResponsibility.count() ]
			}
			xml{
				render CaseResponsibility.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ caseResponsibilityInstance: CaseResponsibility.get( params.id )]
			}
			xml{
				render CaseResponsibility.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def caseResponsibilityInstance = new CaseResponsibility()
		caseResponsibilityInstance.properties = params
		return [caseResponsibilityInstance: caseResponsibilityInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(caseResponsibilityService && (caseResponsibilityService.metaClass.pickMethod("create", [Object.class] as Class[]) || caseResponsibilityService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def caseResponsibilityInstance
			def success
			if(caseResponsibilityService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (caseResponsibilityInstance, success) = caseResponsibilityService.create( params, request )
			else (caseResponsibilityInstance, success) = caseResponsibilityService.create( params )
			withFormat {
				html { render(view: "show", model: [caseResponsibilityInstance: caseResponsibilityInstance]) }
                xml { render caseResponsibilityInstance as XML }
			
			}
		} else {
			def _params = params.caseResponsibility ? params.caseResponsibility : params
			
			def caseResponsibilityInstance = new CaseResponsibility(_params)
    	    if (caseResponsibilityInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'caseResponsibility.label', default: ' CaseResponsibility'), caseResponsibilityInstance.id])}"
            	redirect(action: "show", id: caseResponsibilityInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [caseResponsibilityInstance: caseResponsibilityInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(caseResponsibilityService && (caseResponsibilityService.metaClass.pickMethod("update", [Object.class] as Class[]) || caseResponsibilityService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def caseResponsibilityInstance
			def success
			if(caseResponsibilityService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (caseResponsibilityInstance, success) = caseResponsibilityService.update( params, request )
			else (caseResponsibilityInstance, success) = caseResponsibilityService.update( params )
			
			withFormat {
				html { render(view: "show", model: [caseResponsibilityInstance: caseResponsibilityInstance]) }
                xml { render caseResponsibilityInstance as XML }
			
			}
		} else {
			def caseResponsibilityInstance = CaseResponsibility.get(params.id)
			if (caseResponsibilityInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (caseResponsibilityInstance.version > version) {

                    	caseResponsibilityInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'caseResponsibility.label', default: 'caseResponsibility')] as Object[], "Another user has updated this caseResponsibility while you were editing")
 	                   render(view: "edit", model: [caseResponsibilityInstance: caseResponsibilityInstance])
    	                return
        	        }
            	}
	            caseResponsibilityInstance.properties = params
    	        if (!caseResponsibilityInstance.hasErrors() && caseResponsibilityInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'caseResponsibility.label', default: 'caseResponsibility'), caseResponsibilityInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [caseResponsibilityInstance: caseResponsibilityInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [caseResponsibilityInstance: caseResponsibilityInstance])
            			}
            			xml { render caseResponsibilityInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [caseResponsibilityInstance: caseResponsibilityInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [caseResponsibilityInstance: caseResponsibilityInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'caseResponsibility.label', default: 'caseResponsibility'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}