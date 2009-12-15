import grails.converters.*
import org.compass.core.engine.SearchEngineQueryParseException
class SearchController {
		def searchableService
		def archiveService

    def index = {
				if (!params.q?.trim()) {
            return [:]
        }
        try {
						withFormat {
            	html {
								return [searchResult: searchableService.search(params.q, params)]
							}
							xml {
								render searchableService.search(params.q, params).results as XML
							}
						}
        } catch (SearchEngineQueryParseException ex) {
            return [parseException: true]
        }
		 }

		def docSearch = {
			if (!params.q?.trim()) {
            return [:]
      }
			return [searchResult: archiveService.searchArchive(params.q)]
		}
}
