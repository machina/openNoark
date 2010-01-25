import org.jsecurity.crypto.hash.Sha1Hash
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

import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH
import no.machina.utils.StringInputStream

import no.friark.ds.*
class ArchiveService implements org.springframework.context.ApplicationContextAware {
	def grailsApplication
	org.springframework.context.ApplicationContext applicationContext
	def servletContext = SCH.servletContext
	
	def archive(docId, file){
		def path = "${grailsApplication.config.archivePath}/${docId}"
		println "archiving to: ${path}"
		new File(path).mkdir()
		path = "${path}/data"
		def data = file.text
		
		new File(path).append(data.decodeBase64())
		
		println("indexing doc: ${docId}")
		println "data: ${data.decodeBase64()}"
		indexFile(docId, new ByteArrayInputStream(data.decodeBase64()))
	}

	def indexFile(docId, file){
		
		if(!servletContext.docIdx) {
			println "!servletContext.docIdx"
			servletContext.docIdx = new RAMDirectory()
			
		} else {
			println("docIdx: ${servletContext.docIdx}")
		}
		def doc = Dokumentobjekt.findBySystemID(docId)
		
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

	def searchArchive(def searchTerms){
		IndexSearcher searcher = new IndexSearcher(servletContext.docIdx)
		
		QueryParser parser = new QueryParser("CONTENT", new StandardAnalyzer())
		parser.setDefaultOperator(QueryParser.AND_OPERATOR);
    parser.setAllowLeadingWildcard(true);
		Query query = parser.parse(searchTerms)

		def hits = searcher.search(query)
		println "num hits: ${hits.length()}"
		return hits
	}

	def retrive(docId){
		def path = "${grailsApplication.config.archivePath}/${docId}"
		def bytes
		new File(path).eachFile{
			bytes = it.text
		}
		return bytes
	}
}
