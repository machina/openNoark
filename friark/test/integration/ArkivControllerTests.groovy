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
import no.friark.ds.*
class ArkivControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	
	void testupdateOppretterdato() {
		Arkiv ark = new Arkiv(systemID: "1", tittel: "tittel", arkivstatus: "Opprettet", opprettetdato: new Date(), opprettetav: "meg")
		if(!ark.save()){
			println ark.errors
			fail "unable to save archive"
		}
		assertNotNull Arkiv.get(ark.id)
		println "ark.id: ${ark.id}"
		controller.request.params = [id: ark.id, tittel:  "tittel", arkivstatus: "Opprettet",opprettetav: "meg", opprettetdato_day: 1, opprettetdato_month: 12, opprettetdato: "struct", opprettetdato_year: 2009]
			controller.params.id = ark.id
		 controller.request.method = "POST"
		def retval = controller.update([opprettetdato: Date.parse("yyyy-MM-dd", "2009-12-1")] as UpdateArkivCommand)
		println "retval.errors: ${retval.errors}"
		assertTrue( retval.errors.toString().contains("Kan ikke endre dato for opprettelse av arkiv.") )
	}


	void testupdateavsluttetdato() {
		def opprettetdato = new Date()
    Arkiv ark = new Arkiv(systemID: "21", tittel: "tittel", arkivstatus: "Opprettet", opprettetdato: opprettetdato, opprettetav: "meg", avsluttetdato: new Date())
    ark.save()

    controller.request.params = [tittel: "tittel", arkivstatus: "Opprettet", opprettetav: "meg", avsluttetdato: null ]
		controller.params.id = ark.id
		controller.request.method = "POST"

    def retval = controller.update([] as UpdateArkivCommand)
		println "retval.errors: ${retval.errors}"
    assertTrue (retval.errors.toString().contains( "Kan ikke fjerne avsluttetdato.") )
		
  }
}
