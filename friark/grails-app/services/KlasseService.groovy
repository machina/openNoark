import no.friark.ds.*
import org.apache.shiro.SecurityUtils
class KlasseService {

		def commonService

    boolean transactional = true

		def save(params) {
	    if (!SecurityUtils.subject.isPermitted("klasser:opprett")) {
		   throw new Exception("Kassering ikke tillatt for bruker.")
      }
  
      def klasseInstance = new Klasse(params)
      commonService.setCreated(klasseInstance)
      commonService.setNewSystemID(klasseInstance)

      if(params.nøkkelord && params.nøkkelord instanceof String) klasseInstance.nøkkelord = params.nøkkelord.tokenize(" ")
			
		  if(!klasseInstance.hasErrors() && klasseInstance.save()) {
      	return [klasseInstance, true]
      }

      return [klasseInstance, false]

		}
		def update(klasseInstance, params) {
			if (!SecurityUtils.subject.isPermitted("klasser:opprett")) {
       throw new Exception("Kassering ikke tillatt for bruker.")
      }
			if(klasseInstance.avsluttetdato != null){
				klasseInstance.errors.rejectValue("avsluttetdato", "", "Kan ikke endre en avsluttet klasse")
				return [klasseInstance, false]
			}

			if(params.version) {
				def version = params.version.toLong()
					if(klasseInstance.version > version) {
						klasseInstance.errors.rejectValue("version", "klasse.optimistic.locking.failure", "Another user has updated this Klasse while you were editing.")
						return [klasseInstance, false]
					}
			}
		
			

			println "params.bevaringOgKassasjon ${params.bevaringOgKassasjon}"
			klasseInstance.properties = params
			if(klasseInstance.avsluttetdato != null){
				klasseInstance.avsluttetav = SecurityUtils.subject.principal
			}
			if(!klasseInstance.hasErrors() && klasseInstance.save()) {
				return [klasseInstance, true]
			}
			else {
				return [klasseInstance, false]
			}
		}
}
