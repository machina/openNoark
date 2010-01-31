import grails.test.*
import no.friark.ds.*
class BaseTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPoly() {
			String systemID = UUID.randomUUID().toString()
			Arkiv arkiv = new Arkiv(tittel: "hei", opprettetdato: new Date(), opprettetav: "da tester", systemID: systemID)
			if(!arkiv.save()){
				println arkiv.errors
				fail("save failed")
			}
			assertEquals "no Arkiv exists?", 1, Arkiv.list().size()
			def res = Base.findBySystemID(systemID);
			//def res = Base.findAll()[0];
			assertNotNull res
			assertTrue res instanceof Arkiv

			assertEquals "hei", res.tittel
    }
}
