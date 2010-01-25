import no.friark.ds.*
class AdminController {
		def grailsApplication

    def index = { }


		def initialise = {
			grailsApplication.initialise()
			render "initialized"
		}

		def refresh = {
      grailsApplication.refresh()
      render "refreshed"
    }


		def rebuild = {
      grailsApplication.rebuild()
      render "rebuilt"
    }

}
