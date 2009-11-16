/**
Metadata for merknad¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:       Basismappe, Basisregistrering, Dokumentbeskrivelse¤¤¤¤¤
Forekomst:               0-M¤¤¤¤¤
 ¤¤¤¤¤

*/
class Merknad {
  String merknadstekst
  Date merknadsdato
  String merknadregistrertav
  Basismappe mappe
  Basisregistrering basisRegistrering
  Dokumentbeskrivelse dokumentBeskrivelse
  MerknadType merknadstype
  static constraints = {
    merknadstekst(nullable: false)
    merknadstekst(unique: true)
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
    merknadstype(nullable: false)
    merknadstype(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
