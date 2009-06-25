import groovy.xml.MarkupBuilder

def DELIM ="¤"
def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
def xsd = builder.'xsd:schema'( targetNamespace: "http://www.machina.no/noark", 'xmlns:ecore': "http://www.eclipse.org/emf/2002/Ecore",
    'xmlns:noark': "http://www.machina.no/noark",
    'xmlns:xsd': "http://www.w3.org/2001/XMLSchema"){

	def lines = new File("noark_5_metadata.csv").readLines().iterator()
	while(lines.hasNext()){
		def line = lines.next()
		if(line.startsWith("Metadata for ")){
			'xsd:complexType'(name: camelize( line.substring(13, line.indexOf(DELIM)) )){
				def state = "package"
				'xsd:sequence'() {
					println "complextype started"
					while(lines.hasNext() && !line.startsWith("Nr.${DELIM}")){
						println "zooming to parmas def with: ${line}"
						line = lines.next()
					}
					while(lines.hasNext()){
						line = lines.next()
						if(line == " ¤¤¤¤¤") break;
						vals = line.split("¤")
						def type = vals[5]
						if(type.contains("/") && !type.contains("Dato")){
							type.split("/").collect { t ->
								def printableType = translateType(t)
								'xsd:element'(name: "${camelize(vals[1])}_${t.substring(0,t.indexOf('.')).replace(' ','')}", type: printableType)
							}
						} else {
							'xsd:element'(name: camelize(vals[1]), type: translateType(vals[5]))
						}

					}
				}
				println "complextype complete"
			}
		}
	}
}
println writer.toString()
new File("noark_5.xsd").write(writer.toString())
def translateType(type){
	switch(type){
		case ~/Tekststreng.*/:
			return "xsd:string"
		case "Dato/klokkeslett":
		case "Dato":
			return "xsd:dateTime"
		case ~/.*systemID/:
			return "noark:${camelize(((type - '.systemID') - '. systemID')-'.systemid')}"
	}
	println "unknown type: ${type}"
	return "Unknown Type"
}

def capitalize(delegate){
	if(delegate == "") return ""
	def chars = delegate.getChars()
	chars[0] = chars[0].toUpperCase() 
	return new String(chars)
}

def camelize(name){
	def retval = name.split(" ").collect { word -> 
    capitalize(word.toLowerCase())
  }.join("")
	if(retval == "Forenkletregistrering") return "ForenkletRegistrering"
	return retval
}



