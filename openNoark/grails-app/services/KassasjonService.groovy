import no.friark.*
import no.friark.ds.*
import no.machina.gestalt2.SandboxingClassLoader
import org.apache.shiro.SecurityUtils
class KassasjonService {

    boolean transactional = true
		def archiveService

		def klasserIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.registreringer.each { reg -> 
					if(reg.referanseregistrering.referanseforelderKlasse) retval << reg.referanseregistrering.referanseforelderKlasse
					if(reg.referanseregistrering.referanseforelderBasismappe.referanseforelderKlasse) retval << reg.referanseregistrering.referanseforelderBasismappe.referanseforelderKlasse
				}
			} 
		}

		def mapperIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.registreringer.each { reg ->
					if(reg.referanseregistrering.referanseforelderBasismappe) retval << reg.referanseregistrering.referanseforelderBasismappe
				}
      }
		}

		def arkivdelerIDokliste(def liste){
			return iDokListe(liste) { retval, dok ->
				dok.registreringer.each { reg ->
					if(reg.referanseregistrering.referansearkivdel) retval << reg.referanseregistrering.referansearkivdel
					if(reg.referanseregistrering.referanseforelderBasismappe.referansearkivdel) retval << reg.referanseregistrering.referanseforelderBasismappe.referansearkivdel
				}
			}
		}

		def iDokListe(def liste, def getter){
			def retval = []
			getter = getter.curry(retval)
			liste.each getter
			return retval.unique()
		}


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

		def dokumenterFraDokument(def vedtak){
			if(vedtak.dokumentBeskrivelse) return vedtak.dokumentBeskrivelse
			return []
		}

		def dokumenterFraRegistrering(def vedtak){
			def retval = []
			if(vedtak.registrering){
				vedtak.registrering.each{ reg ->
  	      //Dokumentlink!!
	        reg.dokumenter.each{ dokLink ->
          if(dokLink.dokumentbeskrivelse.bevaringOgKassasjon == null && dokLink.dokumentbeskrivelse.kassertDato != null ) retval << dokLink.dokumentbeskrivelse
         }
       }
			}
			return retval
		}

		def dokumenterFraMappe(def vedtak){
			def retval = []
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.mappe){
				vedtak.mappe.each { mappe ->
					mappe.referansebarnForenkletRegistrering.each leggTilFraReg
				}
			}
			return retval
		}

		def dokumenterFraKlasse(def vedtak){
			def retval = []
			def leggTilFraReg = leggTilFraReg.curry(retval)
			if(vedtak.klasse){
				vedtak.klasse.each{ klasse ->
					klasse.referansebarnForenkletRegistrering.each leggTilFraReg
				}
			}
			return retval
		}

		def dokumenterFraArkivdel(def vedtak){
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

	def kasser(List dokumenter){
		dokumenter.each{ dok ->
			println "kasserer dok ${dok}"
			kasser(dok)
		}
	}

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
