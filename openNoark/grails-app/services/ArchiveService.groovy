class ArchiveService {
	def grailsApplication

	def archive(docId, file){
		def path = "${grailsApplication.config.archivePath}/${docId}"
		println "archiving to: ${path}"
		new File(path).mkdir()
		path = "${path}/data"
		def data = file.text
		
		new File(path).append(data.decodeBase64())
	}


	def retrive(docId){
		def path = "${grailsApplication.config.archivePath}/${docId}"
		def bytes
		new File(path).eachFile{
			bytes = it.bytes
		}
		return bytes
	}
}
