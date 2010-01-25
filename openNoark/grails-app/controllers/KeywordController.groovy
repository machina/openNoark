import no.friark.ds.*
class KeywordController {

    def index = { }

		def edit = {
			[base: Base.findBySystemID(params.id)]	
		}

		def update = {
			def base = Base.findBySystemID(params.systemID)
			base.nøkkelord << params.new
			base.save()
			render(view: "edit", model: [base: base])
		}

		def delete = {
			def base = Base.findBySystemID(params.systemID)
			base.nøkkelord -= params.ord
			base.save()
			render(view: "edit", model: [base: base])
		}
}
