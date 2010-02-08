
import no.friark.ds.*
class BevaringOgKassasjonController {
    def kassasjonService
		def commonService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ bevaringOgKassasjonInstanceList: BevaringOgKassasjon.list( params ), bevaringOgKassasjonInstanceTotal: BevaringOgKassasjon.count() ]
    }

    def show = {
        def bevaringOgKassasjonInstance = BevaringOgKassasjon.get( params.id )

        if(!bevaringOgKassasjonInstance) {
            flash.message = "BevaringOgKassasjon not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ bevaringOgKassasjonInstance : bevaringOgKassasjonInstance ] }
    }

    def delete = {
        def bevaringOgKassasjonInstance = BevaringOgKassasjon.get( params.id )
        if(bevaringOgKassasjonInstance) {
            try {
                bevaringOgKassasjonInstance.delete(flush:true)
                flash.message = "BevaringOgKassasjon ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "BevaringOgKassasjon ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "BevaringOgKassasjon not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def bevaringOgKassasjonInstance = BevaringOgKassasjon.get( params.id )

        if(!bevaringOgKassasjonInstance) {
            flash.message = "BevaringOgKassasjon not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ bevaringOgKassasjonInstance : bevaringOgKassasjonInstance ]
        }
    }

    def update = {
        def bevaringOgKassasjonInstance = BevaringOgKassasjon.get( params.id )
        if(bevaringOgKassasjonInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(bevaringOgKassasjonInstance.version > version) {
                    
                    bevaringOgKassasjonInstance.errors.rejectValue("version", "bevaringOgKassasjon.optimistic.locking.failure", "Another user has updated this BevaringOgKassasjon while you were editing.")
                    render(view:'edit',model:[bevaringOgKassasjonInstance:bevaringOgKassasjonInstance])
                    return
                }
            }
            bevaringOgKassasjonInstance.properties = params
            if(!bevaringOgKassasjonInstance.hasErrors() && bevaringOgKassasjonInstance.save()) {
                flash.message = "BevaringOgKassasjon ${params.id} updated"
                redirect(action:show,id:bevaringOgKassasjonInstance.id)
            }
            else {
                render(view:'edit',model:[bevaringOgKassasjonInstance:bevaringOgKassasjonInstance])
            }
        }
        else {
            flash.message = "BevaringOgKassasjon not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def bevaringOgKassasjonInstance = new BevaringOgKassasjon()
        bevaringOgKassasjonInstance.properties = params
        return ['bevaringOgKassasjonInstance':bevaringOgKassasjonInstance]
    }

    def save = {
        def bevaringOgKassasjonInstance = new BevaringOgKassasjon(params)
        if(!bevaringOgKassasjonInstance.hasErrors() && bevaringOgKassasjonInstance.save()) {
            flash.message = "BevaringOgKassasjon ${bevaringOgKassasjonInstance.id} created"
            redirect(action:show,id:bevaringOgKassasjonInstance.id)
        }
        else {
            render(view:'create',model:[bevaringOgKassasjonInstance:bevaringOgKassasjonInstance])
        }
    }


		def referanser = {
			def bevaringOgKassasjonInstance = BevaringOgKassasjon.get(params.id)
			if(request.method == 'POST'){
				println params
				if( !commonService.isNull(params.dokumentBeskrivelse.id)) bevaringOgKassasjonInstance.addToDokumentBeskrivelse Dokumentbeskrivelse.get(params.dokumentBeskrivelse.id)
				if( !commonService.isNull(params.referanseregistrering.id)) bevaringOgKassasjonInstance.addToRegistrering ForenkletRegistrering.get(params.referanseregistrering.id)
				if( !commonService.isNull(params.arkivdel.id)) bevaringOgKassasjonInstance.addToArkivdel Arkivdel.get(params.arkivdel.id)
				if( !commonService.isNull(params.basismappe.id)){
					 
					 bevaringOgKassasjonInstance.addToMappe Basismappe.get(params.basismappe.id)
				}
				if( !commonService.isNull(params.klasse.id)) bevaringOgKassasjonInstance.addToKlasse Klasse.get(params.klasse.id)
				if(!bevaringOgKassasjonInstance.hasErrors() && bevaringOgKassasjonInstance.save()) {
            flash.message = "Endringer utført"
						//redirect(action:referanser,id: bevaringOgKassasjonInstance.id)
						return [bevaringOgKassasjonInstance: bevaringOgKassasjonInstance]
				} else {
						flash.message = "En feil oppsto: ${bevaringOgKassasjonInstance.errors}"
						return [bevaringOgKassasjonInstance: bevaringOgKassasjonInstance]
				}
			} else {
				return [bevaringOgKassasjonInstance: bevaringOgKassasjonInstance]
			}
		}

	def oversikt = { KassasjonCO co ->
		if(co.fra){
			def liste = kassasjonService.oversikt(co)
			liste = kassasjonService.filter( liste, co.filter)
			return ['liste': liste, fra: co.fra, til: co.til, vedtak: co.kassasjonsvedtak, filter: co.filter ? co.filter :"", klasser: kassasjonService.klasserIDokliste(liste), mapper: kassasjonService.mapperIDokliste(liste), arkivdeler: kassasjonService.arkivdelerIDokliste(liste)]
		}
	}
}

class KassasjonCO {
	Date fra
	Date til
	String kassasjonsvedtak
	String filter
}
