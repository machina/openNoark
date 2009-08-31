class FileStoageController {
	def archiveService

	def save = {
		println(params)
		println "archiving"
		archiveService.archive(params.id, request.inputStream)
	}

}
