import grails.test.*
import no.machina.utils.StringInputStream

class StringInputStreamTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	

		public void testRead(){
			StringInputStream sis = new StringInputStream("hei")
	
			int ch = sis.read()
			assertEquals((int)'h' as char, ch)
	
			ch = sis.read()
      assertEquals((int) 'e' as char, ch)

			ch = sis.read()
      assertEquals((int) 'i' as char, ch)

			ch = sis.read()
      assertEquals(-1, ch)
		}

		public void testAvailable(){
      StringInputStream sis = new StringInputStream("hei")
			
			assertEquals 3, sis.available()

			sis.read()
			assertEquals 2, sis.available()

			sis.read()
      assertEquals 1, sis.available()

			sis.read()
      assertEquals 0, sis.available()

    }


	
}
