package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.FondsCreator

class FondsCreatorController {
	def fondsCreatorService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ fondsCreatorInstanceList: FondsCreator.list( params ), fondsCreatorInstanceTotal: FondsCreator.count() ]
			}
			xml{
				render FondsCreator.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ fondsCreatorInstance: FondsCreator.get( params.id )]
			}
			xml{
				render FondsCreator.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def fondsCreatorInstance = new FondsCreator()
		fondsCreatorInstance.properties = params
		return [fondsCreatorInstance: fondsCreatorInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(fondsCreatorService && (fondsCreatorService.metaClass.pickMethod("create", [Object.class] as Class[]) || fondsCreatorService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def fondsCreatorInstance
			def success
			if(fondsCreatorService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (fondsCreatorInstance, success) = fondsCreatorService.create( params, request )
			else (fondsCreatorInstance, success) = fondsCreatorService.create( params )
			withFormat {
				html { render(view: "show", model: [fondsCreatorInstance: fondsCreatorInstance]) }
                xml { render fondsCreatorInstance as XML }
			
			}
		} else {
			def _params = params.fondsCreator ? params.fondsCreator : params
			
			def fondsCreatorInstance = new FondsCreator(_params)
    	    if (fondsCreatorInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'fondsCreator.label', default: ' FondsCreator'), fondsCreatorInstance.id])}"
            	redirect(action: "show", id: fondsCreatorInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [fondsCreatorInstance: fondsCreatorInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(fondsCreatorService && (fondsCreatorService.metaClass.pickMethod("update", [Object.class] as Class[]) || fondsCreatorService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def fondsCreatorInstance
			def success
			if(fondsCreatorService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (fondsCreatorInstance, success) = fondsCreatorService.update( params, request )
			else (fondsCreatorInstance, success) = fondsCreatorService.update( params )
			
			withFormat {
				html { render(view: "show", model: [fondsCreatorInstance: fondsCreatorInstance]) }
                xml { render fondsCreatorInstance as XML }
			
			}
		} else {
			def fondsCreatorInstance = FondsCreator.get(params.id)
			if (fondsCreatorInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (fondsCreatorInstance.version > version) {

                    	fondsCreatorInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'fondsCreator.label', default: 'fondsCreator')] as Object[], "Another user has updated this fondsCreator while you were editing")
 	                   render(view: "edit", model: [fondsCreatorInstance: fondsCreatorInstance])
    	                return
        	        }
            	}
	            fondsCreatorInstance.properties = params
    	        if (!fondsCreatorInstance.hasErrors() && fondsCreatorInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'fondsCreator.label', default: 'fondsCreator'), fondsCreatorInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [fondsCreatorInstance: fondsCreatorInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [fondsCreatorInstance: fondsCreatorInstance])
            			}
            			xml { render fondsCreatorInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [fondsCreatorInstance: fondsCreatorInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [fondsCreatorInstance: fondsCreatorInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'fondsCreator.label', default: 'fondsCreator'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
}
