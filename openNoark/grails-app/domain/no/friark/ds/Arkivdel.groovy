/**
Metadata for arkivdel¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Arkivdel extends Base{
  String tittel
  String beskrivelse
  String arkivdelstatus
  String dokumentmedium
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Date arkivperiodestartdato
  Date arkivperiodesluttdato
  Arkiv referanseforelder
  Arkivdel referanseforløper
  Arkivdel referansearvtaker
  Klassifikasjonssystem referanseklassifikasjonsSystem
  BevaringOgKassasjon bevaringOgKassasjon
  String periodeStatus
  static constraints = {
    referanseforelder( validator: {
      if(it.arkivstatus == "Opprettet") return true
      return "Kan ikke legge inn arkivdeler under et avsluttet arkiv."
    })
    arkivdelstatus(inList: ["Opprettet", "Avsluttet"])
    periodeStatus(inList: ["Aktiv periode", "Overlappingsperiode","Avsluttet periode"])
    tittel(nullable: false)
    tittel(unique: false)
    beskrivelse(nullable: true)
    beskrivelse(unique: false)
    arkivdelstatus(nullable: false)
    arkivdelstatus(unique: false)
    dokumentmedium(nullable: false)
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
    arkivperiodestartdato(nullable: true)
    arkivperiodestartdato(unique: false)
    arkivperiodesluttdato(nullable: true)
    arkivperiodesluttdato(unique: false)
    referanseforelder(nullable: false)
    referanseforelder(unique: false)
    referanseforløper(nullable: true)
    referanseforløper(unique: false)
    referansearvtaker(nullable: true)
    referansearvtaker(unique: false)
    referanseklassifikasjonsSystem(nullable: true)
    referanseklassifikasjonsSystem(unique: false)
    referansemappe(nullable: true)
    referansemappe(unique: false)
    referanseregistrering(nullable: true)
    referanseregistrering(unique: false)
    bevaringOgKassasjon(nullable: true)
    bevaringOgKassasjon(unique: false)
    periodeStatus(nullable: true)
    periodeStatus(unique: false)
  }
  static hasMany = [oppbevaringssted:String, referansemappe:Basismappe, referanseregistrering:ForenkletRegistrering]
  static mapping = {
  }
  static auditable = true
  static searchable = [except: ['referanseforelder']]
}
