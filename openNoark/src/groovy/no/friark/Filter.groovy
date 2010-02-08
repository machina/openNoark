package no.friark
import no.friark.ds.*
class Filter{

	def mappe = [:]

	def klasse = [:]

	def arkivdel = [:]


	boolean isApplicable(Dokumentbeskrivelse dok){
		if(!isApplicableMappe(dok)) return false
		if(!isApplicableKlasse(dok)) return false	
		if(!isApplicableArkivdel(dok)) return false
		println "returning true"
		return true
	}

	boolean isApplicableMappe(Dokumentbeskrivelse dok){
		if(mappe.keySet().empty) return true
		def mappeOk = false
    dok.registreringer.each{ dl ->
				println "checking mappe: ${dl.referanseregistrering.referanseforelderBasismappe.id}"
				def key = mappe.keySet().toArray()[0]
        def mappe_ = dl.referanseregistrering.referanseforelderBasismappe
        def keyval = mappe_."${key}"
        //println "mappe_.${key}: ${keyval}  type: ${keyval.class}"
        //println "mappe[${key}]: ${mappe[key]}    type: ${mappe[key].class}"
        if(equalsIgnoreType(mappe_."${key}", mappe[key])) {
					mappeOk = true
					return
				}
    }
		return mappeOk
	}

	boolean isApplicableKlasse(Dokumentbeskrivelse dok){
  	if(klasse.keySet().empty) return true
		def klasseOk = false
		dok.registreringer.each{ dl ->
			def key = klasse.keySet().toArray()[0]
			def klasse_ = dl.referanseregistrering.referanseforelderKlasse
			if(klasse_ == null) {
				def mappe_ = dl.referanseregistrering.referanseforelderBasismappe
	      if(mappe_){
					klasse_ = mappe_.referanseforelderKlasse
  	    }
			}
			if(klasse_){
				if(equalsIgnoreType(klasse_."${key}", klasse[key])) {
          klasseOk = true
          return
        }
			}
		}
		
		return klasseOk
	}


	boolean isApplicableArkivdel(Dokumentbeskrivelse dok){
		if(arkivdel.keySet().empty) return true
		def arkivdelOk = false
		
		dok.registreringer.each{ dl ->
			def key = arkivdel.keySet().toArray()[0]
			
			def arkivdel_ = dl.referanseregistrering.referansearkivdel
			if(arkivdel_ == null){
				def mappe_ = dl.referanseregistrering.referanseforelderBasismappe
        if(mappe_){
          arkivdel_ = mappe_.referansearkivdel
        }
			}
			if(arkivdel_){

				if(equalsIgnoreType(arkivdel_."${key}", arkivdel[key])) {
          arkivdelOk = true
          return
        }
			}
		}
		
		return arkivdelOk
	}


	boolean equalsIgnoreType(arg1, arg2){
		if(arg1 instanceof String || arg2 instanceof String) return arg1.toString() == arg2.toString()
		return arg1 == arg2
	}

}
