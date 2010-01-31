import no.friark.ds.*

class ArkivdelService {

    boolean transactional = true
		def commonService

		def findOpenMappe(Arkivdel del){
			def retval = []
			del.referansemappe.each{
				if(it.avsluttetdato == null) retval << it
			}
			return retval
		}
		
}
