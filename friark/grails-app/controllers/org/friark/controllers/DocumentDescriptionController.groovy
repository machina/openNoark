package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.DocumentDescription

class DocumentDescriptionController {
	def documentDescriptionService
	 
	
	@Generated
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ documentDescriptionInstanceList: DocumentDescription.list( params ), documentDescriptionInstanceTotal: DocumentDescription.count() ]
			}
			xml{
				render DocumentDescription.list() as XML
			}
		}
		
	}
		
	
	@Generated
	def show = {
		
		withFormat{
			html{ 
				return [ documentDescriptionInstance: DocumentDescription.get( params.id )]
			}
			xml{
				render DocumentDescription.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated
	def create = {
		
		def documentDescriptionInstance = new DocumentDescription()
		documentDescriptionInstance.properties = params
		return [documentDescriptionInstance: documentDescriptionInstance]
		
	}
		
	
	@Generated
	def save = {
		
		if(documentDescriptionService && documentDescriptionService.metaClass.pickMethod("create", [Object.class] as Class[])){
			def (documentDescriptionInstance, success) = documentDescriptionService.create( params )
			withFormat {
				html { render(view: "show", model: [documentDescriptionInstance: documentDescriptionInstance]) }
                xml { render documentDescriptionInstance as XML }
			
			}
		} else {
			def _params = params.documentDescription ? params.documentDescription : params
			
			def documentDescriptionInstance = new DocumentDescription(_params)
    	    if (documentDescriptionInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'documentDescription.label', default: ' DocumentDescription'), documentDescriptionInstance.id])}"
            	redirect(action: "show", id: documentDescriptionInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [documentDescriptionInstance: documentDescriptionInstance])
	        }
	    }		
		
	}
		
	
	@Generated
	def update = {
		
		if(documentDescriptionService && documentDescriptionService.metaClass.pickMethod("update", [Object.class] as Class[])){
			def (documentDescriptionInstance, success) = documentDescriptionService.update( params )
			withFormat {
				html { render(view: "show", model: [documentDescriptionInstance: documentDescriptionInstance]) }
                xml { render documentDescriptionInstance as XML }
			
			}
		} else {
			def documentDescriptionInstance = DocumentDescription.get(params.id)
			if (documentDescriptionInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (documentDescriptionInstance.version > version) {

                    	documentDescriptionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'documentDescription.label', default: 'documentDescription')] as Object[], "Another user has updated this documentDescription while you were editing")
 	                   render(view: "edit", model: [documentDescriptionInstance: documentDescriptionInstance])
    	                return
        	        }
            	}
	            documentDescriptionInstance.properties = params
    	        if (!documentDescriptionInstance.hasErrors() && documentDescriptionInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'documentDescription.label', default: 'documentDescription'), documentDescriptionInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [documentDescriptionInstance: documentDescriptionInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [documentDescriptionInstance: documentDescriptionInstance])
            			}
            			xml { render documentDescriptionInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [documentDescriptionInstance: documentDescriptionInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [documentDescriptionInstance: documentDescriptionInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'documentDescription.label', default: 'documentDescription'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated
	def delete = {
		
		def documentDescriptionInstance = DocumentDescription.get(params.id)
        if (documentDescriptionInstance) {
            try {
                documentDescriptionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'documentDescription.label', default: 'documentDescription'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'documentDescription.label', default: 'documentDescription'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'documentDescription.label', default: 'documentDescription'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}