import grails.converters.*
import org.compass.core.engine.SearchEngineQueryParseException
import no.friark.ds.*

/**
* Kontroller for å utføre søk i metadata og i elektronisk lagrede dokumenter.
*
* @author Kent Inge Fagerland Simonsen
*/
class SearchController {
		def searchableService
		def archiveService

		/**
    * Tar imot en spørring som parameter "q" og returnerer resultatene fra å søke med denne spørringen i metadata.
    */
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

		/**
    * Tar imot en spørring som parameter "q" og returnerer resultatene fra å søke med denne spørringen i det tilknyttede elektriniske arkivet.
    */
		def docSearch = {
			if (!params.q?.trim()) {
            return [:]
      }
			return [searchResult: archiveService.searchArchive(params.q)]
		}
}
