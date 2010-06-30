import org.openqa.selenium.htmlunit.HtmlUnitDriver

this.metaClass.mixin(cuke4duke.GroovyDsl)

Before() {
  browser = new HtmlUnitRESTDriver()
	defalutFonds="""
<fonds>
	<title>Test Fonds 1</title>	
</fonds>
"""
}

After() {
  browser.close()
  browser.quit()
}



