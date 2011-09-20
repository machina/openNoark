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
class BaseTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPoly() {
      String systemID = UUID.randomUUID().toString()
	   Fonds arkiv = new Fonds(title: "hei", createdDate: new Date(), createdBy: "da tester", systemID: systemID)

	   if(!arkiv.save()){
	      println arkiv.errors
  	      fail("save failed")
	   }

	   assertEquals "no Fonds exists?", 1, Fonds.list().size()

	   def res = Base.findBySystemID(systemID);
	   assertNotNull res
	   assertTrue res instanceof Fonds

	   assertEquals "hei", res.title
    }
}
