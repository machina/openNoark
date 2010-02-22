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
