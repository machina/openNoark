/**
Metadata for basismappe¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Basismappe extends Base{
  String mappeid
  String mappetype
  String tittel
  String offentligtittel
  String beskrivelse
  String dokumentmedium
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Klasse referanseforelderKlasse
  Basismappe referanseforelderBasismappe
  Arkivdel referansearkivdel
  BevaringOgKassasjon bevaringOgKassasjon
  static constraints = {
    referansearkivdel( validator: {
      if(it == null || it.avsluttetdato == null) return true
      return "Kan ikke legge en mappe under en avsluttet arkivdel."
    })
    mappeid(nullable: false)
    mappeid(unique: true)
    mappetype(nullable: false)
    mappetype(unique: false)
    tittel(nullable: false)
    tittel(unique: false)
    offentligtittel(nullable: true)
    offentligtittel(unique: false)
    beskrivelse(nullable: true)
    beskrivelse(unique: false)
    nøkkelord(nullable: true)
    nøkkelord(unique: false)
    dokumentmedium(nullable: true)
    dokumentmedium(unique: false)
    oppbevaringssted(nullable: true)
    oppbevaringssted(unique: false)
    opprettetdato(nullable: false)
    opprettetdato(unique: false)
    opprettetav(nullable: false)
    opprettetav(unique: false)
    avsluttetdato(nullable: true)
    avsluttetdato(unique: false)
    avsluttetav(nullable: true)
    avsluttetav(unique: false)
    referanseforelderKlasse(nullable: true)
    referanseforelderKlasse(unique: false)
    referanseforelderBasismappe(nullable: true)
    referanseforelderBasismappe(unique: false)
    referansebarnForenkletRegistrering(nullable: true)
    referansebarnForenkletRegistrering(unique: false)
    referansebarnBasismappe(nullable: true)
    referansebarnBasismappe(unique: false)
    referansearkivdel(nullable: false)
    referansearkivdel(unique: false)
    bevaringOgKassasjon(nullable: true)
    bevaringOgKassasjon(unique: false)
    merknad(nullable: true)
    merknad(unique: false)
  }
  static hasMany = [nøkkelord:String, oppbevaringssted:String, referansebarnForenkletRegistrering:ForenkletRegistrering, referansebarnBasismappe:Basismappe, merknad:Merknad]
  static mapping = {
    tablePerHierarchy false
  }
  static auditable = true
  static searchable = [except: ['referansearkivdel']]
}
