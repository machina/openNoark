package org.friark

import org.friark.ds.*

class SearchService {
	
	// service for meta-data search
	def searchableService

	// service for document search
	def archiveService

	def search(params) {
		if (!params.q?.trim()) {
            		return [:]
        	}
		def coder = new org.apache.commons.codec.net.URLCodec()
		params.q = coder.decode(params.q)
                if(params.clazz) params.q = "alias:${params.clazz} ${params.q}"
		return searchableService.search(params.q, params).results
	}

	def docSearch(params) {
		if (!params.q?.trim()) {
            		return [:]
        	}

		return archiveService.search(params.q, params).results
	}

}
