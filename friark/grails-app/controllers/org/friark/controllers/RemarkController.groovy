package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Remark
	
class RemarkController {
	def remarkService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ remarkInstanceList: Remark.list( params ), remarkInstanceTotal: Remark.count() ]
			}
			xml{
				render Remark.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ remarkInstance: Remark.get( params.id )]
			}
			xml{
				render Remark.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def remarkInstance = new Remark()
		remarkInstance.properties = params
		return [remarkInstance: remarkInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(remarkService && (remarkService.metaClass.pickMethod("create", [Object.class] as Class[]) || remarkService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def remarkInstance
			def success
			if(remarkService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (remarkInstance, success) = remarkService.create( params, request )
			else (remarkInstance, success) = remarkService.create( params )
			withFormat {
				html { render(view: "show", model: [remarkInstance: remarkInstance]) }
                xml { render remarkInstance as XML }
			
			}
		} else {
			def _params = params.remark ? params.remark : params
			
			def remarkInstance = new Remark(_params)
    	    if (remarkInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'remark.label', default: ' Remark'), remarkInstance.id])}"
            	redirect(action: "show", id: remarkInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [remarkInstance: remarkInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(remarkService && (remarkService.metaClass.pickMethod("update", [Object.class] as Class[]) || remarkService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def remarkInstance
			def success
			if(remarkService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (remarkInstance, success) = remarkService.update( params, request )
			else (remarkInstance, success) = remarkService.update( params )
			
			withFormat {
				html { render(view: "show", model: [remarkInstance: remarkInstance]) }
                xml { render remarkInstance as XML }
			
			}
		} else {
			def remarkInstance = Remark.get(params.id)
			if (remarkInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (remarkInstance.version > version) {

                    	remarkInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'remark.label', default: 'remark')] as Object[], "Another user has updated this remark while you were editing")
 	                   render(view: "edit", model: [remarkInstance: remarkInstance])
    	                return
        	        }
            	}
	            remarkInstance.properties = params
    	        if (!remarkInstance.hasErrors() && remarkInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'remark.label', default: 'remark'), remarkInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [remarkInstance: remarkInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [remarkInstance: remarkInstance])
            			}
            			xml { render remarkInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [remarkInstance: remarkInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [remarkInstance: remarkInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'remark.label', default: 'remark'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}