/**
Metadata for merknad¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:       Basismappe, Basisregistrering, Dokumentbeskrivelse¤¤¤¤¤
Forekomst:               0-M¤¤¤¤¤
 ¤¤¤¤¤

*/
class Merknad {
  String merknadstekst
  String merknadstype
  Date merknadsdato
  String merknadregistrertav
  Basismappe mappe
  Basisregistrering basisRegistrering
  Dokumentbeskrivelse dokumentBeskrivelse
  static constraints = {
    merknadstekst(nullable: false)
    merknadstekst(unique: true)
    merknadstype(nullable: true)
    merknadstype(unique: true)
    merknadsdato(nullable: false)
    merknadsdato(unique: true)
    merknadregistrertav(nullable: false)
    merknadregistrertav(unique: true)
    mappe(nullable: true)
    mappe(unique: false)
    basisRegistrering(nullable: true)
    basisRegistrering(unique: false)
    dokumentBeskrivelse(nullable: true)
    dokumentBeskrivelse(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
