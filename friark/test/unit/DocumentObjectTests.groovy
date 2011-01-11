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
class DocumentObjectTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
	mockForConstraintsTests(DocumentObject)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
    void testNullablereferansedocumentDescription(){

    def dok = new DocumentObject(systemID: "test",
                                  versionNumber:"1",
                                  variantFormat:"tekst",
                                  format: "ascii",
                                  createdDate: new Date(),
                                  createdBy: "tester",
                                  record: new SimplifiedRecord()

                                  );
	dok.validate()
	println dok.errors
        assertTrue "To many not null constraints", dok.validate()
		assertFalse dok.hasErrors()
	}

	void testNullablereferanseRegistrering(){
  	def dok = new DocumentObject(systemID: "test",
                                  versionNumber: "1",
                                  variantFormat:"tekst",
                                  format: "ascii",
                                  createdDate: new Date(),
                                  createdBy: "tester",
                                  documentDescription:  new DocumentDescription()
                                  );

    assertTrue "To many not null constraints", dok.validate()
		assertFalse dok.hasErrors()
	}

	void testNotNullableReferansedocumentDescriptionAndReg(){

    def dok = new DocumentObject(systemID: "test",
                                  versionNumber: "1",
                                  variantFormat:"tekst",
                                  format: "ascii",
                                  createdDate: new Date(),
                                  createdBy: "tester"

                                  );

    assertFalse "To few constraints", dok.validate()
		assertTrue dok.hasErrors()

	}
}
