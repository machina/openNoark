package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.DocumentObject

class DocumentObjectController {
	def documentObjectService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ documentObjectInstanceList: DocumentObject.list( params ), documentObjectInstanceTotal: DocumentObject.count() ]
			}
			xml{
				render DocumentObject.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ documentObjectInstance: DocumentObject.get( params.id )]
			}
			xml{
				render DocumentObject.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def documentObjectInstance = new DocumentObject()
		documentObjectInstance.properties = params
		return [documentObjectInstance: documentObjectInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(documentObjectService && (documentObjectService.metaClass.pickMethod("create", [Object.class] as Class[]) || documentObjectService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def documentObjectInstance
			def success
			if(documentObjectService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (documentObjectInstance, success) = documentObjectService.create( params, request )
			else (documentObjectInstance, success) = documentObjectService.create( params )
			withFormat {
				html { render(view: "show", model: [documentObjectInstance: documentObjectInstance]) }
                xml { render documentObjectInstance as XML }
			
			}
		} else {
			def _params = params.documentObject ? params.documentObject : params
			
			def documentObjectInstance = new DocumentObject(_params)
    	    if (documentObjectInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'documentObject.label', default: ' DocumentObject'), documentObjectInstance.id])}"
            	redirect(action: "show", id: documentObjectInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [documentObjectInstance: documentObjectInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(documentObjectService && (documentObjectService.metaClass.pickMethod("update", [Object.class] as Class[]) || documentObjectService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def documentObjectInstance
			def success
			if(documentObjectService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (documentObjectInstance, success) = documentObjectService.update( params, request )
			else (documentObjectInstance, success) = documentObjectService.update( params )
			
			withFormat {
				html { render(view: "show", model: [documentObjectInstance: documentObjectInstance]) }
                xml { render documentObjectInstance as XML }
			
			}
		} else {
			def documentObjectInstance = DocumentObject.get(params.id)
			if (documentObjectInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (documentObjectInstance.version > version) {

                    	documentObjectInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'documentObject.label', default: 'documentObject')] as Object[], "Another user has updated this documentObject while you were editing")
 	                   render(view: "edit", model: [documentObjectInstance: documentObjectInstance])
    	                return
        	        }
            	}
	            documentObjectInstance.properties = params
    	        if (!documentObjectInstance.hasErrors() && documentObjectInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'documentObject.label', default: 'documentObject'), documentObjectInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [documentObjectInstance: documentObjectInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [documentObjectInstance: documentObjectInstance])
            			}
            			xml { render documentObjectInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [documentObjectInstance: documentObjectInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [documentObjectInstance: documentObjectInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'documentObject.label', default: 'documentObject'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}