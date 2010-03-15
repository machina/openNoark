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
class BevaringOgKassasjonControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	  /**
     * 5.10.28 
     * Det skal ikke være mulig å sette kassasjonsvedtak "Kasseres" på en mappe som er registrert som presedenssak.
     * 
     */
    void testKassasjonPresedensSak(){
      def (ark, del, reg) = createStructure()
      def sm = new Saksmappe(mappeid: "10/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id, administrativenhet: "a", saksdato: new Date(), saksstatus: "2", systemID: "13", saksansvarlig: "somebody else")

      saveOrFail(sm)

      def presedens = new Presedens(presedensdato: new Date(), opprettetdato: new Date(), opprettetav: "meg", tittel: "dill", beskrivelse:"dall", presedenshjemmel:"§42", rettskildefaktor:"solfaktor 2", presedensgodkjentdato: new Date(), presedensgodkjentav:"gnurke",presedensstatus:"presedert")

      saveOrFail(presedens)

      sm.presedens = presedens
      saveOrFail(sm)
			controller.params.kassasjonsvedtak = "Kasseres"
			controller.params.bevaringstid =  1
      controller.params.kassasjonsdato = new Date()
      controller.params.mappe = sm
			controller.save()

			assertEquals 0, BevaringOgKassasjon.list().size()


			controller.params.kassasjonsvedtak = "Bevares"

      controller.save()
			assertEquals 1, BevaringOgKassasjon.list().size()
    }

    def createStructure(){
      Arkiv ark = new Arkiv(systemID: "1", tittel: "tittel", arkivstatus: "Opprettet", opprettetdato: new Date(), opprettetav: "meg")
      saveOrFail(ark)

      assertNotNull Arkiv.get(ark.id)

      Arkivdel del = new Arkivdel(systemID: "2", tittel: "tittel", arkivdelstatus: "Opprettet", dokumentmedium: "text/html", opprettetav:"deg", opprettetdato: new Date(), referanseforelder: ark )
      saveOrFail(del)

      ForenkletRegistrering reg = new ForenkletRegistrering(systemID: "3", opprettetdato: new Date(), opprettetav: "dill", arkivertdato: new Date(), arkivertav: "dall", referansearkivdel: del, registreringstype: "type")
      saveOrFail(reg)

      return [ark, del, reg]
    }

}
