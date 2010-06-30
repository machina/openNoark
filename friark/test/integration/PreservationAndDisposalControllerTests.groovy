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
class PreservationAndDisposalControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	  /**
     * 5.10.28 
     * Det skal ikke være mulig å sette disposalDecision "Kasseres" på en mappe som er registrert som presedenssak.
     * 
     */
    void testKassasjonPrecedentSak(){
      def (ark, del, reg) = createStructure()
      def sm = new CaseFile(fileID: "10/00001", fileType: "dill", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "referansearkivdel.id": del.id, administrativeUnit: "a", caseDate: new Date(), caseStatus: "2", systemID: "13", caseResponsible: "somebody else")

      saveOrFail(sm)

      def presedens = new Precedent(precedentDate: new Date(), createdDate: new Date(), createdBy: "meg", title: "dill", description:"dall", precedentAuthority:"§42", leagalSourceFactor:"solfaktor 2", precedentApprovalDate: new Date(), precedentApprovedBy:"gnurke", precedentStatus:"presedert")

      saveOrFail(presedens)

      sm.precedent = presedens
      saveOrFail(sm)
			controller.params.disposalDecision = "Kasseres"
			controller.params.preservationTime =  1
      controller.params.disposalDate = new Date()
      controller.params.file = sm
			controller.save()

			assertEquals 0, PreservationAndDisposal.list().size()


			controller.params.disposalDecision = "Bevares"

      controller.save()
			assertEquals 1, PreservationAndDisposal.list().size()
    }

    def createStructure(){
      Fonds ark = new Fonds(systemID: "1", title: "title", fondsStatus: "Opprettet", createdDate: new Date(), createdBy: "meg")
      saveOrFail(ark)

      assertNotNull Fonds.get(ark.id)

      Series del = new Series(systemID: "2", title: "title", recordSectionStatus: "Opprettet", documentMedium: "text/html", createdBy:"deg", createdDate: new Date(), parent: ark )
      saveOrFail(del)

      SimplifiedRecord reg = new SimplifiedRecord(systemID: "3", createdDate: new Date(), createdBy: "dill", archivedDate: new Date(), archivedBy: "dall", recordSection: del, recordType: "type")
      saveOrFail(reg)

      return [ark, del, reg]
    }

}
