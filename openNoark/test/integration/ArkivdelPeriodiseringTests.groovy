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

class ArkivdelPeriodiseringTests extends GrailsUnitTestCase {
  protected void setUp() {
  	super.setUp()
		org.apache.shiro.SecurityUtils.metaClass.'static'.getSubject = { return [principal : "testuser"] }
  }

  protected void tearDown() {
		super.tearDown()
  }

	/*
	*	Det skal være mulig å knytte nyopprettede mapper til en arkivdel som inneholder en aktiv arkivperiode.
	*/
	void testaddMappeTilNyArkivdel(){
		def (ark, del, reg) = createStructure()
		println "ark: ${ark}, del ${del}, reg: ${reg}"
		def mappeService = new MappeService()
		mappeService.commonService = new CommonService()
		def params = [ mappeid: "2010/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id]

		def (mappe, success) = mappeService.save(params)
		assertTrue "save failed", success
		assertEquals 1, Basismappe.list().size()

		del = Arkivdel.get(del.id)

		assertEquals(1, del.referansemappe.size())
	}	

	/**
	*En arkivdel som inneholder en overlappingsperiode, skal være sperret for tilføyelse av nyopprettede mapper. Men eksisterende mapper i en overlappingsperiode skal være åpne for nye registreringer.
	*/
	void testaddMappeTilArkivelOverlapp(){
		def (ark, del, reg) = createStructure()
		println "ark: ${ark}, del ${del}, reg: ${reg}"
		del.periodeStatus = "Overlappingsperiode"
		saveOrFail del
		def mappeService = new MappeService()
		mappeService.commonService = new CommonService()
		def params = [ mappeid: "2010/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id]

		def (mappe, success) = mappeService.save(params)
		assertFalse "save succeeded", success
		assertEquals 0, Basismappe.list().size()


	}

	/**
	*	Dersom en ny registrering føyes til en mappe som tilhører en arkivdel i overlappingsperiode, skal mappen automatisk overføres til arkivdelens arvtaker.
	*/
	void testaddRegToMappeInOverlapp(){
		def (ark, del, reg) = createStructure()
		def mappeService = new MappeService()
		mappeService.commonService = new CommonService()
    def params = [ mappeid: "2010/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id]

    def (mappe, success) = mappeService.save(params)
		
		def del2  = new Arkivdel(systemID: "5", tittel: "tittel", arkivdelstatus: "Opprettet", dokumentmedium: "text/html", opprettetav:"deg", opprettetdato: new Date(), referanseforelder: ark, referanseforløper: del)

		saveOrFail del2

		del.referansearvtaker = del2
		del.save()

		params = [registreringstype: "reg", opprettetdato: new Date(), opprettetav: "dill", arkivertdato: new Date(), arkivertav: "dall", referanseforelderBasismappe: mappe]

		def registreringService = new RegistreringService()
		registreringService.commonService = new CommonService()
		registreringService.registrer(params)

		del = Arkivdel.get(del.id)
    assertEquals(1, del.referansemappe.size())

		del.periodeStatus = "Overlappingsperiode"
		saveOrFail del
		
		registreringService.registrer(params)
		
		del = Arkivdel.get(del.id)
    assertEquals(0, del.referansemappe.size())
	}


	/**
	*	En arkivdel som inneholder en avsluttet arkivperiode, skal være sperret for tilføyelse av nye mapper. Alle mapper skal være lukket, slik at heller ingen registreringer og dokumenter kan føyes til.
	*/
	void testmapperIAvsluttetArkivperiode(){
		def (ark, del, reg) = createStructure()
    println "ark: ${ark}, del ${del}, reg: ${reg}"
    del.periodeStatus = "Avsluttet periode"
    saveOrFail del
    def mappeService = new MappeService()
    mappeService.commonService = new CommonService()
    def params = [ mappeid: "2010/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id]

    def (mappe, success) = mappeService.save(params)
    assertFalse "save succeeded", success
    assertEquals 0, Basismappe.list().size()

	}


	/**
	* Det skal være mulig å få en oversikt over mapper som fremdeles er åpne i en overlappingsperiode.
	*/
	void testseOverlappMapper(){
		def (ark, del, reg) = createStructure()

		def mappeService = new MappeService()
    mappeService.commonService = new CommonService()
    def params = [ mappeid: "2010/00001", mappetype: "dill", tittel:"mappe", offentligtittel: "mappe", beskrivelse:"mappe", dokumentmedium:"papyrus", opprettetdato: new Date(), opprettetav: "meg", referansearkivdel: del, "referansearkivdel.id": del.id]

    mappeService.save(params)

		params.mappeid = "2010/00002"
		def (mappe)= mappeService.save(params)
	
		def arkivdelService = new ArkivdelService()

		def res = arkivdelService.findOpenMappe(del)
		
		assertEquals 2, res.size() 

		mappe.avsluttetdato = new Date()
		saveOrFail mappe
		
		//del = Arkivdel.get(del.id)	
		res = arkivdelService.findOpenMappe(del)
		assertEquals 1, res.size()
	}

	/**
	*	Det skal være mulig å overføre åpne mapper fra en arkivdel i en overlappingsperiode til arkivdelens arvtaker.
	*/
/*	void testoverføreMapperOverlapping(){
		//arkivdel kan endres
		//skal testes i funksjonstester 
	}*/

	/**
	*Dersom dokumentene i en arkivdel er ikke-elektroniske (fysiske), skal det også være mulig å registrere oppbevaringssted.
	*/
/*	void testrefOppbevaringsted(){
		//skal testes i funksjonstester	
	}*/


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
