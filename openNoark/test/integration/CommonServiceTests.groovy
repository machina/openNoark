import grails.test.*
import no.friark.ds.*
import no.friark.ds.Arkiv

class CommonServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

		void testGetParameter(){
			createParameter()
			def commonService = new CommonService()
			assertEquals "1", commonService.getParameter("en")
			assertEquals "2", commonService.getParameter("to")

		}


		void createParameter(){
			new Parameter(key: "en", value: "1").save()
			new Parameter(key: "to", value: "2").save()
		}
}
