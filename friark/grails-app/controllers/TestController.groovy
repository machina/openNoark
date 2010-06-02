import no.friark.ds.*
class TestController {

    def index = { }

		def clearAll = {
			def delete = { it.delete() }
			CaseResponsibility.list().collect delete
			Client.list().collect delete
			PreservationAndDisposal.list().collect delete
			DocumentLink.list().collect delete
			DocumentObject.list().collect delete
			DocumentDescription.list().collect delete
			SimplifiedRecord.list().collect delete
			BasicFile.list().collect delete
			Series.list().collect delete
			Fonds.list().collect delete
			Klass.list().collect delete

      ClassificationSystem.list().collect delete
			render "<html><body>done</body></html>"
		}
}
