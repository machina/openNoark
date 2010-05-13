/**
Metadata for saksansvar
<br/>
Grupperes inn i:	Journalpost<br/>
Forekomst:		1-M

Ved organinterne dokumenter som skal følges opp, er det behov for å gruppere informasjon om saksansvar fordi denne  kan forekomme flere ganger. 
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
    journalpost(nullable: true)
    journalpost(unique: true)
  }
  static hasMany = [journalpost:Journalpost]
  static mapping = {
  }
}
