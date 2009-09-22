import grails.test.*

class BaseTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPoly() {
			String systemid = UUID.randomUUID().toString()
			Arkiv arkiv = new Arkiv(tittel: "hei", opprettetdato: new Date(), opprettetav: "da tester", systemid: systemid)
			if(!arkiv.save()){
				println arkiv.errors
				fail("save failed")
			}
			assertEquals "no Arkiv exists?", 1, Arkiv.list().size()
			def res = Base.findBySystemid(systemid);
			//def res = Base.findAll()[0];
			assertNotNull res
			assertTrue res instanceof Arkiv

			assertEquals "hei", res.tittel
    }
}
