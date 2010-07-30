/**
Metadata for bevaring og kassasjon
<br/>
Grupperes inn i:	Arkivdel, Klasse, Basismappe, Forenklet registrering, Dokumentbeskrivelse
Forekomst:		0-1
<br/>
I Noark 4 har disse attributtene forskjellig navn avhengig av hvilket nivå i arkivstrukturen de er tilknyttet. Nedenfor er tatt med referanse til attributter på saksnivået.
*/
package org.friark.ds
class PreservationAndDisposal {
  String disposalDecision
  String disposalAuthority
  String preservationTime
  Date disposalDate
  static constraints = {
    disposalDecision(inList: ["Bevares", "Kasseres", "Vurderes senere"])
    disposalDecision(nullable: false)
    disposalDecision(unique: false)
    disposalAuthority(nullable: true)
    disposalAuthority(unique: false)
    preservationTime(nullable: false)
    preservationTime(unique: false)
    disposalDate(nullable: false)
    disposalDate(unique: false)
    record(nullable: true)
    record(unique: false)
    series(nullable: true)
    series(unique: false)
    file(nullable: true)
    file(unique: false)
    klass(nullable: true)
    klass(unique: false)
    documentDescription(nullable: true)
    documentDescription(unique: false)
  }
  static hasMany = [record:SimplifiedRecord, series:Series, file:BasicFile, klass:Klass, documentDescription:DocumentDescription]
  static mapping = {
  }
}
