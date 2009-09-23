/**
Metadata for administrasjonsstruktur¤¤¤¤¤
 ¤¤¤¤¤
Metadata for administrasjonsstruktur skal ikke avleves, men skal kunne migreres mellom systemer. Slik migrering kan omfatte flere metadata enn det som er listet opp her. ¤¤¤¤¤
 ¤¤¤¤¤

*/
class Administrasjonsstruktur {
  String administrativenhetnavn
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String administrativenhetsstatus
  String referanseoverordnetEnhet
  static constraints = {
    administrativenhetnavn(nullable: false)
    administrativenhetnavn(unique: true)
    opprettetdato(nullable: false)
    opprettetdato(unique: true)
    opprettetav(nullable: true)
    opprettetav(unique: true)
    avsluttetdato(nullable: true)
    avsluttetdato(unique: true)
    administrativenhetsstatus(nullable: true)
    administrativenhetsstatus(unique: true)
    referanseoverordnetEnhet(nullable: true)
    referanseoverordnetEnhet(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
