/*
    This file is part of Friark.

    Friark is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Friark is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Friark.  If not, see <http://www.gnu.org/licenses/>.
*/

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
