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
class DokumentobjektTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
				mockForConstraintsTests(Dokumentobjekt)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
		void testNullablereferansedokumentBeskrivelse(){

    def dok = new Dokumentobjekt(systemID: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester",
                                  referanseregistrering: new ForenkletRegistrering()

                                  );

    assertTrue "To many not null constraints", dok.validate()
		dok.hasErrors()
	}

	void testNullablereferanseRegistrering(){
  	def dok = new Dokumentobjekt(systemID: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester",
                                  referansedokumentBeskrivelse:  new Dokumentbeskrivelse()
                                  );

    assertTrue "To many not null constraints", dok.validate()
		assertFalse dok.hasErrors()
	}



	void testNotNullableReferansedokumentBeskrivelseAndReg(){

    def dok = new Dokumentobjekt(systemID: "test",
                                  versjonsnummer:"1",
                                  variantformat:"tekst",
                                  format: "ascii",
                                  opprettetdato: new Date(),
                                  opprettetav: "tester"

                                  );

    assertFalse "To few constraints", dok.validate()
		assertTrue dok.hasErrors()

	}


	
}
