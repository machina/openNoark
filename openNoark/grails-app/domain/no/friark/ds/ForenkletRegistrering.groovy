/**
Metadata for forenklet registrering
*/
package no.friark.ds
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
    referansearkivdel( validator: {
      if(it == null || it.avsluttetdato == null) return true
      return "Kan ikke legge en registrering under en avsluttet arkivdel."
    })
    referanseforelderBasismappe( validator: {
      if(it == null || it.avsluttetdato == null) return true
      return "Kan ikke legge en registrering under en avsluttet mappe."
    })
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
    dokumenter(nullable: true)
    dokumenter(unique: true)
    referansedokumentObjekt(nullable: true)
    referansedokumentObjekt(unique: true)
    bevaringOgKassasjon(nullable: true)
    bevaringOgKassasjon(unique: false)
  }
  static hasMany = [dokumenter:Dokumentlink, referansedokumentObjekt:Dokumentobjekt]
  static mapping = {
    tablePerHierarchy false
  }
  static auditable = true
  static searchable = [except: ['referanseforelderBasismappe','referansearkivdel']]
}
