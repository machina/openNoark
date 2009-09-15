class Dokumentbeskrivelse {
  String systemid
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
systemid(nullable: false)
dokumenttype(nullable: false)
dokumentstatus(nullable: false)
tittel(nullable: false)
beskrivelse(nullable: true)
forfatter(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
dokumentmedium(nullable: true)
oppbevaringssted(nullable: true)
referansedokumentObjekt(nullable: true)
}
static hasMany = [referansedokumentObjekt:Dokumentobjekt]
}
