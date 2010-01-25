/**
Metadata for avlevering¤¤¤¤¤
 ¤¤¤¤¤
Metadata for avlevering skal avleveres som en egen fil.¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
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
    ansvarligeksport(unique: true)
    eksportertdato(nullable: false)
    eksportertdato(unique: true)
    antallmappereksportert(nullable: false)
    antallmappereksportert(unique: true)
    antallregistreringerEksportert(nullable: false)
    antallregistreringerEksportert(unique: true)
    antalldokumenterEksportert(nullable: false)
    antalldokumenterEksportert(unique: true)
    sjekksummetadata(nullable: false)
    sjekksummetadata(unique: true)
    sjekksumavlevering(nullable: false)
    sjekksumavlevering(unique: true)
    sjekksumalgoritme(nullable: false)
    sjekksumalgoritme(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
