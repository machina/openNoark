class ArkivdelController {

    def index = { redirect(action:list,params:params)}

		def create = {
			[arkiver: Arkiv.list()]
		}

		def save = {
			def arkivdel = new Arkivdel(params)
			arkivdel.arkivdelstatus = "Opprettet"
			arkivdel.systemid = UUID.randomUUID().toString()
			println params
			if(!params.referanseforelder || params.referanseforelder == "null") {
				print "nulling"
				arkivdel.referanseforelder = null
			} else {
				arkivdel.referanseforelder = Arkiv.get(params.referanseforelder)
			}

			if(!arkivdel.save()){
				render(view: "create", model: [errors: arkivdel.errors])
			}
			[arkivdel: arkivdel]
		}

		def list = {
			println Arkivdel.list()
			[arkivdeler: Arkivdel.findAll()]
		}
	
}
