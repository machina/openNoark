//package no.firark

import grails.test.*
import no.friark.Filter
import no.friark.ds.*
class FilterTests extends GroovyTestCase {

	void testFilter() {
		Filter f = new Filter()
		Basismappe m = new Basismappe(id: 1)
		ForenkletRegistrering fr = new ForenkletRegistrering(referanseforelderBasismappe: m)
		Dokumentbeskrivelse o = new Dokumentbeskrivelse()
		Dokumentlink dl = new Dokumentlink(referanseregistrering: fr, dokumentbeskrivelse: o)
		o.registreringer = []
		o.registreringer.add(dl)

		f.mappe.id = "1"

		assertTrue f.isApplicable(o)

		m.id = 2
		assertFalse f.isApplicable(o)
	}

	void testKlasseFilter() {
		Filter f = new Filter()
		Klasse k = new Klasse(id: 1)
		Dokumentbeskrivelse o = new Dokumentbeskrivelse()
	  ForenkletRegistrering fr = new ForenkletRegistrering(referanseforelderKlasse: k)
		Dokumentlink dl = new Dokumentlink(referanseregistrering: fr, dokumentbeskrivelse: o)
    o.registreringer = []
    o.registreringer.add(dl)
		
		f.klasse.id = 1

		assertTrue f.isApplicable(o)

		k.id = 2
		assertFalse f.isApplicable(o)


		fr.referanseforelderKlasse = null

		Basismappe m = new Basismappe(id: 3, referanseforelderKlasse: k)
		fr.referanseforelderBasismappe = m

		k.id = 1
		assertTrue f.isApplicable(o)

    k.id = 2
    assertFalse f.isApplicable(o)
	}

	void testArkivdelFilter() {
		Filter f = new Filter()
		Arkivdel a = new Arkivdel(id:1)
		
		Dokumentbeskrivelse o = new Dokumentbeskrivelse()
    ForenkletRegistrering fr = new ForenkletRegistrering(referansearkivdel: a)    
    Dokumentlink dl = new Dokumentlink(referanseregistrering: fr, dokumentbeskrivelse: o)
    o.registreringer = []
    o.registreringer.add(dl)
		

		f.arkivdel.id = 1

		assertTrue f.isApplicable(o)

    a.id = 2
    assertFalse f.isApplicable(o)
		
		fr.referansearkivdel = null

    Basismappe m = new Basismappe(id: 3, referansearkivdel: a)
    fr.referanseforelderBasismappe = m
		
		a.id = 1
		assertTrue f.isApplicable(o)

    a.id = 2
    assertFalse f.isApplicable(o)
	}

}
