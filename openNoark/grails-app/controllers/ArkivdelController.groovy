import grails.converters.*
import no.friark.ds.*
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
	
		def show = {
			return [arkivdel: Arkivdel.get(params.id)]
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


	def update = { UpdateArkivdelCommand updateCommand ->

		switch(request.method){
      case 'GET':
        return [arkivdel: Arkivdel.get(params.id)]
        break
      case 'POST':
				def arkivdel = Arkivdel.get(params.id)
				if(updateCommand.avsluttetdato == null){
          params.avsluttetdato = null
        }
				arkivdel.properties = params
        if(!arkivdel.hasErrors() && arkivdel.validate() && arkivdel.save()){
          render(view: "show", model: [arkivdel: arkivdel])
        } else {
          render(view: "update", model: [errors: arkivdel.errors, arkivdel: arkivdel])
        }
        break
    }

	}
	
	def håndterOppbevaringsted = {
		return [arkivdel: Arkivdel.get(params.id)]
	}

	def fjernOppbevaringsted = {
		def arkivdel = Arkivdel.get(params.arkivdelid)
		arkivdel.oppbevaringssted.remove  params.sted
		if(arkivdel.save()){
			println arkivdel.errors
			render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel]
		}else{
			render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel, errors: arkivdel.errors]
			println arkivdel.errors
		}
	}

	def leggTilOppbevaringsted = {
		def arkivdel = Arkivdel.get(params.arkivdelid)
    arkivdel.oppbevaringssted.add params.sted
		if(arkivdel.save()){
      println arkivdel.errors
      render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel]
    }else{
      render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel, errors: arkivdel.errors]
      println arkivdel.errors
    }


  }

}
class UpdateArkivdelCommand {
  Date opprettetdato
  Date avsluttetdato
}
