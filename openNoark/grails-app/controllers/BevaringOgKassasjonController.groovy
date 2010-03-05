/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/


import no.friark.ds.*

/**
* Operasjoner vedrørende bevaring og kassasjon.
*
* @author Kent Inge Fagerland Simonsen
*/
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

	/**
  * Gir en oversik over bevarig, kassasjon eller "vurderes senere" vedtak basert på parameterene Date fra, Date til, String kassasjonvedtak og String filter
  */
	def oversikt = { KassasjonCO co ->
		return _oversikt(co)
	}

  /**
  * Ved HTTP GET, gis en oversikt over kassasjonsvedtak vedtak basert på parameterene Date fra, Date til og String filter.
  * Ved HTTP POST utføres kassasjoner på valgte dokumenter, Poster som kasseres idetifiseres med at paramentere prefixes med "kasser_" og suffixes med
  * id'en til Dokumentbeskrivelsen som skal kasseren. Verdien på parameterene må være "on".
  */
	def kasser = { KassasjonCO co ->
		if(request.method == "GET"){
			co.kassasjonsvedtak = "Kasseres"
			return _oversikt(co)
		} else if(request.method == "POST"){
			def kasseringsListe = []
			params.each{key, value ->
				if(key.startsWith("kasser_") && value == "on"){
					kasseringsListe << Dokumentbeskrivelse.get((key - "kasser_") as Long)
				}
			}
			kassasjonService.kasser kasseringsListe
		}
	}

	private def _oversikt(KassasjonCO co){
		if(co.fra){
			def liste = kassasjonService.oversikt(co)
			liste = kassasjonService.filter( liste, co.filter)
			return ['liste': liste, fra: co.fra, til: co.til, vedtak: co.kassasjonsvedtak, filter: co.filter ? co.filter :"", klasser: kassasjonService.klasserIDokliste(liste), mapper: kassasjonService.mapperIDokliste(liste), arkivdeler: kassasjonService.arkivdelerIDokliste(liste)]
		}
		return []
	}
	


}

class KassasjonCO {
	Date fra
	Date til
	String kassasjonsvedtak
	String filter
}
