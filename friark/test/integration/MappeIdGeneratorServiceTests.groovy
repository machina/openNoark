import grails.test.*
import org.friark.ds.*
import java.text.DecimalFormat

class MappeIdGeneratorServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }


		void testMappeIdGenerator() {
			def service = new MappeIdGeneratorService();
			def gen = service.mappeIdGenerator
			assertEquals "10/00001", gen()
			
		}

		void testMappeIdGenerator2() {
			def (ark,del) = createStructure()
			
			CaseFile m = new CaseFile(fileID: "10/00001", fileType: "dill", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id, administrativeUnit: "a", caseDate: new Date(), caseStatus: "2", systemID: "13", caseResponsible: "somebody else")

			saveOrFail(m)
			def service = new MappeIdGeneratorService();
			def gen = service.mappeIdGenerator
			assertEquals "10/00002", gen()
			
		}

		void testSeqGenerator() {
			def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "1", gen()
		}

		void testSeqGenerator2() {
      def (ark,del) = createStructure()

      CaseFile m = new CaseFile(fileID: "1", fileType: "dill", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id, administrativeUnit: "a", caseDate: new Date(), caseStatus: "2", systemID: "13", caseResponsible: "somebody else")

      saveOrFail(m)
      def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "2", gen()

    }


	void testSeqGenerator3() {
      def (ark,del) = createStructure()

      CaseFile m = new CaseFile(fileID: "5", fileType: "dill", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id, administrativeUnit: "a", caseDate: new Date(), caseStatus: "2", systemID: "13", caseResponsible: "somebody else")

      saveOrFail(m)
			m = new CaseFile(fileID: "11", fileType: "dill", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id, administrativeUnit: "a", caseDate: new Date(), caseStatus: "2", systemID: "14", caseResponsible: "somebody else")

      saveOrFail(m)
			m = new CaseFile(fileID: "10", fileType: "dill", title:"mappe", officialTitle: "mappe", description:"mappe", documentMedium:"papyrus", createdDate: new Date(), createdBy: "meg", recordSection: del, "recordSection.id": del.id, administrativeUnit: "a", caseDate: new Date(), caseStatus: "2", systemID: "15", caseResponsible: "somebody else")
			saveOrFail(m)
      def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "12", gen()

   }


	def createStructure(){
    Fonds ark = new Fonds(systemID: "1", title: "title", fondsStatus: "Opprettet", createdDate: new Date(), createdBy: "meg")
    saveOrFail(ark)
    assertNotNull Fonds.get(ark.id)

    Series del = new Series(systemID: "2", title: "title", recordSectionStatus: "Opprettet", documentMedium: "text/html", createdBy:"deg", createdDate: new Date(), parent: ark )
    saveOrFail(del)
		return [ark,del]
	}

}
