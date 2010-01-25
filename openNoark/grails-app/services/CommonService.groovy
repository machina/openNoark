import no.friark.ds.*

class CommonService {

    boolean transactional = true

    def setNewSystemID(def obj) {
			obj.systemID = UUID.randomUUID().toString()
    }

		boolean isNull(def obj){
			return obj == null || obj == 'null'
		}
}
