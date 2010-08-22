package org.friark

import grails.converters.XML
import org.friark.ds.*
import groovy.xml.MarkupBuilder

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
		def results = searchableService.search(params.q, params).results

		def retval = { c ->
			switch(c.request.format) {
				case 'html':
                                  return [result: results]
                                  break
                                case 'xml':
				  def res = results as XML
				  c.render text:res, contentType: 'text/xml'
                                  break
				case 'oep':
				  def res = toOEPFormat(results)
                                  c.render text: res, contentType:"text/xml",encoding:"UTF-8"
			          break
                        }
		}
		return retval
	}

	def docSearch(params) {
		if (!params.q?.trim()) {
            		return [:]
        	}

		return archiveService.search(params.q, params).results
	}

    String toOEPFormat(List registreringer){
      def writer = new StringWriter()
      def xml = new MarkupBuilder(writer)
      def offjourn = xml.OFFJOURNAL {
        RAPPORT {
          registreringer.each { reg ->
	    reg = SimplifiedRecord.get(reg.id)
            "NOARKSAK.OJ" {
              "SA.SAAR"(reg.parentFile.fileID[0..1])
              "SA.SEKNR"(reg.parentFile.fileID[3..(reg.parentFile.fileID.length() -1)])
              "SA.OFFTITTEL"(reg.parentFile.officialTitle)
              "JOURNPOST.OJ"()
            }

          }

        }
      }

      return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE OFFJOURNAL SYSTEM \"OFFJOURN3.DTD\">\n" + writer.toString()
    }


}
