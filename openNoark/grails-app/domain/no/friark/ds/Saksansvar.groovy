/**
Metadata for saksansvar¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Journalpost¤¤¤¤¤
Forekomst:               1-M¤¤¤¤¤
 ¤¤¤¤¤
Ved organinterne dokumenter som skal følges opp, er det behov for å gruppere informasjon om saksansvar fordi denne  kan forekomme flere ganger. ¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Saksansvar {
  String administrativenhet
  String saksbehandler
  String journalenhet
  static constraints = {
    administrativenhet(nullable: false)
    administrativenhet(unique: true)
    saksbehandler(nullable: false)
    saksbehandler(unique: true)
    journalenhet(nullable: true)
    journalenhet(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
