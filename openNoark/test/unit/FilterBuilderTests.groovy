//package no.firark

import grails.test.*
import no.friark.Filter
import no.friark.FilterBuilder
import no.machina.gestalt2.SandboxingClassLoader
import org.codehaus.groovy.control.CompilerConfiguration
import no.friark.ds.*
class FilterBuilderTests extends GroovyTestCase {

	void testFilterBuilder() {
		FilterBuilder fb = new FilterBuilder()
		fb.mappe(id: 1)

		Filter f = fb.filter
		
		assertEquals 1, f.mappe.id
	}

	void testFilterBuilderFromString() {
    FilterBuilder fb = new FilterBuilder()
    def builderString = "mappe(id: 1)"

		Binding binding = new Binding();
    binding.setVariable("builder", fb)
    GroovyShell shell = new GroovyShell(binding);
   	builderString = "builder.build{\n${builderString}\n}\n return builder.filter"
	  def f = shell.evaluate(builderString);

    assertEquals 1, f.mappe.id
  }


	void testFilterBuilderDangerousString() {
    FilterBuilder fb = new FilterBuilder()
    def builderString = "mappe(id: 1)\n\"ls\".execute()\n"
		def cl = new SandboxingClassLoader(["java.lang.String": ["length"], "java.lang.Integer": [], "org.codehaus.groovy.runtime.InvokerHelper": [], "java.lang.Object": [], "no.friark.FilterBuilder": [], "no.friark.Filter": []])
    Binding binding = new Binding();
    binding.setVariable("builder", fb)
    //GroovyShell shell = new GroovyShell(cl, binding, CompilerConfiguration.DEFAULT);
    builderString = "builder.build{\n${builderString}\n}\n return builder.filter"
		try{
	    //shell.evaluate(builderString);
			Class scriptClass = cl.parseClass(new GroovyCodeSource(builderString, "restriced", "/restricted/res"));
			println scriptClass
			println scriptClass.methods
			fail "dangerous script executed"
		} catch(Exception t){
			t.printStackTrace()
		}
  }

	void testFilterBuilderNotDangerousString() {
    FilterBuilder fb = new FilterBuilder()
    def builderString = "mappe(id: 1)"
    def cl = new SandboxingClassLoader(["java.lang.String": ["length"], "java.lang.Integer": [], "org.codehaus.groovy.runtime.InvokerHelper": [], "java.lang.Object": ["build"], "no.friark.FilterBuilder": [], "no.friark.Filter": [], "java.lang.Long": []])
    Binding binding = new Binding();
    binding.setVariable("builder", fb)
    //GroovyShell shell = new GroovyShell(cl, binding, CompilerConfiguration.DEFAULT);
    builderString = "builder.build{\n${builderString}\n}\n return builder.filter"
    try{
      //shell.evaluate(builderString);
      Class scriptClass = cl.parseClass(new GroovyCodeSource(builderString, "restriced", "/restricted/res"));
			def script = scriptClass.newInstance()
			script.setBinding(binding)
			def f = script.run();

	    assertEquals 1, f.mappe.id
      println scriptClass
      println scriptClass.methods
      //fail "dangerous script executed"
    } catch(Exception t){
      t.printStackTrace()
			fail "safe script excepted"
    }
  }

}
