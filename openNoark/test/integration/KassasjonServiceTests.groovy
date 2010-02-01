import grails.test.*
import no.friark.ds.*
import no.friark.ds.Arkiv

class KassasjonServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	
    void testOversiktIngenKassason() {
			def ark, del, reg = createStructure()
			
			KassasjonService service = new KassasjonService()
			def list = service.oversikt([fra: new Date(), til: new Date(), kassasjonsvedtak: "Bevares"])
			assertEquals 0, list?.size()
    }

		void testOversikt(){
			def ark, del, reg = createStructure()
			Dokumentbeskrivelse desc = new Dokumentbeskrivelse(systemID: "2141", dokumenttype: "type", dokumentstatus: "status", tittel: "tittel", beskrivelse:"desc", forfatter: "forfatter", opprettetdato: new Date(), opprettetav: "dill", dokumentmedium: "pysical/papyrus", oppbevaringssted: "her og der")

			if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }

			
			BevaringOgKassasjon bev = new BevaringOgKassasjon(kassasjonsvedtak: "Bevares", bevaringstid: 1, kassasjonsdato: new Date(), dokumentBeskrivelse: [desc])
			if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			desc.bevaringOgKassasjon = bev
			desc.save()
			
			def co = [fra: new Date() - 2, til: new Date() + 2, kassasjonsvedtak: "Bevares"]

			KassasjonService service = new KassasjonService()

			def list = service.oversikt(co)
			assertEquals 1, list?.size()

			def dok = list[0]
			assertTrue dok instanceof Dokumentbeskrivelse
		}

		void testOversikt2i1(){
			def ark, del, reg = createStructure()
			Dokumentbeskrivelse desc = new Dokumentbeskrivelse(systemID: "2141", dokumenttype: "type", dokumentstatus: "status", tittel: "tittel", beskrivelse:"desc", forfatter: "forfatter", opprettetdato: new Date(), opprettetav: "dill", dokumentmedium: "pysical/papyrus", oppbevaringssted: "her og der")

			if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }

			Dokumentbeskrivelse desc2 = new Dokumentbeskrivelse(systemID: "21412", dokumenttype: "type", dokumentstatus: "status", tittel: "tittel", beskrivelse:"desc", forfatter: "forfatter", opprettetdato: new Date(), opprettetav: "dill", dokumentmedium: "pysical/papyrus", oppbevaringssted: "her og der")
      
      if(!desc2.save()){
        println desc2.errors
        fail "unable to save desc"
      }

			
			BevaringOgKassasjon bev = new BevaringOgKassasjon(kassasjonsvedtak: "Bevares", bevaringstid: 1, kassasjonsdato: new Date(), dokumentBeskrivelse: [desc, desc2])
			if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			desc.bevaringOgKassasjon = bev
			desc.save()
			
			def co = [fra: new Date() - 2, til: new Date() + 2, kassasjonsvedtak: "Bevares"]

			KassasjonService service = new KassasjonService()

			def list = service.oversikt(co)
			assertEquals 2, list?.size()

			def dok = list[0]
			assertTrue dok instanceof Dokumentbeskrivelse
		}

		void testOversikt2i2(){
			def ark, del, reg = createStructure()
			Dokumentbeskrivelse desc = new Dokumentbeskrivelse(systemID: "2141", dokumenttype: "type", dokumentstatus: "status", tittel: "tittel", beskrivelse:"desc", forfatter: "forfatter", opprettetdato: new Date(), opprettetav: "dill", dokumentmedium: "pysical/papyrus", oppbevaringssted: "her og der")

			if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }

			Dokumentbeskrivelse desc2 = new Dokumentbeskrivelse(systemID: "21412", dokumenttype: "type", dokumentstatus: "status", tittel: "tittel", beskrivelse:"desc", forfatter: "forfatter", opprettetdato: new Date(), opprettetav: "dill", dokumentmedium: "pysical/papyrus", oppbevaringssted: "her og der")
      
      if(!desc2.save()){
        println desc2.errors
        fail "unable to save desc"
      }

			
			BevaringOgKassasjon bev = new BevaringOgKassasjon(kassasjonsvedtak: "Bevares", bevaringstid: 1, kassasjonsdato: new Date(), dokumentBeskrivelse: [desc])
			if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			BevaringOgKassasjon bev2 = new BevaringOgKassasjon(kassasjonsvedtak: "Bevares", bevaringstid: 3, kassasjonsdato: new Date() + 2, dokumentBeskrivelse: [desc])
      if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }		

	
			def co = [fra: new Date() - 2, til: new Date() + 2, kassasjonsvedtak: "Bevares"]

			KassasjonService service = new KassasjonService()

			def list = service.oversikt(co)
			assertEquals 1, list?.size()

			def dok = list[0]
			assertTrue dok instanceof Dokumentbeskrivelse
		}


		void testKasser() {
			def ark, del, reg = createStructure()
      Dokumentbeskrivelse desc = new Dokumentbeskrivelse(systemID: "2141", dokumenttype: "type", dokumentstatus: "status", tittel: "tittel", beskrivelse:"desc", forfatter: "forfatter", opprettetdato: new Date(), opprettetav: "dill", dokumentmedium: "pysical/papyrus", oppbevaringssted: "her og der")

      if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }
			
			Dokumentobjekt obj = new Dokumentobjekt(systemID: "AASA", versjonsnummer:"1", variantformat:"1", format:"1", formatdetaljer:"2", opprettetdato: new Date(), opprettetav:"dall", referansedokumentBeskrivelse:desc )
			/*if(!obj.save(){
				println desc.errors
        fail "unable to save desc"
			}*/
			saveOrFail(obj)
			
			desc.addToReferansedokumentObjekt(obj)

			BevaringOgKassasjon bev = new BevaringOgKassasjon(kassasjonsvedtak: "Kasseres", bevaringstid: 1, kassasjonsdato: new Date(), dokumentBeskrivelse: [desc])
      if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			def co = [fra: new Date() - 2, til: new Date() + 2, kassasjonsvedtak: "Kasseres"]

      KassasjonService service = new KassasjonService()
			service.archiveService = new ArchiveService()
      def list = service.oversikt(co)
      assertEquals 1, list?.size()
			
			assertEquals 1, Dokumentobjekt.list().size()
			println "kasserer ${desc}"
			service.kasser(desc)

			assertEquals 0, Dokumentobjekt.list().size()
		}


		def createStructure(){
			Arkiv ark = new Arkiv(systemID: "1", tittel: "tittel", arkivstatus: "Opprettet", opprettetdato: new Date(), opprettetav: "meg")
			saveOrFail(ark)
      
			assertNotNull Arkiv.get(ark.id)

      Arkivdel del = new Arkivdel(systemID: "2", tittel: "tittel", arkivdelstatus: "Opprettet", dokumentmedium: "text/html", opprettetav:"deg", opprettetdato: new Date(), referanseforelder: ark )
			saveOrFail(del)

      ForenkletRegistrering reg = new ForenkletRegistrering(systemID: "3", opprettetdato: new Date(), opprettetav: "dill", arkivertdato: new Date(), arkivertav: "dall", referansearkivdel: del, registreringstype: "type")
			saveOrFail(reg)
			
			return [ark, del, reg]
		}




}
