import grails.converters.*
class ArkivdelController {

    def index = { redirect(action:list,params:params)}

		def create = {
			[arkiver: Arkiv.list()]
		}

		def save = {
			def arkivdel = new Arkivdel(params)
			arkivdel.arkivdelstatus = "Opprettet"
			arkivdel.systemID = UUID.randomUUID().toString()
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
			withFormat {
	      html {
  	      return [arkivdeler: Arkivdel.findAll()]
        }
        xml {
    	    render Arkivdel.findAll() as XML
        }
        json {
       		 println Arkivdel.findAll() as JSON
           render Arkivdel.findAll() as JSON
        }
     }

			return [arkivdeler: Arkivdel.findAll()]
		}
	
}
