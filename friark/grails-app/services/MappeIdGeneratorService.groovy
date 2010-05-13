import no.friark.ds.*
import java.text.DecimalFormat
class MappeIdGeneratorService {

  boolean transactional = true

	def generatorForMappe(mappe){
		if(mappe instanceof Saksmappe) return mappeIdGenerator
		if(mappe instanceof Basismappe) return seqGenerator

		return null
	}


	def mappeIdGenerator = {
		def now = new Date()
		//def maxMappe = Saksmappe.find("from Saksmappe s WHERE s.mappeid = max(s.mappeid) AND s.mappeid like '${now.format('yy')}/%'")
		def maxMappe = Saksmappe.executeQuery("select max(s.mappeid) from Saksmappe s WHERE s.mappeid like '${now.format('yy')}/%' ")
		if( maxMappe[0] == null) return "${now.format('yy')}/00001"
		def i = maxMappe[0].substring(3, maxMappe[0].length()).toLong()
		i++
		i = new DecimalFormat("00000").format(i)
		return "${now.format('yy')}/${i}"
		
	}

	def seqGenerator = {
		def maxMappe = Basismappe.executeQuery("select s.mappeid from Basismappe s WHERE s.mappeid not like '${new Date().format('yy')}/%' ORDER BY length(s.mappeid) desc, s.mappeid desc")
		if( maxMappe[0] == null) return "1"
    def i = maxMappe[0].toLong()
    i++
    return "${i}"
	}

}
