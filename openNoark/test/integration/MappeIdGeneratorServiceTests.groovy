import grails.test.*
import no.friark.ds.*
import java.text.DecimalFormat

class MappeIdGeneratorServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }


		void testMappeIdGenerator() {
			def service = new MappeIdGeneratorService();
			def gen = service.mappeIdGenerator
			assertEquals "10/00001", gen()
			
		}

		void testMappeIdGenerator2() {
			def (ark,del) = createStructure()
			
			Saksmappe m = new Saksmappe(mappeid: "10/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id, administrativenhet: "a", saksdato: new Date(), saksstatus: "2", systemID: "13", saksansvarlig: "somebody else")

			saveOrFail(m)
			def service = new MappeIdGeneratorService();
			def gen = service.mappeIdGenerator
			assertEquals "10/00002", gen()
			
		}

		void testSeqGenerator() {
			def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "1", gen()
		}

		void testSeqGenerator2() {
      def (ark,del) = createStructure()

      Saksmappe m = new Saksmappe(mappeid: "1", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id, administrativenhet: "a", saksdato: new Date(), saksstatus: "2", systemID: "13", saksansvarlig: "somebody else")

      saveOrFail(m)
      def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "2", gen()

    }


	void testSeqGenerator3() {
      def (ark,del) = createStructure()

      Saksmappe m = new Saksmappe(mappeid: "5", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id, administrativenhet: "a", saksdato: new Date(), saksstatus: "2", systemID: "13", saksansvarlig: "somebody else")

      saveOrFail(m)
			m = new Saksmappe(mappeid: "11", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id, administrativenhet: "a", saksdato: new Date(), saksstatus: "2", systemID: "14", saksansvarlig: "somebody else")

      saveOrFail(m)
			m = new Saksmappe(mappeid: "10", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id, administrativenhet: "a", saksdato: new Date(), saksstatus: "2", systemID: "15", saksansvarlig: "somebody else")
			saveOrFail(m)
      def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "12", gen()

   }


	def createStructure(){
    Arkiv ark = new Arkiv(systemID: "1", tittel: "tittel", arkivstatus: "Opprettet", opprettetdato: new Date(), opprettetav: "meg")
    saveOrFail(ark)
    assertNotNull Arkiv.get(ark.id)

    Arkivdel del = new Arkivdel(systemID: "2", tittel: "tittel", arkivdelstatus: "Opprettet", dokumentmedium: "text/html", opprettetav:"deg", opprettetdato: new Date(), referanseforelder: ark )
    saveOrFail(del)
		return [ark,del]
	}

}
