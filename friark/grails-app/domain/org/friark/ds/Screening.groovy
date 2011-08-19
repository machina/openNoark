/**
Metadata for skjerming
<br/>
Grupperes inn i:	Arkivdel, Klasse, Basismappe, Forenklet registrering, Dokumentbeskrivelse
<br/>
Forekomst:		0-1
<br/>
I Noark 4 har disse attributtene forskjellig navn avhengig av hvilket nivå i arkivstrukturen de er tilknyttet. Nedenfor er tatt med referanse til attributter på journalpostnivået.

*/
package org.friark.ds
class Screening {
  String accessRestriction
  String screeningAuthority
  String screeningDocument
  String screeningDuration
  Date screeningCeasesDate
  static constraints = {
    accessRestriction(nullable: false)
    accessRestriction(unique: false)
    screeningAuthority(nullable: false)
    screeningAuthority(unique: false)
    screeningMetadata(minSize: 1)
    screeningMetadata(unique: false)
    screeningDocument(nullable: true)
    screeningDocument(unique: true)
    screeningDuration(nullable: false)
    screeningDuration(unique: false)
    screeningCeasesDate(nullable: false)
    screeningCeasesDate(unique: false)
  }
  static hasMany = [screeningMetadata:String]
  static mapping = {
  }
}
