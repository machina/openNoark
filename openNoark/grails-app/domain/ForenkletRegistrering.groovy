/**
Metadata for forenklet registrering¤¤¤¤¤
 ¤¤¤¤¤

*/
class ForenkletRegistrering extends Base{
  String registreringstype
  Date opprettetdato
  String opprettetav
  Date arkivertdato
  String arkivertav
  Basismappe referanseforelderBasismappe
  Klasse referanseforelderKlasse
  Arkivdel referansearkivdel
  BevaringOgKassasjon bevaringOgKassasjon
  static constraints = {
    registreringstype(nullable: false)
    registreringstype(unique: false)
    opprettetdato(nullable: false)
    opprettetdato(unique: false)
    opprettetav(nullable: false)
    opprettetav(unique: false)
    arkivertdato(nullable: false)
    arkivertdato(unique: false)
    arkivertav(nullable: false)
    arkivertav(unique: false)
    referanseforelderBasismappe(nullable: true)
    referanseforelderBasismappe(unique: false)
    referanseforelderKlasse(nullable: true)
    referanseforelderKlasse(unique: false)
    referansearkivdel(nullable: true)
    referansearkivdel(unique: false)
    referansedokumentBeskrivelse(nullable: true)
    referansedokumentBeskrivelse(unique: false)
    referansedokumentObjekt(nullable: true)
    referansedokumentObjekt(unique: false)
    bevaringOgKassasjon(nullable: true)
    bevaringOgKassasjon(unique: false)
  }
  static hasMany = [referansedokumentBeskrivelse:Dokumentbeskrivelse, referansedokumentObjekt:Dokumentobjekt]
  static mapping = {
    tablePerHierarchy false
  }
  static searchable = true
  static auditable = true
}
