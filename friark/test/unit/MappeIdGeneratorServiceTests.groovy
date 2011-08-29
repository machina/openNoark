import grails.test.*
import org.friark.ds.*
import org.friark.services.*

class MappeIdGeneratorServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testgeneratorForService() {
			def service = new MappeIdGeneratorService();
			assertEquals service.mappeIdGenerator, service.generatorForMappe(new CaseFile())
			assertEquals service.seqGenerator, service.generatorForMappe(new BasicFile())
    }
}
