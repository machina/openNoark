package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

class SearchController {
	def searchService
	 
	
	@Generated
	def search = {
		
			if(searchService && searchService.metaClass.pickMethod("search", [Object.class] as Class[])){
				def result = searchService.search(params)
				withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			xml { render result as XML }
            		}
			}
		
	}
		
	
	@Generated
	def docSearch = {
		
			if(searchService && searchService.metaClass.pickMethod("docSearch", [Object.class] as Class[])){
				def result = searchService.docSearch(params)
				withFormat {
            	    	html { 
            	    		return [result: result]
            			}
           			xml { render result as XML }
            		}
			}
		
	}
		
	
}