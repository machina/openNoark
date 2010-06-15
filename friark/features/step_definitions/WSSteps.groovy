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

def defaultClassificationSystem = '''<?xml version="1.0" encoding="UTF-8"?>
<classificationSystem>
	<title>Test ClassificationSystem 1</title>
</classificationSystem>
'''

def defaultKlass = '''<?xml version="1.0" encoding="UTF-8"?>
<klass>
	<title>Test Klass 1</title>
	<parentClassificationSystem id="$parentId" />
	<classID>1</classID>
</klass>
'''

def defaultFile = '''<?xml version="1.0" encoding="UTF-8"?>
<basicFile>
	<fileType>BasicFile</fileType>
	<title>Test File 1</title>
	<recordSection id="$parentId" />
</basicFile>
'''

def ctrlName = [Fonds: 'arkiv', Series: 'series', ClassificationSystem: 'classificationSystem', Klass: 'klass', File: 'mappe']

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



When(~"I POST a new object to the ([A-z]*) Controller"){ String ctrl ->
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
			case 'ClassificationSystem':
	      browser.post("http://localhost:8080/friark/ws/${ctrlName[ctrl]}.xml",defaultClassificationSystem)
  	    currentResult = browser.pageSource
				//println currentResult
  	    break
			case 'Klass':
        browser.post("http://localhost:8080/friark/ws/${ctrlName['ClassificationSystem']}.xml",defaultClassificationSystem)
				def sys = new XmlSlurper().parseText(browser.pageSource)
				def klass = new SimpleTemplateEngine().createTemplate(defaultKlass).make([parentId: sys.@id]).toString()
        browser.post("http://localhost:8080/friark/ws/${ctrlName[ctrl]}.xml",klass)
        currentResult = browser.pageSource

        //println currentResult
	      break
			case 'File':
				browser.post("http://localhost:8080/friark/ws/arkiv.xml",defaultFonds)
        def fonds = new XmlSlurper().parseText(browser.pageSource)
        def series = new SimpleTemplateEngine().createTemplate(defaultSeries).make([parentId: fonds.@id]).toString()
        browser.post("http://localhost:8080/friark/ws/series.xml",series)
				def seriesRet = new XmlSlurper().parseText(browser.pageSource)
				def file = new SimpleTemplateEngine().createTemplate(defaultFile).make([parentId: seriesRet.@id]).toString()
				browser.post("http://localhost:8080/friark/ws/${ctrlName[ctrl]}.xml",file)
				currentResult = browser.pageSource
				//println currentResult
				break
		default:
        throw new Exception("Feature tried to contact unknown controller")

	}
	//println browser.pageSource
}


Then(~"there should be (\\d+) ([A-z]*) in the database"){ int num, String domain ->
	browser.get("http://localhost:8080/friark/ws/${ctrlName[domain]}.xml")
	def source = browser.pageSource
	//println source
	def list = new XmlSlurper().parseText(source)
	def objs = list."${domain == 'File' ? 'basicFile' : domain[0].toLowerCase() + domain.substring(1)}"
	assertEquals num, objs.size()
	currentValue = source
	//assertTrue browser.getPageSource().length() > 0
	//println browser.getPageSource
}


When(~"I create a updated ([A-z]*)"){ String domain ->
	matcher = (currentResult =~ /Test ${domain} 1/)
	obj= matcher.replaceAll( "updated title")
}

When(~"I PUT the updated object to the ([A-z]*) Controller"){ String domain ->
	//println obj
	browser.put("http://localhost:8080/friark/ws/${ctrlName[domain]}.xml",obj)
	//println browser.pageSource
}

Then(~"the updated ([A-z]*) should have the new title"){ String domain ->
	def source = browser.pageSource
	//println source
	def updatedObj = new XmlSlurper().parseText(source)
	assertEquals "updated title", updatedObj.title.toString().trim()
}

When(~"I GET the created ([A-z]*)"){ String domain ->
	def res = new XmlSlurper().parseText(currentResult)
	browser.get("http://localhost:8080/friark/ws/${ctrlName[domain]}/${res.@id}.xml")
	currentResult = browser.pageSource
}

Then(~"the created ([A-z]*) should be returned"){ String domain ->
	def res = new XmlSlurper().parseText(currentResult)
	assertEquals "Test ${domain} 1".toString() , res.title.toString().trim()
}

When(~"I delete the ([A-z]*)"){ String domain ->
	def res = new XmlSlurper().parseText(currentResult)
	//println "deleting: ${res.@id}"
	browser.delete("http://localhost:8080/friark/ws/${ctrlName[domain]}/${res.@id}.xml")
}
