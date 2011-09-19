package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Fonds

class FondsController {
	def fondsService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ fondsInstanceList: Fonds.list( params ), fondsInstanceTotal: Fonds.count() ]
			}
			xml{
				render Fonds.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ fondsInstance: Fonds.get( params.id )]
			}
			xml{
				render Fonds.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def fondsInstance = new Fonds()
		fondsInstance.properties = params
		return [fondsInstance: fondsInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(fondsService && (fondsService.metaClass.pickMethod("create", [Object.class] as Class[]) || fondsService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def fondsInstance
			def success
			if(fondsService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (fondsInstance, success) = fondsService.create( params, request )
			else (fondsInstance, success) = fondsService.create( params )
			withFormat {
				html { render(view: "show", model: [fondsInstance: fondsInstance]) }
                xml { render fondsInstance as XML }
			
			}
		} else {
			def _params = params.fonds ? params.fonds : params
			
			def fondsInstance = new Fonds(_params)
    	    if (fondsInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'fonds.label', default: ' Fonds'), fondsInstance.id])}"
            	redirect(action: "show", id: fondsInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [fondsInstance: fondsInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(fondsService && (fondsService.metaClass.pickMethod("update", [Object.class] as Class[]) || fondsService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def fondsInstance
			def success
			if(fondsService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (fondsInstance, success) = fondsService.update( params, request )
			else (fondsInstance, success) = fondsService.update( params )
			
			withFormat {
				html { render(view: "show", model: [fondsInstance: fondsInstance]) }
                xml { render fondsInstance as XML }
			
			}
		} else {
			def fondsInstance = Fonds.get(params.id)
			if (fondsInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (fondsInstance.version > version) {

                    	fondsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'fonds.label', default: 'fonds')] as Object[], "Another user has updated this fonds while you were editing")
 	                   render(view: "edit", model: [fondsInstance: fondsInstance])
    	                return
        	        }
            	}
	            fondsInstance.properties = params
    	        if (!fondsInstance.hasErrors() && fondsInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'fonds.label', default: 'fonds'), fondsInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [fondsInstance: fondsInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [fondsInstance: fondsInstance])
            			}
            			xml { render fondsInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [fondsInstance: fondsInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [fondsInstance: fondsInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fonds.label', default: 'fonds'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def delete = {
		
		def fondsInstance = Fonds.get(params.id)
        if (fondsInstance) {
            try {
                fondsInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'fonds.label', default: 'fonds'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'fonds.label', default: 'fonds'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fonds.label', default: 'fonds'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}
