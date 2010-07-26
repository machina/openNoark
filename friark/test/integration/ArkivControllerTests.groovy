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
class ArkivControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
			controller.commonService = new CommonService()
			controller.metaClass.message = { def attrs ->
				return attrs.code
			}
    }

    protected void tearDown() {
        super.tearDown()
    }

	
	void testupdateOppretterdato() {
				Fonds ark = new Fonds(systemID: "1", title: "title", arkivstatus: "Opprettet", createdDate: new Date(), createdBy: "meg")
		if(!ark.save()){
			println ark.errors
			fail "unable to save archive"
		}
		assertNotNull Fonds.get(ark.id)
		println "ark.id: ${ark.id}"
		controller.request.params = [id: ark.id, title:  "title", arkivstatus: "Opprettet",createdBy: "meg", createdDate_day: 1, createdDate_month: 12, createdDate: "struct", createdDate_year: 2009]
			controller.params.id = ark.id
		 controller.request.method = "POST"
		def retval = controller.update([createdDate: Date.parse("yyyy-MM-dd", "2009-12-1")] as UpdateFondsCommand)
		println "retval.errors: ${retval.errors}"
		assertTrue( retval.errors.toString().contains("fonds.cannot.change.created.date") )
	}


	void testupdatefinalisedDate() {
		def createdDate = new Date()

    Fonds ark = new Fonds(systemID: "21", title: "title", arkivstatus: "Opprettet", createdDate: createdDate, createdBy: "meg", finalisedDate: new Date())
    ark.save()

    controller.request.params = [title: "title", arkivstatus: "Opprettet", createdBy: "meg", finalisedDate: null ]
		controller.params.id = ark.id
		controller.request.method = "POST"

    def retval = controller.update([] as UpdateFondsCommand)
		println "retval.errors: ${retval.errors}"
    assertTrue (retval.errors.toString().contains( "fonds.cannot.remove.finalised.date") )
		
  }
}
