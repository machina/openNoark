package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Klass

class KlassController {
	def klassService
	 
	
	@Generated
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ klassInstanceList: Klass.list( params ), klassInstanceTotal: Klass.count() ]
			}
			xml{
				render Klass.list() as XML
			}
		}
		
	}
		
	
	@Generated
	def show = {
		
		withFormat{
			html{ 
				return [ klassInstance: Klass.get( params.id )]
			}
			xml{
				render Klass.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated
	def create = {
		
		def klassInstance = new Klass()
		klassInstance.properties = params
		return [klassInstance: klassInstance]
		
	}
		
	
	@Generated
	def save = {
		
		if(klassService && klassService.metaClass.pickMethod("create", [Object.class] as Class[])){
			def (klassInstance, success) = klassService.create( params )
			withFormat {
				html { render(view: "show", model: [klassInstance: klassInstance]) }
                xml { render klassInstance as XML }
			
			}
		} else {
			def _params = params.klass ? params.klass : params
			
			def klassInstance = new Klass(_params)
    	    if (klassInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'klass.label', default: ' Klass'), klassInstance.id])}"
            	redirect(action: "show", id: klassInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [klassInstance: klassInstance])
	        }
	    }		
		
	}
		
	
	@Generated
	def update = {
		
		if(klassService && klassService.metaClass.pickMethod("update", [Object.class] as Class[])){
			def (klassInstance, success) = klassService.update( params )
			withFormat {
				html { render(view: "show", model: [klassInstance: klassInstance]) }
                xml { render klassInstance as XML }
			
			}
		} else {
			def klassInstance = Klass.get(params.id)
			if (klassInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (klassInstance.version > version) {

                    	klassInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'klass.label', default: 'klass')] as Object[], "Another user has updated this klass while you were editing")
 	                   render(view: "edit", model: [klassInstance: klassInstance])
    	                return
        	        }
            	}
	            klassInstance.properties = params
    	        if (!klassInstance.hasErrors() && klassInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'klass.label', default: 'klass'), klassInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [klassInstance: klassInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [klassInstance: klassInstance])
            			}
            			xml { render klassInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [klassInstance: klassInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [klassInstance: klassInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'klass.label', default: 'klass'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated
	def delete = {
		
		def klassInstance = Klass.get(params.id)
        if (klassInstance) {
            try {
                klassInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'klass.label', default: 'klass'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'klass.label', default: 'klass'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'klass.label', default: 'klass'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}