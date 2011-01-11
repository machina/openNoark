package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.RemarkType

class RemarkTypeController {
	def remarkTypeService
	 
	
	@Generated
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ remarkTypeInstanceList: RemarkType.list( params ), remarkTypeInstanceTotal: RemarkType.count() ]
			}
			xml{
				render RemarkType.list() as XML
			}
		}
		
	}
		
	
	@Generated
	def show = {
		
		withFormat{
			html{ 
				return [ remarkTypeInstance: RemarkType.get( params.id )]
			}
			xml{
				render RemarkType.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated
	def create = {
		
		def remarkTypeInstance = new RemarkType()
		remarkTypeInstance.properties = params
		return [remarkTypeInstance: remarkTypeInstance]
		
	}
		
	
	@Generated
	def save = {
		
		if(remarkTypeService && remarkTypeService.metaClass.pickMethod("create", [Object.class] as Class[])){
			def (remarkTypeInstance, success) = remarkTypeService.create( params )
			withFormat {
				html { render(view: "show", model: [remarkTypeInstance: remarkTypeInstance]) }
                xml { render remarkTypeInstance as XML }
			
			}
		} else {
			def _params = params.remarkType ? params.remarkType : params
			
			def remarkTypeInstance = new RemarkType(_params)
    	    if (remarkTypeInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'remarkType.label', default: ' RemarkType'), remarkTypeInstance.id])}"
            	redirect(action: "show", id: remarkTypeInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [remarkTypeInstance: remarkTypeInstance])
	        }
	    }		
		
	}
		
	
	@Generated
	def update = {
		
		if(remarkTypeService && remarkTypeService.metaClass.pickMethod("update", [Object.class] as Class[])){
			def (remarkTypeInstance, success) = remarkTypeService.update( params )
			withFormat {
				html { render(view: "show", model: [remarkTypeInstance: remarkTypeInstance]) }
                xml { render remarkTypeInstance as XML }
			
			}
		} else {
			def remarkTypeInstance = RemarkType.get(params.id)
			if (remarkTypeInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (remarkTypeInstance.version > version) {

                    	remarkTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'remarkType.label', default: 'remarkType')] as Object[], "Another user has updated this remarkType while you were editing")
 	                   render(view: "edit", model: [remarkTypeInstance: remarkTypeInstance])
    	                return
        	        }
            	}
	            remarkTypeInstance.properties = params
    	        if (!remarkTypeInstance.hasErrors() && remarkTypeInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'remarkType.label', default: 'remarkType'), remarkTypeInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [remarkTypeInstance: remarkTypeInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [remarkTypeInstance: remarkTypeInstance])
            			}
            			xml { render remarkTypeInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [remarkTypeInstance: remarkTypeInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [remarkTypeInstance: remarkTypeInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'remarkType.label', default: 'remarkType'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}