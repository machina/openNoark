package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Client
	
class ClientController {
	def clientService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ clientInstanceList: Client.list( params ), clientInstanceTotal: Client.count() ]
			}
			xml{
				render Client.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ clientInstance: Client.get( params.id )]
			}
			xml{
				render Client.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def clientInstance = new Client()
		clientInstance.properties = params
		return [clientInstance: clientInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(clientService && (clientService.metaClass.pickMethod("create", [Object.class] as Class[]) || clientService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def clientInstance
			def success
			if(clientService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (clientInstance, success) = clientService.create( params, request )
			else (clientInstance, success) = clientService.create( params )
			withFormat {
				html { render(view: "show", model: [clientInstance: clientInstance]) }
                xml { render clientInstance as XML }
			
			}
		} else {
			def _params = params.client ? params.client : params
			
			def clientInstance = new Client(_params)
    	    if (clientInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'client.label', default: ' Client'), clientInstance.id])}"
            	redirect(action: "show", id: clientInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [clientInstance: clientInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(clientService && (clientService.metaClass.pickMethod("update", [Object.class] as Class[]) || clientService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def clientInstance
			def success
			if(clientService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (clientInstance, success) = clientService.update( params, request )
			else (clientInstance, success) = clientService.update( params )
			
			withFormat {
				html { render(view: "show", model: [clientInstance: clientInstance]) }
                xml { render clientInstance as XML }
			
			}
		} else {
			def clientInstance = Client.get(params.id)
			if (clientInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (clientInstance.version > version) {

                    	clientInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'client.label', default: 'client')] as Object[], "Another user has updated this client while you were editing")
 	                   render(view: "edit", model: [clientInstance: clientInstance])
    	                return
        	        }
            	}
	            clientInstance.properties = params
    	        if (!clientInstance.hasErrors() && clientInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'client.label', default: 'client'), clientInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [clientInstance: clientInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [clientInstance: clientInstance])
            			}
            			xml { render clientInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [clientInstance: clientInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [clientInstance: clientInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'client.label', default: 'client'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}