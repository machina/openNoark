//package no.firark

import grails.test.*
import no.friark.Filter
import no.friark.FilterBuilder

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


}
