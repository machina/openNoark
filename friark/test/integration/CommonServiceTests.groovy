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
import org.friark.ds.*
import org.friark.ds.Fonds

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
