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

class KassasjonServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
				loginTestUser()
    }

    protected void tearDown() {
        super.tearDown()
    }

	
    void testOversiktIngenKassason() {
			def ark, del, reg = createStructure()
			
			KassasjonService service = new KassasjonService()
			def list = service.oversikt([fra: new Date(), til: new Date(), disposalDecision: "Bevares"])
			assertEquals 0, list?.size()
    }

		void testOversikt(){
			def ark, del, reg = createStructure()
			DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")

			if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }

			
			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Bevares", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
			if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			desc.preservationAndDisposal = bev
			desc.save()
			
			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Bevares"]

			KassasjonService service = new KassasjonService()

			def list = service.oversikt(co)
			assertEquals 1, list?.size()

			def dok = list[0]
			assertTrue dok instanceof DocumentDescription
		}

		void testOversikt2i1(){
			def ark, del, reg = createStructure()
			DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")

			if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }

			DocumentDescription desc2 = new DocumentDescription(systemID: "21412", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")
      
      if(!desc2.save()){
        println desc2.errors
        fail "unable to save desc"
      }

			
			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Bevares", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc, desc2])
			if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			desc.preservationAndDisposal = bev
			desc.save()
			
			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Bevares"]

			KassasjonService service = new KassasjonService()

			def list = service.oversikt(co)
			assertEquals 2, list?.size()

			def dok = list[0]
			assertTrue dok instanceof DocumentDescription
		}

		void testOversikt2i2(){
			def ark, del, reg = createStructure()
			DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")

			if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }

			DocumentDescription desc2 = new DocumentDescription(systemID: "21412", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")
      
      if(!desc2.save()){
        println desc2.errors
        fail "unable to save desc"
      }

			
			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Bevares", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
			if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			PreservationAndDisposal bev2 = new PreservationAndDisposal(disposalDecision: "Bevares", preservationTime: 3, disposalDate: new Date() + 2, documentDescription: [desc])
      if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }		

	
			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Bevares"]

			KassasjonService service = new KassasjonService()

			def list = service.oversikt(co)
			assertEquals 1, list?.size()

			def dok = list[0]
			assertTrue dok instanceof DocumentDescription
		}


		void testKasser() {
			//subject.metaClass.'isPermitted' = {true}
			def (ark, del, reg) = createStructure()
			
      DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")
			saveOrFail desc
			
			DocumentObject obj = new DocumentObject(systemID: "AASA", versionNumber:"1", variantFormat:"1", format:"1", formatDetails:"2", createdDate: new Date(), createdBy:"dall", documentDescription:desc )
			saveOrFail(obj)
			
			desc.addToDocumentObject(obj)

			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Kasseres", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
      if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Kasseres"]

      KassasjonService service = new KassasjonService()
			service.archiveService = new ArchiveService()
      def list = service.oversikt(co)
      assertEquals 1, list?.size()
			
			assertEquals 1, DocumentObject.list().size()
			println "kasserer ${desc}"
			//org.apache.shiro.SecurityUtils.metaClass.'static'.getSubject = { return [principal : "testuser"] }
			service.kasser(desc)

			assertEquals 0, DocumentObject.list().size()
		}

		/**
		*5.10.35 
		* For hvert dokument som blir kassert, skal det på documentDescriptionsnivå logges dato for kassasjon og hvem som utførte kassasjonen.
		*/
		void testKasserLogging() {
			//subject.metaClass.'isPermitted' = {true}
			def (ark, del, reg) = createStructure()
			
      DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")
			saveOrFail desc
			
			DocumentObject obj = new DocumentObject(systemID: "AASA", versionNumber:"1", variantFormat:"1", format:"1", formatDetails:"2", createdDate: new Date(), createdBy:"dall", documentDescription:desc )
			saveOrFail(obj)
			
			desc.addToDocumentObject(obj)

			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Kasseres", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
      if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Kasseres"]

      KassasjonService service = new KassasjonService()
			service.archiveService = new ArchiveService()
      def list = service.oversikt(co)
      assertEquals 1, list?.size()
			
			assertEquals 1, DocumentObject.list().size()
			service.kasser(desc)
			assertEquals 0, DocumentObject.list().size()

			//reload for good messure
			desc = DocumentDescription.get(desc.id)
			assertNotNull desc.disposalDate
			assertEquals "testuser", desc.disposedBy
		}

		void testKasserTilMappe() {
			//subject.metaClass.'isPermitted' = {true}
			def (ark, del, reg) = createStructure()
			
      DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")
			saveOrFail desc
			
			DocumentObject obj = new DocumentObject(systemID: "AASA", versionNumber:"1", variantFormat:"1", format:"1", formatDetails:"2", createdDate: new Date(), createdBy:"dall", documentDescription:desc )
			saveOrFail(obj)
			
			DocumentLink dl = new DocumentLink(documentNumber:"2", linkedBy:"3", linkedDate: new Date(), linkedRecordAs: "dsfs", referenceRecord: reg, documentDescription: desc)
			saveOrFail(dl)
			desc.addToRecords(dl)
			desc.addToDocumentObject(obj)
			desc.save()

			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Kasseres", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
      if(!bev.save()){
        println bev.errors
        fail "unable to save bev"
      }

			desc.preservationAndDisposal = bev
			desc.save()
	
			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Kasseres"]

      KassasjonService service = new KassasjonService()
			service.archiveService = new ArchiveService()
      def list = service.oversikt(co)
      assertEquals 1, list?.size()

			
		
			assertEquals 1, SimplifiedRecord.list().size()
			assertEquals 1, DocumentDescription.list().size()
			assertEquals 1, DocumentObject.list().size()
			
			service.kasser(desc, true)
			
			assertEquals 0, DocumentObject.list().size()
			assertEquals 0, DocumentDescription.list().size()
			assertEquals 0, SimplifiedRecord.list().size()
		}

		void testdill() {
			DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")
      saveOrFail desc

      DocumentObject obj = new DocumentObject(systemID: "AASA", versionNumber:"1", variantFormat:"1", format:"1", formatDetails:"2", createdDate: new Date(), createdBy:"dall", documentDescription:desc )
      saveOrFail(obj)

      desc.addToDocumentObject(obj)
			desc.save()			

			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Kasseres", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
			saveOrFail(bev)
			bev.removeFromDocumentDescription(desc)
			obj.delete()
			desc.delete()


			DocumentObject.list()
		}

		void testKasserUnauthorized() {
			loginTestUser({false})
			def (ark, del, reg) = createStructure()
      DocumentDescription desc = new DocumentDescription(systemID: "2141", documentType: "type", documentStatus: "status", title: "title", description:"desc", author: "author", createdDate: new Date(), createdBy: "dill", documentMedium: "pysical/papyrus", storageLocation: "her og der")

      if(!desc.save()){
        println desc.errors
        fail "unable to save desc"
      }
			
			DocumentObject obj = new DocumentObject(systemID: "AASA", versionNumber:"1", variantFormat:"1", format:"1", formatDetails:"2", createdDate: new Date(), createdBy:"dall", documentDescription:desc )
			saveOrFail(obj)
			
			desc.addToDocumentObject(obj)

			PreservationAndDisposal bev = new PreservationAndDisposal(disposalDecision: "Kasseres", preservationTime: 1, disposalDate: new Date(), documentDescription: [desc])
			saveOrFail(bev)

			def co = [fra: new Date() - 2, til: new Date() + 2, disposalDecision: "Kasseres"]
			
      KassasjonService service = new KassasjonService()
			service.archiveService = new ArchiveService()
      def list = service.oversikt(co)
      assertEquals 1, list?.size()
			
			assertEquals 1, DocumentObject.list().size()
			println "kasserer ${desc}"
			//org.apache.shiro.SecurityUtils.metaClass.'static'.getSubject = { return [principal : "testuser"] }
			try{
				service.kasser(desc)
				fail "kassering var vellykket når den skulle exceptet"
			} catch(Exception ex){
				//all is well
			}

			assertEquals 1, DocumentObject.list().size()
		}




		void testFilter() {
			
			KassasjonService service = new KassasjonService()

			
			BasicFile m1 = new BasicFile(id: 1, systemID: "1")
			def reg1 = new SimplifiedRecord(id:5, parentFile: m1)
			def dok1 = new DocumentDescription(records: [new DocumentLink(referenceRecord: reg1)])
			assertEquals "1", dok1.records.toArray()[0].referenceRecord.parentFile.systemID

			BasicFile m2 = new BasicFile(id: 2, systemID: "2")
			def reg2 = new SimplifiedRecord(id:5, parentFile: m2)
			def dok2 = new DocumentDescription(records: [new DocumentLink(referenceRecord: reg2)])
			assertEquals "2", dok2.records.toArray()[0].referenceRecord.parentFile.systemID

			def list = [dok1, dok2]

			def retval = service.filter(list, "mappe(systemID: \"1\")")
			
			assertEquals 1, retval.size()

			assertEquals "1", retval.get(0).records.toArray()[0].referenceRecord.parentFile.systemID

			retval = service.filter(list, "mappe(systemID: \"2\")")

      assertEquals 1, retval.size()

      assertEquals "2", retval.get(0).records.toArray()[0].referenceRecord.parentFile.systemID
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
