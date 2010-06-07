import org.openqa.selenium.By
import static org.junit.Assert.*
import static org.junit.matchers.JUnitMatchers.*

this.metaClass.mixin(cuke4duke.GroovyDsl)

def defaultFonds="""<?xml version="1.0" encoding="UTF-8"?>
<fonds>
  <title>Test Fonds 1</title> 
</fonds>
"""

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
		case ctrl:
			browser.post("http://localhost:8080/friark/ws/arkiv.xml",defaultFonds)
			currentResult = browser.pageSource
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
	def fonds = list.fonds
	assertEquals num, fonds.size()
	currentValue = source
	//assertTrue browser.getPageSource().length() > 0
	//println browser.getPageSource
}


When(~"I create a updated Fonds"){
	matcher = (currentResult =~ /Test Fonds 1/)
	obj= matcher.replaceAll( "updated title")
}

When(~"I PUT the updated object to the Fonds Controller"){
	browser.put("http://localhost:8080/friark/ws/arkiv.xml",obj)
}

Then(~"the updated fonds should have the new title"){
	def source = browser.pageSource
	def updatedFonds = new XmlSlurper().parseText(source)
	assertEquals "updated title", updatedFonds.title.toString().trim()
}

When(~"I GET the created fonds"){
	def res = new XmlSlurper().parseText(currentResult)
	browser.get("http://localhost:8080/friark/ws/arkiv/${res.@id}.xml")
	currentResult = browser.pageSource
}

Then(~"the created fonds should be returned"){
	def res = new XmlSlurper().parseText(currentResult)
	assertEquals "Test Fonds 1", res.title.toString().trim()
}

When(~"I delete the Fonds"){
	def res = new XmlSlurper().parseText(currentResult)
	browser.delete("http://localhost:8080/friark/ws/arkiv/${res.@id}.xml")
}
