import grails.test.*
import org.friark.ds.*
import java.text.DecimalFormat
import org.friark.services.MappeIdGeneratorService

class MappeIdGeneratorServiceTests extends GrailsUnitTestCase {
   private Date now;

    protected void setUp() {
      now = new Date();
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

   void testMappeIdGenerator() {
		def service = new MappeIdGeneratorService();
		def gen = service.mappeIdGenerator
      def expectedId = "${now.format('yy')}/00001"

		assertEquals("FileIdGenerator actual id wrong", expectedId, gen() )
	}

	void testMappeIdGenerator2() {
		def (ark,del) = createStructure()
      CaseFile m = createCaseFile( del, "${now.format('yy')}/00001", "13"  )
		saveOrFail(m)

		def service = new MappeIdGeneratorService();
		def gen = service.mappeIdGenerator
      def expectedId = "${now.format('yy')}/00002"
		assertEquals("FileIdGenerator actual id wrong", expectedId, gen() )
	}

   void testSeqGenerator() {
	   def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "1", gen()
	}

	void testSeqGenerator2() {
      def (ark,del) = createStructure()
      CaseFile m = createCaseFile( del, "1", "13" )
      saveOrFail(m)

      def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "2", gen()
    }

   void testSeqGenerator3() {
      def (ark,del) = createStructure()
      CaseFile m = createCaseFile( del, "5", "13" )
      saveOrFail(m)

      m = createCaseFile( del, "11", "14" )
      saveOrFail(m)

      m = createCaseFile( del, "10", "15" )
      saveOrFail(m)

      def service = new MappeIdGeneratorService();
      def gen = service.seqGenerator
      assertEquals "12", gen()
      }
   
   def createCaseFile( Series del, String fileId, String systemId ){
		CaseFile m = new CaseFile(
                     fileID: fileId, 
                     fileType: "dill", 
                     title:"mappe", 
                     officialTitle: "mappe", 
                     description:"mappe", 
                     documentMedium:"papyrus", 
                     createdDate: new Date(), 
                     createdBy: "meg", 
                     recordSection: del, 
                     "recordSection.id": del.id, 
                     administrativeUnit: "a", 
                     caseDate: new Date(), 
                     caseStatus: "2", 
                     systemID: systemId, 
                     caseResponsible: "somebody else")

      return m
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
