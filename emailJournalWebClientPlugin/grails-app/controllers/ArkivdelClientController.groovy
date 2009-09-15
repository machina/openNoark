class ArkivdelClientController {
		def archiveService

    def index = { 
			
			[arkiv: Arkiv.findAll(), del: params.id ? Arkivdel.get(params.id) : null]
		}

		def dl = {
			render new String(archiveService.retrive(params.id))
		}
}
