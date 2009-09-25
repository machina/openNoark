/**
Metadata for dokumentbeskrivelse¤¤¤¤¤
 ¤¤¤¤¤
En dokumentbeskrivelse kan være knyttet til mer enn en registrering, og ved avlevering vil metadata bli duplisert for hver tilknytning. Referansen til registreringen finnes i objektet dokumentlink nedenfor. ¤¤¤¤¤
 ¤¤¤¤¤

*/
class Dokumentbeskrivelse extends Base{
  String dokumenttype
  String dokumentstatus
  String tittel
  String beskrivelse
  String forfatter
  Date opprettetdato
  String opprettetav
  String dokumentmedium
  String oppbevaringssted
  static constraints = {
    dokumenttype(nullable: false)
    dokumenttype(unique: false)
    dokumentstatus(nullable: false)
    dokumentstatus(unique: false)
    tittel(nullable: false)
    tittel(unique: false)
    beskrivelse(nullable: true)
    beskrivelse(unique: false)
    forfatter(nullable: true)
    forfatter(unique: false)
    opprettetdato(nullable: false)
    opprettetdato(unique: false)
    opprettetav(nullable: false)
    opprettetav(unique: false)
    dokumentmedium(nullable: true)
    dokumentmedium(unique: false)
    oppbevaringssted(nullable: true)
    oppbevaringssted(unique: false)
    referansedokumentObjekt(nullable: true)
    referansedokumentObjekt(unique: false)
  }
  static hasMany = [referansedokumentObjekt:Dokumentobjekt]
  static mapping = {
  }
  static searchable = true
  static auditable = true
}
