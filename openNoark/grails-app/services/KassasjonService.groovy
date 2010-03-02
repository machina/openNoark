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
import no.friark.ds.*
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
				dok.registreringer.each { reg -> 
					if(reg.referanseregistrering.referanseforelderKlasse) retval << reg.referanseregistrering.referanseforelderKlasse
					if(reg.referanseregistrering.referanseforelderBasismappe != null && reg.referanseregistrering.referanseforelderBasismappe.referanseforelderKlasse != null) retval << reg.referanseregistrering.referanseforelderBasismappe.referanseforelderKlasse
				}
			} 
		}

		/**
    * Finner mappene som er knyttet til hvert av dokumentlenkene i listen
    * @param liste en List med dokumentlenker
    */
		def mapperIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.registreringer.each { reg ->
					if(reg.referanseregistrering.referanseforelderBasismappe) retval << reg.referanseregistrering.referanseforelderBasismappe
				}
      }
		}

		/**
    * Finner arkivdelene som er knyttet til hvert av dokumentlenkene i listen
    * @param liste en List med dokumentlenker
    */
		def arkivdelerIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.registreringer.each { reg ->
					if(reg.referanseregistrering.referansearkivdel) retval << reg.referanseregistrering.referansearkivdel
					if(reg.referanseregistrering.referanseforelderBasismappe != null && reg.referanseregistrering.referanseforelderBasismappe.referansearkivdel != null) retval << reg.referanseregistrering.referanseforelderBasismappe.referansearkivdel
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
    * @param co Et objekt med feltene fra, til og kassasjonsvedtak.
    * @return Drrunerer alle dokumentbeskrivelser som operasjonen i kassasjonsvedtak skal utføres på mellom datoene fra og til.
    */
    def oversikt(def co) {
			def retval = []
			def c = BevaringOgKassasjon.createCriteria()

			def results = c {
				like("kassasjonsvedtak", co.kassasjonsvedtak)
				between("kassasjonsdato", co.fra, co.til)
			}
			if(results){
				results.each{
					retval << dokumenterFraDokument(it)
					retval << dokumenterFraRegistrering(it)			
					retval << dokumenterFraMappe(it)
					retval << dokumenterFraArkivdel(it)
					retval << dokumenterFraKlasse(it)
				}
			}
			retval.flatten()
    }

		private def dokumenterFraDokument(def vedtak){
			if(vedtak.dokumentBeskrivelse) return vedtak.dokumentBeskrivelse
			return []
		}

		private def dokumenterFraRegistrering(def vedtak){
			def retval = []
			if(vedtak.registrering){
				vedtak.registrering.each{ reg ->
  	      //Dokumentlink!!
	        reg.dokumenter.each{ dokLink ->
        	  if(dokLink.dokumentbeskrivelse.bevaringOgKassasjon == null && dokLink.dokumentbeskrivelse.kassertDato == null ){
							 retval << dokLink.dokumentbeskrivelse
						}
         }
       }
			}
			return retval
		}

		private def dokumenterFraMappe(def vedtak){
			def retval = []
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.mappe){
				vedtak.mappe.each { mappe ->
					mappe.referansebarnForenkletRegistrering.each leggTilFraReg
				}
			}
			return retval
		}

		private def dokumenterFraKlasse(def vedtak){
			def retval = []
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.klasse){
				vedtak.klasse.each{ klasse ->
					klasse.referansebarnForenkletRegistrering.each leggTilFraReg
				}
			}
			return retval
		}

		private def dokumenterFraArkivdel(def vedtak){
			def retval = []
			def leggTilFraMappe = leggTilFraMappe.curry(retval)
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.arkivdel){
				vedtak.arkivdel.each {arkivdel ->
					arkivdel.referansemappe.each leggTilFraMappe
					arkivdel.referanseregistrering.each leggTilFraReg
				}
			}
			return retval
		}

		def leggTilFraMappe = {retval, mappe ->
			def leggTilFraReg = leggTilFraMappe.curry(retval)
			if(mappe.bevaringOgKassasjon == null) mappe.referansebarnForenkletRegistrering.each leggTilFraReg

		}

		def  leggTilFraReg = { retval, reg->
			def leggTilFraDokLink = leggTilFraDokLink.curry(retval)
			if(reg.bevaringOgKassasjon == null) reg.dokumenter.each leggTilFraDokLink	
		}
		
		def leggTilFraDokLink = { retval, dokLink ->
			if(dokLink.dokumentbeskrivelse.bevaringOgKassasjon == null && dokLink.dokumentbeskrivelse.kassertDato == null) retval << dokLink.dokumentbeskrivelse
		}

    /**
    * Filtrerer dokumentbeskrivlser.
		* @param liste dokumentbeskrivelsebe som skal filtreres.
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
  * @param dokumenter En liste dokumentbeskrivelser som skal kasseres.
  */
	def kasser(List dokumenter){
		dokumenter.each{ dok ->
			println "kasserer dok ${dok}"
			kasser(dok)
		}
	}

  /**
  * Kasserer et dokument. Kassering betyr fjerneing av alle Dokumentobjekt og tilknyttede dokumenter.
  * @param dok Dokumentet som skal kasseres. 
  */
	def kasser(Dokumentbeskrivelse dok){
		dok.referansedokumentObjekt.each{
			if(dok.registreringer?.size() <= 1){
				archiveService.delteFromArchive(it)				
			}
			dok.removeFromReferansedokumentObjekt(it)
			it.delete()
		}
		dok.kassertDato = new Date()
		dok.kassertAv = SecurityUtils.subject.principal
		dok.save()
	}
}
