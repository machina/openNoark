class ArkivController {

    def index = { }
		
		def create = {
			
		}

	def save = {
			def arkiv = new Arkiv(params)
			arkiv.arkivstatus = "Opprettet"
			arkiv.systemid = UUID.randomUUID().toString()
			stripParent(params, arkiv)	
			if(!arkiv.save()){
				render(view: "create", model: [errors: arkiv.errors])
			}
			println params
			println arkiv.arkivstatus 
			println arkiv.forelder
			[arkiv: arkiv]
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
				def arkiv = Arkiv.get(params.id as Long)
				arkiv.properties = params
				println "arkiv.forelder: ${arkiv.forelder}"
				println "arkiv.subArkiv: ${arkiv.subArkiv}"
				println "arkiv.referansebarnArkivdel ${arkiv.referansebarnArkivdel} ${arkiv.referansebarnArkivdel?.size()}"
		    println "arkiv.referansebarnArkiv ${arkiv.referansebarnArkiv} ${arkiv.referansebarnArkiv?.size()}"
				stripParent(params, arkiv)
				if(!arkiv.save()){
    	   	render(view: "update", model: [errors: arkiv.errors, arkiv: arkiv])
      	} else {
					render(view: "update_reciept", model: [arkiv: arkiv])
				}
				break
	
		}
	}

	def stripParent(params, arkiv) {
		if(!params.forelder || params.forelder == "null") {
        println "nulling parent"
        arkiv.forelder = null
      } else {
        arkiv.forelder = Arkiv.get(params.forelder)
      }
	}
}
