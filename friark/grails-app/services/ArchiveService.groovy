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
* Inneholder metoder for å håndtere et enkelt elektronisk arkiv. Arkivets lokasjon abgjøres av konfigurasjonsparameteren "archivePath".
*/
class ArchiveService implements org.springframework.context.ApplicationContextAware {
	def grailsApplication
	org.springframework.context.ApplicationContext applicationContext
	def servletContext = SCH.servletContext
	
	/**
	* Arkiverer en fil som filen knyttet til DocumentObject objektet med id docId og indexerer den.
	* @param docId  Id til dokumentobjektet som skal knyttes til den inkommende filen.
  * @param file Filen som skal arkiveres, som en innkommende base64 enkodet fil.
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
  * Fjerner filen forbundet med det inkommende dokumentobjektet fra arkivet.
  * @param dokumentobjekt Objeket som er knyttet til filen som slettes-
  */
	def delteFromArchive(DocumentObject dokumentobjekt){
		if(dokumentobjekt.documentFile){
			removeFromIndex(dokumentobjekt.systemID)
			def f = new File(dokumentobjekt.documentFile)
			if(f.exists()) f.delete()
		}
	}

  /**
  * Fjerner dokumentet som er kyttet til den inkommede DocumentObject id'en fra søkeindexen for elektroniske dokumenter.
  * @param docId Streng som inneholder id'en til dokumentet som skal fjernes fra indexen.
  */
	def removeFromIndex(docId){
		if(!servletContext.docIdx) {
			return //liten vits i å fjerne fra ikke-eksisiterende index
   }
			IndexWriter writer = new IndexWriter(servletContext.docIdx, new StandardAnalyzer(), false)
			writer.deleteDocuments( new Term("DOC-OBJ", docId))
			writer.flush()
			writer.close()
	}

	/**
	* Indexerer den inkommende filen.
	* @param docId Id'en til dokumentobjektet
  * @param file filen som indexeres.
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
		println "content: ${handler.toString()}"
		//doc.add(new Field("FILENAME", file.name, Field.Store.YES, Field.Index.UN_TOKENIZED));
		ldoc.add(new Field("DOC-OBJ", doc.systemID, Field.Store.YES, Field.Index.NO))
		
		IndexWriter writer = new IndexWriter(servletContext.docIdx, new StandardAnalyzer(), false)
		//println "docs in index pre: ${writer.docCount()}  ${writer.numRamDocs()}"
		writer.addDocument(ldoc)
		//println "docs in index post: ${writer.docCount()}  ${writer.numRamDocs()}"
		writer.flush()
		writer.close()
	
	}

	/**
	* Utføerer et søk i det elektroniske arkivet ved hjelp av indexen.
  * @param searchTerms En String som inneholder søket.
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
  * Henter dokumentet som er knyttet til den innkommende dokumentobjekt id'en.
  * @param docId Id'en til dokumentobjektet som er knyttet til den ønskede filen
  * @return det ønskede dokumentet som en byte[]
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
