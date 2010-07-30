package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Series

class SeriesController {
	def seriesService
	 
	
	@Generated
	def index = {
		
			redirect(action: "list", params: params)
		
	}
		
	
	@Generated
	def list = {
		
		params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		withFormat{
			html{ 
				return [ seriesInstanceList: Series.list( params ), seriesInstanceTotal: Series.count() ]
			}
			xml{
				render Series.list() as XML
			}
		}
		
	}
		
	
	@Generated
	def show = {
		
		withFormat{
			html{ 
				return [ seriesInstance: Series.get( params.id )]
			}
			xml{
				render Series.get(params.id) as XML
			}
		}
		
	}
		
	
	@Generated
	def create = {
		
		seriesInstance = new Series()
		seriesInstance.properties = params
		return [seriesInstance: seriesInstance]
		
	}
		
	
	@Generated
	def save = {
		
		if(seriesService && seriesService.metaClass.pickMethod("create", [Object.class] as Class[])){
			def (seriesInstance, success) = seriesService.create( params )
			withFormat {
				html { render(view: "show", model: [seriesInstance: seriesInstance]) }
                xml { render seriesInstance as XML }
			
			}
		} else {
			def _params = params.series ? params.series : params
			
			def seriesInstance = new Series(_params)
    	    if (seriesInstance.save(flush: true)) {
        	    flash.message = "${message(code: 'default.created.message', args: [message(code: 'series.label', default: ' Series'), seriesInstance.id])}"
            	redirect(action: "show", id: seriesInstance.id)
	        }
    	    else {
        	    render(view: "create", model: [seriesInstance: seriesInstance])
	        }
	    }		
		
	}
		
	
	@Generated
	def update = {
		
		if(seriesService && seriesService.metaClass.pickMethod("update", [Object.class] as Class[])){
			def (seriesInstance, success) = seriesService.update( params )
			withFormat {
				html { render(view: "show", model: [seriesInstance: seriesInstance]) }
                xml { render seriesInstance as XML }
			
			}
		} else {
			def seriesInstance = series.get(params.id)
			if (seriesInstance) {
        	    if (params.version) {
            	    def version = params.version.toLong()
                	if (seriesInstance.version > version) {

                    	seriesInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'series.label', default: 'series')] as Object[], "Another user has updated this series while you were editing")
 	                   render(view: "edit", model: [seriesInstance: seriesInstance])
    	                return
        	        }
            	}
	            seriesInstance.properties = params
    	        if (!seriesInstance.hasErrors() && seriesInstance.save(flush: true)) {
        	        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'series.label', default: 'series'), seriesInstance.id])}"
            	    withFormat {
            	    	html { 
            	    		redirect(action: "show", id: seriesInstance.id)
            			}
            			xml { render seriesInstance as XML }
            		}
            	}
            	else {
            		withFormat {
            	    	html { 
            	    		render(view: "edit", model: [seriesInstance: seriesInstance])
            			}
            			xml { render text:"<errors>${flash.message}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            		}
                	
            	}
        	}
        	else {
            	flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'series.label', default: 'series'), params.id])}"
            	redirect(action: "list")
        	}
        }
		
	}
		
	
	@Generated
	def delete = {
		
		def seriesInstance = Series.get(params.id)
        if (seriesInstance) {
            try {
                seriesInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'series.label', default: 'series'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'series.label', default: 'series'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'series.label', default: 'series'), params.id])}"
            redirect(action: "list")
        }
		
	}
		
	
}