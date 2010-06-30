/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

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
		* Searches in metadata
		*/
		def search = {
			println params
			if(params.query){
				 def coder = new org.apache.commons.codec.net.URLCodec()
   			 params.query = coder.decode(params.query)
				 if(params.clazz) params.query = "alias:${params.clazz} ${params.query}"
				try {
                render searchableService.search(params.query, params).results as XML
        } catch (SearchEngineQueryParseException ex) {
						render text: "<errors><error>query unparsable, better luck next time</error></errors>", contentType:"text/xml",encoding:"UTF-8"
        }

			}
			else render text: "<errors><error>no query found</error></errors>", contentType:"text/xml",encoding:"UTF-8"
		}


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
