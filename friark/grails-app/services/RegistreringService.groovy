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
        def forenkletRegistreringInstance = null
        if(params.ForenkletRegistrering != null){
          params.ForenkletRegistrering.arkivertdato = parse(params.ForenkletRegistrering.arkivertdato)
          params.ForenkletRegistrering.opprettetdato = parse(params.ForenkletRegistrering.opprettetdato)
          forenkletRegistreringInstance = new ForenkletRegistrering(params.ForenkletRegistrering)
          if(params.ForenkletRegistrering.mappe_id != null){
            forenkletRegistreringInstance.setReferanseforelderBasismappe(Basismappe.get(Long.parseLong(params.ForenkletRegistrering.mappe_id)))
          }
          if(params.ForenkletRegistrering.klasse_id != null){
            forenkletRegistreringInstance.setReferanseforelderKlasse(Klasse.get(Long.parseLong(params.ForenkletRegistrering.klasse_id)))
          }
          if(params.ForenkletRegistrering.arkivdel_id != null){
            forenkletRegistreringInstance.setReferansearkivdel(Arkivdel.get(Long.parseLong(params.ForenkletRegistrering.arkivdel_id)))
          }

        } else {
          forenkletRegistreringInstance = new ForenkletRegistrering(params)
        }
        commonService.setNewSystemID forenkletRegistreringInstance
				
				if(forenkletRegistreringInstance.referanseforelderBasismappe && forenkletRegistreringInstance.referanseforelderBasismappe.referansearkivdel.periodeStatus == "Overlappingsperiode"){
					def mappe = forenkletRegistreringInstance.referanseforelderBasismappe
					def del = mappe.referansearkivdel
					del.removeFromReferansemappe mappe
					del.save()
					del.referansearvtaker.addToReferansemappe mappe
					del.referansearvtaker.save()
				}

				if(!forenkletRegistreringInstance.hasErrors() && forenkletRegistreringInstance.save()){
					return [forenkletRegistreringInstance, false]
				} else {
					return [forenkletRegistreringInstance, true]
				}
		}
}
