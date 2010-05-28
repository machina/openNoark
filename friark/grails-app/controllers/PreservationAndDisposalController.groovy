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
class PreservationAndDisposalController {
    def kassasjonService
		def commonService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ preservationAndDisposalInstanceList: PreservationAndDisposal.list( params ), preservationAndDisposalInstanceTotal: PreservationAndDisposal.count() ]
    }

    def show = {
        def preservationAndDisposalInstance = PreservationAndDisposal.get( params.id )

        if(!preservationAndDisposalInstance) {
            flash.message = "PreservationAndDisposal not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ preservationAndDisposalInstance : preservationAndDisposalInstance ] }
    }

    def delete = {
        def preservationAndDisposalInstance = PreservationAndDisposal.get( params.id )
        if(preservationAndDisposalInstance) {
            try {
                preservationAndDisposalInstance.delete(flush:true)
                flash.message = "PreservationAndDisposal ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "PreservationAndDisposal ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "PreservationAndDisposal not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def preservationAndDisposalInstance = PreservationAndDisposal.get( params.id )

        if(!preservationAndDisposalInstance) {
            flash.message = "PreservationAndDisposal not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ preservationAndDisposalInstance : preservationAndDisposalInstance ]
        }
    }

    def update = {
        def preservationAndDisposalInstance = PreservationAndDisposal.get( params.id )
        if(preservationAndDisposalInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(preservationAndDisposalInstance.version > version) {
                    
                    preservationAndDisposalInstance.errors.rejectValue("version", "preservationAndDisposal.optimistic.locking.failure", "Another user has updated this PreservationAndDisposal while you were editing.")
                    render(view:'edit',model:[preservationAndDisposalInstance:preservationAndDisposalInstance])
                    return
                }
            }
            preservationAndDisposalInstance.properties = params
            if(!preservationAndDisposalInstance.hasErrors() && preservationAndDisposalInstance.save()) {
                flash.message = "PreservationAndDisposal ${params.id} updated"
                redirect(action:show,id:preservationAndDisposalInstance.id)
            }
            else {
                render(view:'edit',model:[preservationAndDisposalInstance:preservationAndDisposalInstance])
            }
        }
        else {
            flash.message = "PreservationAndDisposal not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def preservationAndDisposalInstance = new PreservationAndDisposal()
        preservationAndDisposalInstance.properties = params
        return ['preservationAndDisposalInstance':preservationAndDisposalInstance]
    }

    def save = {
        def preservationAndDisposalInstance = new PreservationAndDisposal(params)
				if(preservationAndDisposalInstance.file != null && preservationAndDisposalInstance.file.precedent != null && preservationAndDisposalInstance.disposalDecision == "Kasseres"){
					flash.message = "Kan ikke kassere en presedenssak"
					render(view:'create',model:[preservationAndDisposalInstance:preservationAndDisposalInstance])
				} else {
	        if(!preservationAndDisposalInstance.hasErrors() && preservationAndDisposalInstance.save()) {
  	          flash.message = "PreservationAndDisposal ${preservationAndDisposalInstance.id} created"
    	        redirect(action:show,id:preservationAndDisposalInstance.id)
      	  }
        	else {
						println preservationAndDisposalInstance.errors
            render(view:'create',model:[preservationAndDisposalInstance:preservationAndDisposalInstance])
        	}
				}
    }


		def referanser = {
			def preservationAndDisposalInstance = PreservationAndDisposal.get(params.id)
			if(request.method == 'POST'){
				println params
				if( !commonService.isNull(params.documentDescription.id)) preservationAndDisposalInstance.addToDokumentBeskrivelse DocumentDescription.get(params.documentDescription.id)
				if( !commonService.isNull(params.referanseregistrering.id)) preservationAndDisposalInstance.addToRegistrering SimplifiedRecord.get(params.referanseregistrering.id)
				if( !commonService.isNull(params.arkivdel.id)) preservationAndDisposalInstance.addToSeries Series.get(params.arkivdel.id)
				if( !commonService.isNull(params.basismappe.id)){
					 
					 preservationAndDisposalInstance.addToMappe BasicFile.get(params.basismappe.id)
				}
				if( !commonService.isNull(params.klasse.id)) preservationAndDisposalInstance.addToKlass Klass.get(params.klasse.id)
				if(!preservationAndDisposalInstance.hasErrors() && preservationAndDisposalInstance.save()) {
            flash.message = "Endringer utført"
						//redirect(action:referanser,id: preservationAndDisposalInstance.id)
						return [preservationAndDisposalInstance: preservationAndDisposalInstance]
				} else {
						flash.message = "En feil oppsto: ${preservationAndDisposalInstance.errors}"
						return [preservationAndDisposalInstance: preservationAndDisposalInstance]
				}
			} else {
				return [preservationAndDisposalInstance: preservationAndDisposalInstance]
			}
		}

	/**
  * Gir en oversik over bevarig, kassasjon eller "vurderes senere" vedtak basert på parameterene Date fra, Date til, String kassasjonvedtak og String filter
  */
	def oversikt = { KassasjonCO co ->
		return _oversikt(co)
	}

  /**
  * Ved HTTP GET, gis en oversikt over disposalDecision vedtak basert på parameterene Date fra, Date til og String filter.
  * Ved HTTP POST utføres kassasjoner på valgte dokumenter, Poster som kasseres idetifiseres med at paramentere prefixes med "kasser_" og suffixes med
  * id'en til DocumentDescriptionn som skal kasseren. Verdien på parameterene må være "on".
  */
	def kasser = { KassasjonCO co ->
		if(request.method == "GET"){
			co.disposalDecision = "Kasseres"
			return _oversikt(co)
		} else if(request.method == "POST"){
			def kasseringsListe = []
			params.each{key, value ->
				if(key.startsWith("kasser_") && value == "on"){
					kasseringsListe << DocumentDescription.get((key - "kasser_") as Long)
				}
			}
			kassasjonService.kasser kasseringsListe, params.slett_til_mappe == "on" ? true : false
		}
	}

	private def _oversikt(KassasjonCO co){
		if(co.fra){
			def liste = kassasjonService.oversikt(co)
			liste = kassasjonService.filter( liste, co.filter)
			return ['liste': liste, fra: co.fra, til: co.til, vedtak: co.disposalDecision, filter: co.filter ? co.filter :"", klasser: kassasjonService.klasserIDokliste(liste), mapper: kassasjonService.mapperIDokliste(liste), arkivdeler: kassasjonService.arkivdelerIDokliste(liste)]
		}
		return []
	}
	


}

class KassasjonCO {
	Date fra
	Date til
	String disposalDecision
	String filter
}
