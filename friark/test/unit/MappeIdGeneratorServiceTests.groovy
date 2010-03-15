import grails.test.*
import no.friark.ds.*
class MappeIdGeneratorServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testgeneratorForService() {
			def service = new MappeIdGeneratorService();
			assertEquals service.mappeIdGenerator, service.generatorForMappe(new Saksmappe())
			assertEquals service.seqGenerator, service.generatorForMappe(new Basismappe())
    }
}
