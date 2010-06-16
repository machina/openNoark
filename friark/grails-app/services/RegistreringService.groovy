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
				params = fixParams(params)
        def registrering = null
				println "regtype: ${params.recordType}"
				def korrespondansepart = null
				def saksansvar
				//for webservices
        if(params.registrering != null){
          params.registrering.archivedDate = parse(params.SimplifiedRecord.archivedDate)
          params.registrering.createdDate = parse(params.SimplifiedRecord.createdDate)

          switch(params.recordType){
						case 'Forenkletregistrering':
							registrering = new SimplifiedRecord(params.registrering)
							break
						case 'RegistryEntry':
							registrering = new RegistryEntry(params.registrering)
							break
					}

					if(params.registrering.mappe_id != null){
            registrering.setReferanseforelderBasicFile(BasicFile.get(Long.parseLong(params.SimplifiedRecord.mappe_id)))
         }
          if(params.registrering.klasse_id != null){
            registrering.setReferanseforelderKlass(Klass.get(Long.parseLong(params.SimplifiedRecord.klasse_id)))
         }
          if(params.registrering.arkivdel_id != null){
            registrering.setReferansearkivdel(Series.get(Long.parseLong(params.SimplifiedRecord.arkivdel_id)))
         }
					

       } else { //for web interface
					
					switch(params.recordType){
            case 'Forenkletregistrering':
              registrering = new SimplifiedRecord(params)
              break
            case 'RegistryEntry':
              registrering = new RegistryEntry(params)
							korrespondansepart = new Client(params)
							saksansvar = new CaseResponsibility(params)
              break
         }
					
       }
        commonService.setNewSystemID registrering
				commonService.setCreated registrering
				if(registrering.parentFile && registrering.parentFile.recordSection.periodStatus == "Overlappingsperiode"){
					def mappe = registrering.parentFile
					def del = mappe.recordSection
					del.removeFromFile mappe
					del.save()
					del.successor.addToFile mappe
					del.successor.save()
				}
				
				if(saksansvar != null){
						saksansvar.addToRegistryEntry(registrering)
						registrering.caseResponsibility = saksansvar
						if(!saksansvar.save()) println saksansvar.errors
				}
				if(!registrering.hasErrors() && registrering.save()){
					if(korrespondansepart != null){
						korrespondansepart.registryEntry = registrering
						registrering.addToClients(korrespondansepart)
						korrespondansepart.save()
					}
						
					return [registrering, false]
				} else {
					println registrering.errors
					return [registrering, true]
				}
		}

	def update(params){
		params = fixParams(params)
		def record = SimplifiedRecord.get( params.id )	
		params.createdDate = record.createdDate
		params.createdBy = record.createdBy
		record.properties = params
    if(!record.hasErrors() && record.save()) {
    	return [record, true]
    }
    else {
			return [record, false]
    }

	}

	def fixParams(def params){
		if(params.simplifiedRecord) params = params.simplifiedRecord
		commonService.trimAll(params)
		params.parentFile = BasicFile.get(params.'parentFile.id')
		params.archivedDate = Date.parse("yyyy-MM-dd hh:mm:ss.SSS z" ,params.archivedDate)
		return params
	}

	def getRegistreringTyper(){
      commonService.getParameter("tilgjengelige_recordTyper").split(",").collect{it.trim()}
	}
}
