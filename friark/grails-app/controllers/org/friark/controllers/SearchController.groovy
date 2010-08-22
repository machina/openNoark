package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

class SearchController {
	def searchService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def search = {
		
			if(searchService && (searchService.metaClass.pickMethod("search", [Object.class] as Class[]) ||searchService.metaClass.pickMethod("search", [Object.class, Object.class] as Class[]) )){
				def result
				if(searchService.metaClass.pickMethod("search", [Object.class, Object.class] as Class[])) result = searchService.search(params, request)
				else result = searchService.search(params)
				if(result instanceof Closure){
					println "THIS: ${this}"
                                        result(this)
					return
                } else {
				    withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			    xml { render result as XML }
            		}
            	}
			}
		
	}
		
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def docSearch = {
		
			if(searchService && (searchService.metaClass.pickMethod("docSearch", [Object.class] as Class[]) ||searchService.metaClass.pickMethod("docSearch", [Object.class, Object.class] as Class[]) )){
				def result
				if(searchService.metaClass.pickMethod("docSearch", [Object.class, Object.class] as Class[])) result = searchService.docSearch(params, request)
				else result = searchService.docSearch(params)
				if(result instanceof Closure){
                                        return result(this)
                } else {
				    withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			    xml { render result as XML }
            		}
            	}
			}
		
	}
		
	
}
