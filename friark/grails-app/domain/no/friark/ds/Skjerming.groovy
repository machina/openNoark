/**
Metadata for skjerming
<br/>
Grupperes inn i:	Arkivdel, Klasse, Basismappe, Forenklet registrering, Dokumentbeskrivelse
<br/>
Forekomst:		0-1
<br/>
I Noark 4 har disse attributtene forskjellig navn avhengig av hvilket nivå i arkivstrukturen de er tilknyttet. Nedenfor er tatt med referanse til attributter på journalpostnivået.

*/
package no.friark.ds
class Skjerming {
  String tilgangsrestriksjon
  String skjermingshjemmel
  String skjermingdokument
  String skjermingsvarighet
  Date skjermingopphørerdato
  static constraints = {
    tilgangsrestriksjon(nullable: false)
    tilgangsrestriksjon(unique: true)
    skjermingshjemmel(nullable: false)
    skjermingshjemmel(unique: true)
    skjermingmetadata(minSize: 1)
    skjermingmetadata(unique: false)
    skjermingdokument(nullable: true)
    skjermingdokument(unique: true)
    skjermingsvarighet(nullable: false)
    skjermingsvarighet(unique: true)
    skjermingopphørerdato(nullable: false)
    skjermingopphørerdato(unique: true)
  }
  static hasMany = [skjermingmetadata:String]
  static mapping = {
  }
}
