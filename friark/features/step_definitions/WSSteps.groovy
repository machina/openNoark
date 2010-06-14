import org.openqa.selenium.By
import static org.junit.Assert.*
import static org.junit.matchers.JUnitMatchers.*
import groovy.text.Template
import groovy.text.SimpleTemplateEngine

this.metaClass.mixin(cuke4duke.GroovyDsl)

def defaultFonds="""<?xml version="1.0" encoding="UTF-8"?>
<fonds>
  <title>Test Fonds 1</title> 
</fonds>
"""

def defaultSeries = '''<?xml version="1.0" encoding="UTF-8"?>
<series>
	<title>Test Series 1</title>
	<documentMedium>Papyrus</documentMedium>
	<parent>$parentId</parent>	
</series>
'''

def ctrlName = [Fonds: 'arkiv', Series: 'series']

def currentResult

Given(~"an empty database"){
	browser.get("http://localhost:8080/friark/auth/signIn?username=admin&password=admin")
	browser.get("http://localhost:8080/friark/test/clearAll")
}


/*Given(~"an empty database I create a new ([A-z]+) with default values") { String klass ->
    switch(klass){
			case "Fonds":
				obj = defaultFonds
				break
			default:
				throw new Exception("Feature tried to create wron class")
		}
}*/

Given(~"I am logged in as admin"){
	browser.get("http://localhost:8080/friark/auth/signIn?username=admin&password=admin")
}



When(~"I POST a new object to the ([A-Z][a-z]*) Controller"){ String ctrl ->
	switch(ctrl){
		case 'Fonds':
			browser.post("http://localhost:8080/friark/ws/arkiv.xml",defaultFonds)
			currentResult = browser.pageSource
			break
		case 'Series':
				browser.post("http://localhost:8080/friark/ws/arkiv.xml",defaultFonds)	
				def fonds = new XmlSlurper().parseText(browser.pageSource)
				def series = new SimpleTemplateEngine().createTemplate(defaultSeries).make([parentId: fonds.@id]).toString()
				browser.post("http://localhost:8080/friark/ws/series.xml",series)
				currentResult = browser.pageSource
				//println browser.pageSource
			break
		default:
        throw new Exception("Feature tried to contact unknown controller")

	}
	//println browser.pageSource
}


Then(~"there should be (\\d+) ([A-Z][a-z]*) in the database"){ int num, String domain ->
	browser.get("http://localhost:8080/friark/ws/${ctrlName[domain]}.xml")
	def source = browser.pageSource
	//println source
	def list = new XmlSlurper().parseText(source)
	def objs = list."${domain.toLowerCase()}"
	assertEquals num, objs.size()
	currentValue = source
	//assertTrue browser.getPageSource().length() > 0
	//println browser.getPageSource
}


When(~"I create a updated ([A-Z][a-z]*)"){ String domain ->
	matcher = (currentResult =~ /Test ${domain} 1/)
	obj= matcher.replaceAll( "updated title")
}

When(~"I PUT the updated object to the ([A-Z][a-z]*) Controller"){ String domain ->
	println obj
	browser.put("http://localhost:8080/friark/ws/${ctrlName[domain]}.xml",obj)
}

Then(~"the updated ([A-Z][a-z]*) should have the new title"){ String domain ->
	def source = browser.pageSource
	println source
	def updatedObj = new XmlSlurper().parseText(source)
	assertEquals "updated title", updatedObj.title.toString().trim()
}

When(~"I GET the created ([A-Z][a-z]*)"){ String domain ->
	def res = new XmlSlurper().parseText(currentResult)
	browser.get("http://localhost:8080/friark/ws/${ctrlName[domain]}/${res.@id}.xml")
	currentResult = browser.pageSource
}

Then(~"the created ([A-Z][a-z]*) should be returned"){ String domain ->
	def res = new XmlSlurper().parseText(currentResult)
	assertEquals "Test ${domain} 1".toString() , res.title.toString().trim()
}

When(~"I delete the ([A-Z][a-z]*)"){ String domain ->
	def res = new XmlSlurper().parseText(currentResult)
	browser.delete("http://localhost:8080/friark/ws/${ctrlName[domain]}/${res.@id}.xml")
}
