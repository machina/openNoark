import no.friark.ds.*
import java.text.DecimalFormat
class MappeIdGeneratorService {

  boolean transactional = true

	def generatorForMappe(mappe){
		if(mappe instanceof CaseFile) return mappeIdGenerator
		if(mappe instanceof BasicFile) return seqGenerator

		return null
	}


	def mappeIdGenerator = {
		def now = new Date()
		//def maxMappe = CaseFile.find("from CaseFile s WHERE s.fileID = max(s.fileID) AND s.fileID like '${now.format('yy')}/%'")
		def maxMappe = CaseFile.executeQuery("select max(s.fileID) from CaseFile s WHERE s.fileID like '${now.format('yy')}/%' ")
		if( maxMappe[0] == null) return "${now.format('yy')}/00001"
		def i = maxMappe[0].substring(3, maxMappe[0].length()).toLong()
		i++
		i = new DecimalFormat("00000").format(i)
		return "${now.format('yy')}/${i}"
		
	}

	def seqGenerator = {
		def maxMappe = BasicFile.executeQuery("select s.fileID from BasicFile s WHERE s.fileID not like '${new Date().format('yy')}/%' ORDER BY length(s.fileID) desc, s.fileID desc")
		if( maxMappe[0] == null) return "1"
    def i = maxMappe[0].toLong()
    i++
    return "${i}"
	}

}
