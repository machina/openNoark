import org.friark.ds.*
import org.apache.shiro.SecurityUtils
class KlassService {

		def commonService

    boolean transactional = true

    def create(params) {
			if(params.klass) params = params.klass
	    if (!SecurityUtils.subject.isPermitted("klasser:opprett")) {
		   throw new Exception("Kassering ikke tillatt for bruker.")
     }
			params.parentClassificationSystem = ClassificationSystem.get(params.'parentClassificationSystem.id')
      def klasseInstance = new Klass(params)
      commonService.setCreated(klasseInstance)
      commonService.setNewSystemID(klasseInstance)

      if(params.keyword && params.keyword instanceof String) klasseInstance.keyword = params.keyword.tokenize(" ")
			
		  if(!klasseInstance.hasErrors() && klasseInstance.save()) {
      	return [klasseInstance, true]
     }

      return [klasseInstance, false]

		}
		
	def update(params) {
		def klasseInstance = Klass.get( params.id != null ? params.id : params.klass.id )
			if(params.klass) params = params.klass
			println "PARAMS: ${params}"
			params.createdDate = klasseInstance.createdDate  //can not change created date
			if (!SecurityUtils.subject.isPermitted("klasser:opprett")) {
       throw new Exception("Kassering ikke tillatt for bruker.")
     }
			if(klasseInstance.finalisedDate != null){
				klasseInstance.errors.rejectValue("finalisedDate", "", "Kan ikke endre en avsluttet klasse")
				return [klasseInstance, false]
			}

			if(params.version) {
				def version = params.version.toLong()
					if(klasseInstance.version > version) {
						klasseInstance.errors.rejectValue("version", "klasse.optimistic.locking.failure", "Another user has updated this Klass while you were editing.")
						return [klasseInstance, false]
					}
			}
			println "PARAMS.TITLE: ${params.title}"
			params.parentClassificationSystem = ClassificationSystem.get(params.'parentClassificationSystem.id')
		
  
			//printl  "params.preservationAndDisposal ${params.preservationAndDisposal}"
			if(params.finalisedDate_year == "") params.finalisedDate = null
			klasseInstance.properties = params

			if(klasseInstance.finalisedDate != null){
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
