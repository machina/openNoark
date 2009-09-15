class Avlevering {
  String ansvarligeksport
  Date eksportertdato
  String antallmappereksportert
  String antallregistreringerEksportert
  String antalldokumenterEksportert
  String sjekksummetadata
  String sjekksumavlevering
  String sjekksumalgoritme
static constraints = {
ansvarligeksport(nullable: false)
eksportertdato(nullable: false)
antallmappereksportert(nullable: false)
antallregistreringerEksportert(nullable: false)
antalldokumenterEksportert(nullable: false)
sjekksummetadata(nullable: false)
sjekksumavlevering(nullable: false)
sjekksumalgoritme(nullable: false)
}
static hasMany = [:]
}
