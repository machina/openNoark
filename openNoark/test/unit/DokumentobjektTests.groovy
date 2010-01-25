import grails.test.*
import no.friark.ds.*
class DokumentobjektTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
				mockForConstraintsTests(Dokumentobjekt)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
		void testNullablereferansedokumentBeskrivelse(){

    def dok = new Dokumentobjekt(systemID: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester",
                                  referanseregistrering: new ForenkletRegistrering()

                                  );

    assertTrue "To many not null constraints", dok.validate()
		dok.hasErrors()
	}

	void testNullablereferanseRegistrering(){
  	def dok = new Dokumentobjekt(systemID: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester",
                                  referansedokumentBeskrivelse:  new Dokumentbeskrivelse()
                                  );

    assertTrue "To many not null constraints", dok.validate()
		assertFalse dok.hasErrors()
	}



	void testNotNullableReferansedokumentBeskrivelseAndReg(){

    def dok = new Dokumentobjekt(systemID: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester"

                                  );

    assertFalse "To few constraints", dok.validate()
		assertTrue dok.hasErrors()

	}


	
}
