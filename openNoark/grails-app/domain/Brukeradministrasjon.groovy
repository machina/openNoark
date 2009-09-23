/**
Metadata for brukeradministrasjon¤¤¤¤¤
 ¤¤¤¤¤
Metadata for brukeradministrasjon skal ikke avleveres, men skal kunne migreres mellom systemer. Slik migrering kan omfatte flere metadata en det som er listet opp her.¤¤¤¤¤
 ¤¤¤¤¤
 ¤¤¤¤¤

*/
class Brukeradministrasjon {
  String brukernavn
  String brukerrolle
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String brukerstatus
  static constraints = {
    brukernavn(nullable: false)
    brukernavn(unique: true)
    brukerrolle(nullable: false)
    brukerrolle(unique: true)
    opprettetdato(nullable: false)
    opprettetdato(unique: true)
    opprettetav(nullable: true)
    opprettetav(unique: true)
    avsluttetdato(nullable: true)
    avsluttetdato(unique: true)
    brukerstatus(nullable: true)
    brukerstatus(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
