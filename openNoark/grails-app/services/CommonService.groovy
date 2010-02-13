import no.friark.ds.*
import org.apache.shiro.SecurityUtils

class CommonService {

    boolean transactional = true

    def setNewSystemID(def obj) {
			obj.systemID = UUID.randomUUID().toString()
    }

		boolean isNull(def obj){
			return obj == null || obj == 'null'
		}
	
		void setCreated(obj) {
			setCreatedBy("opprettetav", obj)
			setCreatedAt("opprettetdato", obj)
		}
	
		void setCreatedBy(field, obj){
			obj."$field" = SecurityUtils.subject.principal
		}

		void setCreatedAt(field, obj){
      obj."$field" = new Date()
    }


		String getParameter(def key){
			def param = Parameter.findByKey(key.toString())
			if(param && param.value) return param.value
			return defaults."${key}"
		}


	def defaults = [
									autorisert_ny_versjon_av_ekspedert: "false",
									autorisert_slette_inaktive_doumenter: "false"
								 ]
}
