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

class ArkivdelPeriodiseringTests extends GrailsUnitTestCase {
  protected void setUp() {
  	super.setUp()
		loginTestUser()
  }

  protected void tearDown() {
		super.tearDown()
  }

	/*
	*	Det skal være mulig å knytte nyopprettede mapper til en arkivdel som 
	* 	inneholder en aktiv arkivperiode.
	*/
	void testaddMappeTilNySeries(){
		def (ark, del, reg) = createStructure()
		println "ark: ${ark}, del ${del}, reg: ${reg}"
		//def mappeService = new MappeService()
		def mappeService = new FileService()
		mappeService.commonService = new CommonService()
		mappeService.mappeIdGeneratorService = new MappeIdGeneratorService()
		def params = [ fileID: "2010/00001", fileType: "BasicFile", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id]

		def (mappe, success) = mappeService.save(params)
		println mappe.errors
		assertTrue "save failed", success
		assertEquals 1, BasicFile.list().size()

		del = Series.get(del.id)

		assertEquals(1, del.file.size())
	}	

	/**
	*	En arkivdel som inneholder en overlappingsperiode, skal være 
	*	sperret for tilføyelse av nyopprettede mapper. Men eksisterende 
	*	mapper i en overlappingsperiode skal være åpne for nye 
	*	registreringer.
	*/
	void testaddMappeTilFondselOverlapp(){
		def (ark, del, reg) = createStructure()
		println "ark: ${ark}, del ${del}, reg: ${reg}"
		del.periodStatus = "Overlappingsperiode"
		saveOrFail del
		def mappeService = new FileService()
		mappeService.commonService = new CommonService()
		mappeService.mappeIdGeneratorService = new MappeIdGeneratorService()

		def params = [ fileID: "2010/00001", fileType: "BasicFile", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id]

		def (mappe, success) = mappeService.save(params)
		assertFalse "save succeeded", success
		assertEquals 0, BasicFile.list().size()


	}

	/**
	*	Dersom en ny registrering føyes til en mappe som tilhører en 
	*	arkivdel i overlappingsperiode, skal mappen automatisk overføres
	*	til arkivdelens arvtaker.
	*/
	void testaddRegToMappeInOverlapp(){
		def (ark, del, reg) = createStructure()
		def mappeService = new FileService()
		mappeService.commonService = new CommonService()
		mappeService.mappeIdGeneratorService = new MappeIdGeneratorService()

    def params = [ fileID: "2010/00001", fileType: "BasicFile", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id]

    def (mappe, success) = mappeService.save(params)
		
		def del2  = new Series(systemID: "5", title: "title", recordSectionStatus: "Opprettet", documentMedium: "text/html", createdBy:"deg", createdDate: new Date(), parent: ark, precursor: del)

		saveOrFail del2

		del.successor = del2
		del.save()

		params = [recordType: "Forenkletregistrering", createdDate: new Date(), createdBy: "dill", archivedDate: new Date(), archivedBy: "dall", parentFile: mappe]

		def registreringService = new RegistreringService()
		registreringService.commonService = new CommonService()
		registreringService.registrer(params)

		del = Series.get(del.id)
    assertEquals(1, del.file.size())

		del.periodStatus = "Overlappingsperiode"
		saveOrFail del
		
		registreringService.registrer(params)
		
		del = Series.get(del.id)
    assertEquals(0, del.file.size())
	}


	/**
	*	En arkivdel som inneholder en avsluttet arkivperiode, skal være 
	*	sperret for tilføyelse av nye mapper. Alle mapper skal være 
	*	lukket, slik at heller ingen registreringer og dokumenter kan 
	*	føyes til.
	*/
	void testmapperIAvsluttetFondsperiode(){
		def (ark, del, reg) = createStructure()
    println "ark: ${ark}, del ${del}, reg: ${reg}"
    del.periodStatus = "Avsluttet periode"
    saveOrFail del
    def mappeService = new FileService()
    mappeService.commonService = new CommonService()
		mappeService.mappeIdGeneratorService = new MappeIdGeneratorService()

    def params = [ fileID: "2010/00001", fileType: "BasicFile", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id]

    def (mappe, success) = mappeService.save(params)
    assertFalse "save succeeded", success
    assertEquals 0, BasicFile.list().size()

	}


	/**
	* Det skal være mulig å få en oversikt over mapper som fremdeles er åpne 
	* i en overlappingsperiode.
	*/
	void testseOverlappMapper(){
		def (ark, del, reg) = createStructure()

		def mappeService = new FileService()
    mappeService.commonService = new CommonService()
		mappeService.mappeIdGeneratorService = new MappeIdGeneratorService()

    def params = [ fileID: "2010/00001", fileType: "BasicFile", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id]

    mappeService.save(params)

		params.fileID = "2010/00002"
		def (mappe)= mappeService.save(params)
	
		def arkivdelService = new SeriesService()

		def res = arkivdelService.findOpenMappe(del)
		
		assertEquals 2, res.size() 

		mappe.finalisedDate = new Date()
		saveOrFail mappe
		
		//del = Series.get(del.id)	
		res = arkivdelService.findOpenMappe(del)
		assertEquals 1, res.size()
	}

	/**
	* Det skal være mulig å overføre åpne mapper fra en arkivdel i en 
	* overlappingsperiode til arkivdelens arvtaker.
	*/
/*	void testoverføreMapperOverlapping(){
		//arkivdel kan endres
		//skal testes i funksjonstester 
	}*/

	/**
	* Dersom dokumentene i en arkivdel er ikke-elektroniske (fysiske), skal 
	* det også være mulig å registrere storageLocation.
	*/
/*	void testrefOppbevaringsted(){
		//skal testes i funksjonstester	
	}*/


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
