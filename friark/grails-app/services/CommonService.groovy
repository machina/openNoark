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
import org.apache.shiro.SecurityUtils
/**
* Inneholder nyttige metoder som benyttes av flere kontrollere.
*/
class CommonService {

    boolean transactional = true

		/**
		* Setter systemID på et inkommende objekt til en vilkårlig UUID
		* @param obj Et objekt med et felt "systemId"
		*/
    def setNewSystemID(def obj) {
			obj.systemID = UUID.randomUUID().toString()
    }

		/**
		* Avgjør om det inkommende objektet er null eller strengen "null"
		* @param obj Et objekt
		* @return true hvis obj er null eller lik "null", false ellers.
		*/
		boolean isNull(def obj){
			return obj == null || obj == 'null'
		}
	
    /**
		* Setter fletene opprettetav og opprettetdata på det innkommende objektet til hhv den innloggede brukerens brukernavn og dagens dato.
		* @param obj, et objekt med feltene opprettetav og opprettetdato
		*/
		void setCreated(obj) {
			setCreatedBy("opprettetav", obj)
			setCreatedAt("opprettetdato", obj)
		}
	
		private void setCreatedBy(field, obj){
			obj."$field" = SecurityUtils.subject.principal
		}

		private void setCreatedAt(field, obj){
      obj."$field" = new Date()
    }

		/**
		* Henter frem en konfigurasjonsparameter gitt ved en nøkkel.
		* @param key Parameteren som ønskes
		@ @return String, parameterverdien.
		*/
		String getParameter(def key){
			def param = Parameter.findByKey(key.toString())
			if(param && param.value) return param.value
			return defaults."${key}"
		}


	def defaults = [
									autorisert_ny_versjon_av_ekspedert: "false",
									autorisert_slette_inaktive_doumenter: "false",
									tilgjengelige_mappetyper: "Basismappe, Saksmappe",
									tilgjengelige_registreringstyper: "Forenkletregistrering, Journalpost"
								 ]
}
