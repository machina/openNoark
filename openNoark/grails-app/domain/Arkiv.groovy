/**
Metadata for arkiv¤¤¤¤¤
 ¤¤¤¤¤

*/
class Arkiv extends Base{
  String tittel
  String beskrivelse
  String arkivstatus
  String dokumentmedium
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Arkiv forelder
  static constraints = {
    tittel(nullable: false)
    tittel(unique: false)
    beskrivelse(nullable: true)
    beskrivelse(unique: false)
    arkivstatus(nullable: true)
    arkivstatus(unique: false)
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
    forelder(nullable: true)
    forelder(unique: false)
    referansebarnArkivdel(nullable: true)
    referansebarnArkivdel(unique: false)
    subArkiv(nullable: true)
    subArkiv(unique: false)
  }
  static hasMany = [oppbevaringssted:String, referansebarnArkivdel:Arkivdel, subArkiv:Arkiv]
  static mapping = {
  }
  static auditable = true
}
