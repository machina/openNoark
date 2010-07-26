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

import no.friark.*
import org.friark.ds.*
import no.machina.gestalt2.SandboxingClassLoader
import org.apache.shiro.SecurityUtils

/**
* En Service klasse med funksjoner relatert til Bevaring og kassasjoner.
*/
class KassasjonService {

    boolean transactional = true
		def archiveService

		/**
		* Finner klassene som er knyttet til hvert av dokumentlenkene i listen
    * @param liste en List med dokumentlenker
		*/
		def klasserIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.records.each { reg -> 
					if(reg.referenceRecord.parentClass) retval << reg.referenceRecord.parentClass
					if(reg.referenceRecord.parentFile != null && reg.referenceRecord.parentFile.parentClass != null) retval << reg.referenceRecord.parentFile.parentClass
				}
			} 
		}

		/**
    * Finner mappene som er knyttet til hvert av dokumentlenkene i listen
    * @param liste en List med dokumentlenker
    */
		def mapperIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.records.each { reg ->
					if(reg.referenceRecord.parentFile) retval << reg.referenceRecord.parentFile
				}
     }
		}

		/**
    * Finner arkivdelene som er knyttet til hvert av dokumentlenkene i listen
    * @param liste en List med dokumentlenker
    */
		def arkivdelerIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.records.each { reg ->
					if(reg.referenceRecord.recordSection) retval << reg.referenceRecord.recordSection
					if(reg.referenceRecord.parentFile != null && reg.referenceRecord.parentFile.recordSection != null) retval << reg.referenceRecord.parentFile.recordSection
				}
			}
		}

		private def iDokListe(def liste, def getter){
			def retval = []
			getter = getter.curry(retval)
			liste.each getter
			return retval.unique()
		}

		/**
    * En oversikt over bevatinger og kassasjoner.
    * @param co Et objekt med feltene fra, til og disposalDecision.
    * @return Drrunerer alle documentDescriptionr som operasjonen i disposalDecision skal utføres på mellom datoene fra og til.
    */
    def oversikt(def co) {
			def retval = []
			def c = PreservationAndDisposal.createCriteria()

			def results = c {
				like("disposalDecision", co.disposalDecision)
				between("disposalDate", co.fra, co.til)
			}
			if(results){
				results.each{
					retval << dokumenterFraDokument(it)
					retval << dokumenterFraRegistrering(it)			
					retval << dokumenterFraMappe(it)
					retval << dokumenterFraSeries(it)
					retval << dokumenterFraKlass(it)
				}
			}
			retval.flatten()
   }

		private def dokumenterFraDokument(def vedtak){
			if(vedtak.documentDescription) return vedtak.documentDescription
			return []
		}

		private def dokumenterFraRegistrering(def vedtak){
			def retval = []
			if(vedtak.record){
				vedtak.record.each{ reg ->
  	      //DocumentLink!!
	        reg.document.each{ dokLink ->
        	  if(dokLink.documentDescription.preservationAndDisposal == null && dokLink.documentDescription.disposalDate == null ){
							 retval << dokLink.documentDescription
						}
        }
      }
			}
			return retval
		}

		private def dokumenterFraMappe(def vedtak){
			def retval = []
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.file){
				vedtak.file.each { mappe ->
					mappe.childRecord.each leggTilFraReg
				}
			}
			return retval
		}

		private def dokumenterFraKlass(def vedtak){
			def retval = []
			def leggTilFraReg = leggTilFraReg.curry(retval)
			def leggTilFraMappe = leggTilFraMappe.curry(retval)
			if(vedtak.klass){
				vedtak.klass.each{ klasse ->
					klasse.childRecord.each leggTilFraReg
					println "klasse.referansebarnBasicFile ${klasse.childFile}"
					klasse.childFile.each leggTilFraMappe
				}
			}
			return retval
		}

		private def dokumenterFraSeries(def vedtak){
			def retval = []
			def leggTilFraMappe = leggTilFraMappe.curry(retval)
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.series){
				vedtak.series.each {arkivdel ->
					arkivdel.file.each leggTilFraMappe
					arkivdel.record.each leggTilFraReg
				}
			}
			return retval
		}

		def leggTilFraMappe = {retval, mappe ->
			def leggTilFraReg = leggTilFraReg.curry(retval)
			println "mappe ${mappe}"
			//printn "mappe.referansebarnSimplifiedRecord ${mappe.referansebarnSimplifiedRecord}"
			if(mappe.bevaringOgKassasjon == null) SimplifiedRecord.findAllByparentFile(mappe).each leggTilFraReg

		}

		def  leggTilFraReg = { retval, reg->
			def leggTilFraDokLink = leggTilFraDokLink.curry(retval)
			if(reg.preservationAndDisposal == null) reg.document.each leggTilFraDokLink	
		}
		
		def leggTilFraDokLink = { retval, dokLink ->
			if(dokLink.documentDescription.preservationAndDisposal == null && dokLink.documentDescription.disposalDate == null) retval << dokLink.documentDescription
		}

    /**
    * Filtrerer dokumentbeskrivlser.
		* @param liste documentDescriptionbe som skal filtreres.
    * @param filter filtreret enten som en streng eller Filter
    */
		def filter(liste, filter){
			println filter
			if(filter instanceof String) {
				def cl = new SandboxingClassLoader(["java.lang.String": ["length"], "java.lang.Integer": [], "org.codehaus.groovy.runtime.InvokerHelper": [], "java.lang.Object": ["build"], "no.friark.FilterBuilder": [], "no.friark.Filter": [], "java.lang.Long": []])
				FilterBuilder fb = new FilterBuilder()
		    Binding binding = new Binding()
  		  binding.setVariable("builder", fb)
				//TODO: this is wildly unsafe. must be
	    	//GroovyShell shell = new GroovyShell(binding); 
  		  def builderString = "builder.build{\n${filter}\n}\n return builder.filter"
				Class scriptClass = cl.parseClass(new GroovyCodeSource(builderString, "restriced", "/restricted/res"));
  	    def script = scriptClass.newInstance()
    	  script.setBinding(binding)
				filter = script.run()
//		    filter = shell.evaluate(builderString);
			}
			println filter
			if(filter == null) return liste
			def retval = []
			liste.each{
				if(filter.isApplicable(it)){ 
					retval << it 
				}
			}
			return retval
		}

  /**
  * Kasserer en liste dokumenter
  * @param dokumenter En liste documentDescriptionr som skal kasseres.
  */
	def kasser(List dokumenter, slettTilMappe = false){
		dokumenter.each{ dok ->
			println "kasserer dok ${dok}"
			kasser(dok, slettTilMappe)
		}
	}

  /**
  * Kasserer et dokument. Kassering betyr fjerneing av alle DocumentObject og tilknyttede dokumenter.
  * @param dok Dokumentet som skal kasseres. 
  */
	def kasser(DocumentDescription dok, slettTilMappe = false){
		if (!SecurityUtils.subject.isPermitted("kassasjon:kassere:${dok.id}")) {
			throw new Exception("Kassering ikke tillatt for bruker.")
		}	
		dok.documentObject.each{
			if(dok.records?.size() <= 1){
				archiveService.delteFromArchive(it)				
			}
			dok.removeFromDocumentObject(it)
			it.documentDescription = null
			it.delete(flush:true)
		}

		dok.disposalDate = new Date()
		dok.disposedBy = SecurityUtils.subject.principal
		dok.save()
		println "slettTilmappe: ${slettTilMappe}"
		if(slettTilMappe){
			println "sletttilmappe!"
			dok.records.each{ dl ->
				println "DL"
				dok.removeFromRecords(dl)
				dl.delete()

				def reg = dl.referenceRecord
				if(reg.parentFile) {
					reg.parentFile.removeFromChildRecord(reg)
					reg.parentFile.save()
				}
				reg.delete()

							}
			if(dok.preservationAndDisposal){
				println "fiksing bev"
				def bev = dok.preservationAndDisposal
			  bev.removeFromDocumentDescription(dok)
				dok.preservationAndDisposal = null
				//bev.save()
			}
			println dok.records
			println dok.documentObject
			println dok.remark
			dok.documentObject = null
			dok.delete()
		} else {
			dok.save()
		}
	}
}
