/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

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
