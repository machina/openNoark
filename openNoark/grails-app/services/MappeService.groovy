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
				if(!getMappetyper().contains(params.mappetype)){
					return [[errors: ["Mappetype er ikke tillatt"]], false]
				}
				def mappe
				switch(params.mappetype){
					case 'Basismappe':
						mappe =  new Basismappe(params)
						break
					case 'Saksmappe':
						mappe =  new Saksmappe(params)

				}
				commonService.setNewSystemID mappe

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
			if(mappe.referansearkivdel.periodeStatus == null  || mappe.referansearkivdel.periodeStatus == "Aktiv periode"){
				mappe.referansearkivdel.addToReferansemappe(mappe)
				return [true]
			}

			return [false, "Kan ikke lege til en mappe i et arkiv med periodestatus ${mappe.referansearkivdel.periodeStatus}"]
		}

		def getMappetyper(){
			commonService.getParameter("tilgjengelige_mappetyper").split(",").collect{it.trim()}
   }
}
