package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.DocumentLink
	
class DocumentLinkController {
	def documentLinkService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ documentLinkInstanceList: DocumentLink.list( params ), documentLinkInstanceTotal: DocumentLink.count() ]
			}
			xml{
				render DocumentLink.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ documentLinkInstance: DocumentLink.get( params.id )]
			}
			xml{
				render DocumentLink.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def documentLinkInstance = new DocumentLink()
		documentLinkInstance.properties = params
		return [documentLinkInstance: documentLinkInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(documentLinkService && (documentLinkService.metaClass.pickMethod("create", [Object.class] as Class[]) || documentLinkService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def documentLinkInstance
			def success
			if(documentLinkService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (documentLinkInstance, success) = documentLinkService.create( params, request )
			else (documentLinkInstance, success) = documentLinkService.create( params )
			withFormat {
				html { render(view: "show", model: [documentLinkInstance: documentLinkInstance]) }
                xml { render documentLinkInstance as XML }
			
			}
		} else {
			def _params = params.documentLink ? params.documentLink : params
			
			def documentLinkInstance = new DocumentLink(_params)
    	    if (documentLinkInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'documentLink.label', default: ' DocumentLink'), documentLinkInstance.id])}"
            	redirect(action: "show", id: documentLinkInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [documentLinkInstance: documentLinkInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(documentLinkService && (documentLinkService.metaClass.pickMethod("update", [Object.class] as Class[]) || documentLinkService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def documentLinkInstance
			def success
			if(documentLinkService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (documentLinkInstance, success) = documentLinkService.update( params, request )
			else (documentLinkInstance, success) = documentLinkService.update( params )
			
			withFormat {
				html { render(view: "show", model: [documentLinkInstance: documentLinkInstance]) }
                xml { render documentLinkInstance as XML }
			
			}
		} else {
			def documentLinkInstance = DocumentLink.get(params.id)
			if (documentLinkInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (documentLinkInstance.version > version) {

                    	documentLinkInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'documentLink.label', default: 'documentLink')] as Object[], "Another user has updated this documentLink while you were editing")
 	                   render(view: "edit", model: [documentLinkInstance: documentLinkInstance])
    	                return
        	        }
            	}
	            documentLinkInstance.properties = params
    	        if (!documentLinkInstance.hasErrors() && documentLinkInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'documentLink.label', default: 'documentLink'), documentLinkInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [documentLinkInstance: documentLinkInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [documentLinkInstance: documentLinkInstance])
            			}
            			xml { render documentLinkInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [documentLinkInstance: documentLinkInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [documentLinkInstance: documentLinkInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'documentLink.label', default: 'documentLink'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}