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

import org.apache.commons.lang.time.FastDateFormat
import no.friark.ds.*
import static no.machina.utils.DateUtils.*

/**
* Operasjoner på Registreringer
*/
class RegistreringService {

    boolean transactional = true
		def commonService
		/**
    * Lager en ny Registrering basert på de inkommende metadata.
    * @param params En Map av metadata for registreringen.
    */
		def registrer(params){
        def registrering = null
				println "regtype: ${params.registreringstype}"
				def korrespondansepart = null
				def saksansvar
				//for webservices
        if(params.registrering != null){
          params.registrering.arkivertdato = parse(params.ForenkletRegistrering.arkivertdato)
          params.registrering.opprettetdato = parse(params.ForenkletRegistrering.opprettetdato)

          switch(params.registreringstype){
						case 'Forenkletregistrering':
							registrering = new ForenkletRegistrering(params.registrering)
							break
						case 'Journalpost':
							registrering = new Journalpost(params.registrering)
							break
					}

					if(params.registrering.mappe_id != null){
            registrering.setReferanseforelderBasismappe(Basismappe.get(Long.parseLong(params.ForenkletRegistrering.mappe_id)))
          }
          if(params.registrering.klasse_id != null){
            registrering.setReferanseforelderKlasse(Klasse.get(Long.parseLong(params.ForenkletRegistrering.klasse_id)))
          }
          if(params.registrering.arkivdel_id != null){
            registrering.setReferansearkivdel(Arkivdel.get(Long.parseLong(params.ForenkletRegistrering.arkivdel_id)))
          }
					

        } else { //for web interface
					
					switch(params.registreringstype){
            case 'Forenkletregistrering':
              registrering = new ForenkletRegistrering(params)
              break
            case 'Journalpost':
              registrering = new Journalpost(params)
							korrespondansepart = new Korrespondansepart(params)
							saksansvar = new Saksansvar(params)
              break
          }
					
        }
        commonService.setNewSystemID registrering
				
				if(registrering.referanseforelderBasismappe && registrering.referanseforelderBasismappe.referansearkivdel.periodeStatus == "Overlappingsperiode"){
					def mappe = registreringInstance.referanseforelderBasismappe
					def del = mappe.referansearkivdel
					del.removeFromReferansemappe mappe
					del.save()
					del.referansearvtaker.addToReferansemappe mappe
					del.referansearvtaker.save()
				}
				
				if(saksansvar != null){
						saksansvar.addToJournalpost(registrering)
						registrering.saksansvar = saksansvar
						if(!saksansvar.save()) println saksansvar.errors
				}
				if(!registrering.hasErrors() && registrering.save()){
					if(korrespondansepart != null){
						korrespondansepart.journalpost = registrering
						registrering.addToKorespondansepart(korrespondansepart)
						korrespondansepart.save()
					}
						
					return [registrering, false]
				} else {
					println registrering.errors
					return [registrering, true]
				}
		}

	def getRegistreringTyper(){
      commonService.getParameter("tilgjengelige_registreringstyper").split(",").collect{it.trim()}
  }
}
