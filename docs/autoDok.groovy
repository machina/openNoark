new File("../openNoark/grails-app/controllers/").listFiles().each{
	println it.name - "Controller.groovy"
	def doc = new File("source/${it.name - "Controller.groovy"}.rst")

	def docString = "${it.name - "Controller.groovy"}\n${'=' * (it.name - 'Controller.groovy').size()}\n\n"
	docString = docString << "Funksjoner i ${it.name - "Controller.groovy"}\n\nWS metoder\n^^^^^^^^^^\n\n"
	it.eachLine{ line ->
		if(line.trim() =~ "def .+ = \\{"){
			matcher =  (line.trim() =~ "def ([a-zA-Z0-9]+) = \\{")
			if(matcher.size() > 0){
				def m = matcher[0][1]
				if(m != "index") {
					def methodString = "/${lowerFirst(it.name - 'Controller.groovy')}/${m}"
					docString = docString << "${methodString}\n${'~' * methodString.size()}\n\n"
				}
			}
		}
	}

	doc.write(docString.toString())
}



def lowerFirst(str){
	return "${str[0].toLowerCase()}${str.substring(1,str.size())}"
}
