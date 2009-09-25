import grails.test.*

class DokumentobjektTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
				mockForConstraintsTests(Dokumentobjekt)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
		void testNullablereferansedokumentBeskrivelse(){

    def dok = new Dokumentobjekt(systemid: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester",
                                  referanseregistrering: new ForenkletRegistrering(),

                                  );

    assertTrue "To many not null constraints", dok.validate()

	}
}
