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

package org.friark.services;

import grails.converters.*
import org.apache.tika.*
import org.apache.tika.utils.*
import org.apache.tika.parser.*
import org.apache.tika.parser.html.*
import org.apache.tika.config.TikaConfig
import org.apache.tika.sax.*
import org.apache.tika.metadata.Metadata
import org.xml.sax.helpers.DefaultHandler

import org.apache.lucene.search.Hits;
import org.apache.lucene.search.Query;
import org.apache.lucene.document.Field;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.document.Document;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.IndexReader
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.Term;

import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH
import no.machina.utils.StringInputStream

import org.friark.ds.*

/**
* Contains methods for handling a single electronic archive
* 
* The location of the archive is set by the configuration 
* parameter "archivePath"
*/
class FondsService implements org.springframework.context.ApplicationContextAware {
	def grailsApplication
	org.springframework.context.ApplicationContext applicationContext
	def servletContext = SCH.servletContext
	
	/**
	* Archives a file as the file attached to the DocumentObject 
	* object with id docId and indexes it
	* 
	* @param docId Id for the document object which will be attached to 
	*	 the file
	* @param file The file that is to be archived as an incoming 
 	*	      base64 encoded file
	*/
	def archive(docId, file){
		def path = "${grailsApplication.config.archivePath}/${docId}"
		new File(path).mkdir()
		path = "${path}/data"
		def data = file.text
		
		new File(path).append(data.decodeBase64())
		
		indexFile(docId, new ByteArrayInputStream(data.decodeBase64()))
	}

	/**
	* Removes the file attached to the incoming document object from 
	* the archive
	* @param documentObject The object attached to the file that is to 
	*			be deleted
	*/
	def deleteFromArchive(DocumentObject dokumentobjekt){
		if(dokumentobjekt.documentFile){
			removeFromIndex(dokumentobjekt.systemID)
			def f = new File(dokumentobjekt.documentFile)
			if(f.exists()) f.delete()
		}
	}

	/**
	* Removes the document that is attached to the incoming document object 
	* id from the search index for electronic documents.
	* @param docId String that contains the ID for the document to be 
	*	       removed from the index.
	*/
	def removeFromIndex(docId){

		if(!servletContext.docIdx) {
			return //if there is no index, return 
		}

		IndexWriter writer = new IndexWriter(servletContext.docIdx, new StandardAnalyzer(), false)
		writer.deleteDocuments( new Term("DOC-OBJ", docId))
		writer.flush()
		writer.close()
	}

	/**
	* Indexes the incoming file 
	* @param docId The document object id
  	* @param file The file that is to be indexed 
	*/
	def indexFile(docId, file){
		
		if(!servletContext.docIdx) {
			println "!servletContext.docIdx"
			servletContext.docIdx = new RAMDirectory()
		} else {
			println("docIdx: ${servletContext.docIdx}")
		}

		def doc = DocumentObject.findBySystemID(docId)
		
		Metadata metadata = new Metadata();
		metadata.set(Metadata.CONTENT_TYPE, doc.format);

		def handler = new BodyContentHandler();
		new AutoDetectParser().parse(file, handler, metadata);
				
		Document ldoc = new Document();
		ldoc.add(new Field("CONTENT", handler.toString(), Field.Store.YES, Field.Index.TOKENIZED))
		ldoc.add(new Field("DOC-OBJ", doc.systemID, Field.Store.YES, Field.Index.NO))
		
		IndexWriter writer = new IndexWriter(servletContext.docIdx, new StandardAnalyzer(), false)
		writer.addDocument(ldoc)
		writer.flush()
		writer.close()
	}

	/**
	* Performs a search in the electronic archive by help of the index
	* @param searchTerms A string containing the search.
	*/
	def searchArchive(def searchTerms){
		IndexSearcher searcher = new IndexSearcher(servletContext.docIdx)
		
		QueryParser parser = new QueryParser("CONTENT", new StandardAnalyzer())
		parser.setDefaultOperator(QueryParser.AND_OPERATOR);
    		parser.setAllowLeadingWildcard(true);

		Query query = parser.parse(searchTerms)

		def hits = searcher.search(query)
		return hits
	}

	/**
	* Retrieves the document that is attached to the ID of the incoming 
	* document object.
	* @param docId The ID of the document object that is attached 
		       to the file
	* @return The expected document as a byte array
	*/
	def retrive(docId){
		def path = "${grailsApplication.config.archivePath}/${docId}"
		def bytes

		new File(path).eachFile{
			bytes = it.text
		}

		return bytes
	}
}
