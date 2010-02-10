/**
Metadata for gradering
<br/>
Grupperes inn i:	Basismappe, Forenklet registrering, Dokmentbeskrivelse.
Forekomst:	0-1
*/
package no.friark.ds
class Gradering {
  String gradering
  Date graderingsdato
  String gradertav
  Date nedgraderingsdato
  String nedgradertav
  static constraints = {
    gradering(nullable: false)
    gradering(unique: true)
    graderingsdato(nullable: false)
    graderingsdato(unique: true)
    gradertav(nullable: false)
    gradertav(unique: true)
    nedgraderingsdato(nullable: true)
    nedgraderingsdato(unique: true)
    nedgradertav(nullable: true)
    nedgradertav(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
