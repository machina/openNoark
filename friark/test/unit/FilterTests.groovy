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
import org.friark.ds.*
class FilterTests extends GroovyTestCase {

	void testFilter() {
		Filter f = new Filter()
		BasicFile m = new BasicFile(id: 1)
		SimplifiedRecord fr = new SimplifiedRecord(parentFile: m)
		DocumentDescription o = new DocumentDescription()
		DocumentLink dl = new DocumentLink(referenceRecord: fr, documentDescription: o)
		o.records = []
		o.records.add(dl)

		f.mappe.id = "1"

		assertTrue f.isApplicable(o)

		m.id = 2
		assertFalse f.isApplicable(o)
	}

	void testKlassFilter() {
		Filter f = new Filter()
		Klass k = new Klass(id: 1)
		DocumentDescription o = new DocumentDescription()
	  SimplifiedRecord fr = new SimplifiedRecord(parentClass: k)
		DocumentLink dl = new DocumentLink(referenceRecord: fr, documentDescription: o)
    o.records = []
    o.records.add(dl)
		
		f.klasse.id = 1

		assertTrue f.isApplicable(o)

		k.id = 2
		assertFalse f.isApplicable(o)


		fr.parentClass = null

		BasicFile m = new BasicFile(id: 3, parentClass: k)
		fr.parentFile = m

		k.id = 1
		assertTrue f.isApplicable(o)

    k.id = 2
    assertFalse f.isApplicable(o)
	}

	void testSeriesFilter() {
		Filter f = new Filter()
		Series a = new Series(id:1)
		DocumentDescription o = new DocumentDescription()
    SimplifiedRecord fr = new SimplifiedRecord(recordSection: a)    
    DocumentLink dl = new DocumentLink(referenceRecord: fr, documentDescription: o)
    o.records = []
    o.records.add(dl)
		
		f.arkivdel.id = 1

		assertTrue f.isApplicable(o)

    a.id = 2
    assertFalse f.isApplicable(o)
		fr.recordSection = null
    BasicFile m = new BasicFile(id: 3, recordSection: a)
    fr.parentFile = m
		a.id = 1
		assertTrue f.isApplicable(o)

    a.id = 2
    assertFalse f.isApplicable(o)
	}

}
