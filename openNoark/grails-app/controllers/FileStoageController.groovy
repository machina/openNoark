import no.friark.ds.*

/**
* Kontroller for å håndtere det elektroniske arkivet.
*/
class FileStoageController {
	def archiveService

	/**
  * Arkiverer den inkommende strømmen og knytter den til Dokumentobjektet med den innkommende id.
  */
	def save = {
		println(params)
		println "archiving"
		archiveService.archive(params.id, request.inputStream)
	}

}
