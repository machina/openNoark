package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Parameter
	
class ParameterController {
	def parameterService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ parameterInstanceList: Parameter.list( params ), parameterInstanceTotal: Parameter.count() ]
			}
			xml{
				render Parameter.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ parameterInstance: Parameter.get( params.id )]
			}
			xml{
				render Parameter.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def parameterInstance = new Parameter()
		parameterInstance.properties = params
		return [parameterInstance: parameterInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(parameterService && (parameterService.metaClass.pickMethod("create", [Object.class] as Class[]) || parameterService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def parameterInstance
			def success
			if(parameterService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (parameterInstance, success) = parameterService.create( params, request )
			else (parameterInstance, success) = parameterService.create( params )
			withFormat {
				html { render(view: "show", model: [parameterInstance: parameterInstance]) }
                xml { render parameterInstance as XML }
			
			}
		} else {
			def _params = params.parameter ? params.parameter : params
			
			def parameterInstance = new Parameter(_params)
    	    if (parameterInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'parameter.label', default: ' Parameter'), parameterInstance.id])}"
            	redirect(action: "show", id: parameterInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [parameterInstance: parameterInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(parameterService && (parameterService.metaClass.pickMethod("update", [Object.class] as Class[]) || parameterService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def parameterInstance
			def success
			if(parameterService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (parameterInstance, success) = parameterService.update( params, request )
			else (parameterInstance, success) = parameterService.update( params )
			
			withFormat {
				html { render(view: "show", model: [parameterInstance: parameterInstance]) }
                xml { render parameterInstance as XML }
			
			}
		} else {
			def parameterInstance = Parameter.get(params.id)
			if (parameterInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (parameterInstance.version > version) {

                    	parameterInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'parameter.label', default: 'parameter')] as Object[], "Another user has updated this parameter while you were editing")
 	                   render(view: "edit", model: [parameterInstance: parameterInstance])
    	                return
        	        }
            	}
	            parameterInstance.properties = params
    	        if (!parameterInstance.hasErrors() && parameterInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'parameter.label', default: 'parameter'), parameterInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [parameterInstance: parameterInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [parameterInstance: parameterInstance])
            			}
            			xml { render parameterInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [parameterInstance: parameterInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [parameterInstance: parameterInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'parameter.label', default: 'parameter'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}