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
* Tilbyr diverse operasjoner på mapper.
*/
class MappeService {

    boolean transactional = true
		def commonService
    
    /**
    * Lager en ny mappe med de inkommende paramerterene.
    * @param params Et Map som inneholder metadata for Mappen.
    */
		def save(params) {
				def mappe = new Basismappe(params)
				commonService.setNewSystemID mappe
				commonService.setCreated(mappe)
				//def (delOk, error) = checkArkivdel params, mappe
				def (delOk, error) = checkArkivdel(params, mappe)
				if(!delOk){
					println error
					return [mappe, false]
				}
				if(params.nøkkelord && params.nøkkelord instanceof String) mappe.nøkkelord = params.nøkkelord.tokenize(" ")
				
				if(!mappe.hasErrors() && mappe.save()) {
					return [mappe, true]
				}
				println mappe.errors
				
				return [mappe, false]
		}
		
		
		private def checkArkivdel(params, mappe){
			if(mappe.referansearkivdel.arkivdelstatus == "Opprettet" && (mappe.referansearkivdel.periodeStatus == null  || mappe.referansearkivdel.periodeStatus == "Aktiv periode")){
				mappe.referansearkivdel.addToReferansemappe(mappe)
				return [true]
			}

			return [false, "Kan ikke lege til en mappe i et arkiv med periodestatus ${mappe.referansearkivdel.periodeStatus}"]
		}
}
