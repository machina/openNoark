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
			'xsd:complexType'(name: line.substring(13, line.indexOf(DELIM))){
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
						'xsd:element'(name: vals[1], type: translateType(vals[5]))

					}
				}
				println "complextype complete"
			}
		}
	}
}
println writer.toString()
new File("noark_5.xml").write(writer.toString())
def translateType(type){
	switch(type){
		case ~/Tekststreng.*/:
			return "xsd:string"
		case "Dato/klokkeslett":
		case "Dato":
			return "xsd:dateTime"
		case ~/.*systemID/:
			return "noark:${type - '.systemID'}"
	}
	println "unknown type: ${type}"
	return "Unknown Type"
}

def spilit(line){

}
