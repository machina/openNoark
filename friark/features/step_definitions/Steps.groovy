import org.openqa.selenium.By
import static org.junit.Assert.*
import static org.junit.matchers.JUnitMatchers.*
import groovy.text.Template
import groovy.text.SimpleTemplateEngine

this.metaClass.mixin(cuke4duke.GroovyDsl)

Then(~"(.+) should be set"){String attr ->
  def source = browser.pageSource
  def fonds = new XmlSlurper().parseText(source)
  assertNotNull fonds."${attr}"
  assertFalse( "" == fonds."${attr}".toString() )	
}
