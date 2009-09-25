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

	def update = {
		switch(request.method){
			case 'GET':
				return [arkiv: Arkiv.get(params.id)]	
				break
			case 'POST':
				def arkiv = Arkiv.get(params.id)
				stripParent(params, arkiv)
				arkiv.properties = params
				println "arkiv.forelder: ${arkiv.forelder}"
				println "arkiv.subArkiv: ${arkiv.subArkiv}"
				//println "arkiv.referansebarnArkivdel ${arkiv.referansebarnArkivdel} ${arkiv.referansebarnArkivdel?.size()}"
		    //println "arkiv.referansebarnArkiv ${arkiv.referansebarnArkiv} ${arkiv.referansebarnArkiv?.size()}"
				//stripParent(params, arkiv)
				println "arkiv.forelder: ${arkiv.forelder}"
				println "params.forelder: ${params.forelder}"
				if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
					render(view: "update_reciept", model: [arkiv: arkiv])
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
