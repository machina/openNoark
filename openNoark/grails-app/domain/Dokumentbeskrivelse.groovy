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
    dokumenttype(unique: true)
    dokumentstatus(nullable: false)
    dokumentstatus(unique: true)
    tittel(nullable: false)
    tittel(unique: true)
    beskrivelse(nullable: true)
    beskrivelse(unique: true)
    forfatter(nullable: true)
    forfatter(unique: true)
    opprettetdato(nullable: false)
    opprettetdato(unique: true)
    opprettetav(nullable: false)
    opprettetav(unique: true)
    dokumentmedium(nullable: true)
    dokumentmedium(unique: true)
    oppbevaringssted(nullable: true)
    oppbevaringssted(unique: true)
    referansedokumentObjekt(nullable: true)
    referansedokumentObjekt(unique: true)
  }
  static hasMany = [referansedokumentObjekt:Dokumentobjekt]
  static mapping = {
  }
  static searchable = true
  static auditable = true
}
