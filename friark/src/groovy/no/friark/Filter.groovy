/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

package no.friark
import org.friark.ds.*
class Filter{

	def mappe = [:]

	def klasse = [:]

	def arkivdel = [:]


	boolean isApplicable(DocumentDescription dok){
		if(!isApplicableMappe(dok)) return false
		if(!isApplicableKlass(dok)) return false	
		if(!isApplicableSeries(dok)) return false
		println "returning true"
		return true
	}

	boolean isApplicableMappe(DocumentDescription dok){
		if(mappe.keySet().empty) return true
		def mappeOk = false
    dok.records.each{ dl ->
				println "checking mappe: ${dl.referenceRecord.parentFile.id}"
				def key = mappe.keySet().toArray()[0]
        def mappe_ = dl.referenceRecord.parentFile
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

	boolean isApplicableKlass(DocumentDescription dok){
  	if(klasse.keySet().empty) return true
		def klasseOk = false
		dok.records.each{ dl ->
			def key = klasse.keySet().toArray()[0]
			def klasse_ = dl.referenceRecord.parentClass
			if(klasse_ == null) {
				def mappe_ = dl.referenceRecord.parentFile
	      if(mappe_){
					klasse_ = mappe_.parentClass
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


	boolean isApplicableSeries(DocumentDescription dok){
		if(arkivdel.keySet().empty) return true
		def arkivdelOk = false
		
		dok.records.each{ dl ->
			def key = arkivdel.keySet().toArray()[0]
			
			def arkivdel_ = dl.referenceRecord.recordSection
			if(arkivdel_ == null){
				def mappe_ = dl.referenceRecord.parentFile
        if(mappe_){
          arkivdel_ = mappe_.recordSection
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
