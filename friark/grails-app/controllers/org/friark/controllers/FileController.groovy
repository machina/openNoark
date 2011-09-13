package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.BasicFile

class FileController {
	def fileService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ basicFileInstanceList: BasicFile.list( params ), basicFileInstanceTotal: BasicFile.count() ]
			}
			xml{
				render BasicFile.list() as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def show = {
		
		withFormat{
			html{ 
				return [ basicFileInstance: BasicFile.get( params.id )]
			}
			xml{
				render BasicFile.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def basicFileInstance = new BasicFile()
		basicFileInstance.properties = params
		return [basicFileInstance: basicFileInstance]
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def save = {
		
		if(fileService && (fileService.metaClass.pickMethod("create", [Object.class] as Class[]) || fileService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] ))){
			def basicFileInstance
			def success
			if(fileService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (basicFileInstance, success) = fileService.create( params, request )
			else (basicFileInstance, success) = fileService.create( params )
			withFormat {
				html { render(view: "show", model: [basicFileInstance: basicFileInstance]) }
                xml { render basicFileInstance as XML }
			
			}
		} else {
			def _params = params.basicFile ? params.basicFile : params
			
			def basicFileInstance = new BasicFile(_params)
    	    if (basicFileInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'basicFile.label', default: ' BasicFile'), basicFileInstance.id])}"
            	redirect(action: "show", id: basicFileInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [basicFileInstance: basicFileInstance])
	        }
	    }		
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def update = {
		
		if(fileService && (fileService.metaClass.pickMethod("update", [Object.class] as Class[]) || fileService.metaClass.pickMethod("update", [Object.class, Object.class] as Class[]))){
			def basicFileInstance
			def success
			if(fileService.metaClass.pickMethod("create", [Object.class, Object.class] as Class[] )) (basicFileInstance, success) = fileService.update( params, request )
			else (basicFileInstance, success) = fileService.update( params )
			
			withFormat {
				html { render(view: "show", model: [basicFileInstance: basicFileInstance]) }
                xml { render basicFileInstance as XML }
			
			}
		} else {
			def basicFileInstance = BasicFile.get(params.id)
			if (basicFileInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (basicFileInstance.version > version) {

                    	basicFileInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'basicFile.label', default: 'basicFile')] as Object[], "Another user has updated this basicFile while you were editing")
 	                   render(view: "edit", model: [basicFileInstance: basicFileInstance])
    	                return
        	        }
            	}
	            basicFileInstance.properties = params
    	        if (!basicFileInstance.hasErrors() && basicFileInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'basicFile.label', default: 'basicFile'), basicFileInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		render(view: "edit", model: [basicFileInstance: basicFileInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [basicFileInstance: basicFileInstance])
            			}
            			xml { render basicFileInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [basicFileInstance: basicFileInstance])
            			}
            			form { 
            	    		render(view: "edit", model: [basicFileInstance: basicFileInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'basicFile.label', default: 'basicFile'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def delete = {
		
		def basicFileInstance = BasicFile.get(params.id)
        if (basicFileInstance) {
            try {
                basicFileInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'basicFile.label', default: 'basicFile'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'basicFile.label', default: 'basicFile'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'basicFile.label', default: 'basicFile'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}