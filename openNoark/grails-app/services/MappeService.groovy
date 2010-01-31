import no.friark.ds.*

class MappeService {

    boolean transactional = true
		def commonService
		def save(params) {
				def mappe = new Basismappe(params)
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
		

		def checkArkivdel(params, mappe){
			if(mappe.referansearkivdel.periodeStatus == null  || mappe.referansearkivdel.periodeStatus == "Aktiv periode"){
				mappe.referansearkivdel.addToReferansemappe(mappe)
				return [true]
			}

			return [false, "Kan ikke lege til en mappe i et arkiv med periodestatus ${mappe.referansearkivdel.periodeStatus}"]
		}
}
