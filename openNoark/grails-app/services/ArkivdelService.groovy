import no.friark.ds.*

/**
* Metoder for å gjøre operasjoner på Arkivdel objekter.
*/
class ArkivdelService {

    boolean transactional = true
		def commonService

		/**
		* Finner alle Mapper under den inkommende arkivdelen som ikke er avsluttet.
    * @param del Arkivdelen som inneholder mapppene
    * @return en Liste av alle mappene under del som har avsluttetdato lik null
		*/
		def findOpenMappe(Arkivdel del){
			def retval = []
			del.referansemappe.each{
				if(it.avsluttetdato == null) retval << it
			}
			return retval
		}
		
}
