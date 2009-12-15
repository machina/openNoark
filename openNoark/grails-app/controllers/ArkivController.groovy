class ArkivController {

    def index = {redirect(action:list,params:params)}
		
		def create = {
			
		}

	def save = {
			fixParent(params)
			def arkiv = new Arkiv(params)
			arkiv.arkivstatus = "Opprettet"
			arkiv.systemID = UUID.randomUUID().toString()
			stripParent(params, arkiv)	
			if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
				println params
				println arkiv.arkivstatus 
				println arkiv.forelder
				[arkiv: arkiv]

			} else {
					render(view: "create", model: [errors: arkiv.errors])

			}
	}

	def list = {
		println Arkiv.list()
		[arkiver: Arkiv.list()]
	}

	def show = {
		return [arkiv: Arkiv.get(params.id)]
	}

	def update = { UpdateArkivCommand updateCommand ->
		switch(request.method){
			case 'GET':
				return [arkiv: Arkiv.get(params.id)]	
				break
			case 'POST':
				def arkiv = Arkiv.get(params.id)
				if(arkiv.opprettetdato != updateCommand.opprettetdato){
						arkiv.errors.rejectValue "opprettetdato", "USER_ERROR",  "Kan ikke endre dato for opprettelse av arkiv."
						return [errors: arkiv.errors, arkiv: arkiv]
				}
				println arkiv.avsluttetdato
				println updateCommand.avsluttetdato
				if(arkiv.avsluttetdato != null && updateCommand.avsluttetdato == null){
						arkiv.errors.rejectValue "avsluttetdato", "USER_ERROR",  "Kan ikke fjerne avsluttetdato."
						return [errors: arkiv.errors, arkiv: arkiv]
				} else if(updateCommand.avsluttetdato == null){
					params.avsluttetdato = null
				}
				stripParent(params, arkiv)
				arkiv.properties = params
				if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
					render(view: "show", model: [arkiv: arkiv])
    	  } else {
					render(view: "update", model: [errors: arkiv.errors, arkiv: arkiv])
				}
				break
		}
	}

	def stripParent(params, arkiv) {
		if(!params.forelder || params.forelder == "null") {
        println "nulling parent"
				params.forelder = null
        arkiv.forelder = null
      } else if(params.forelder instanceof String){
        arkiv.forelder = Arkiv.get(Integer.parseInt(params.forelder))
      }
	}
	def fixParent(params){
		if(!params.forelder || params.forelder == "null") {
			params.forelder = null
		} else if(params.forelder instanceof String){
			println params.forelder
			params.forelder = Arkiv.get(Integer.parseInt(params.forelder))
		} else {
			params.forelder.merge()
		}
	}
}

class UpdateArkivCommand {
	Date opprettetdato
	Date avsluttetdato
}
