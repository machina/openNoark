/**
Metadata for verifisering av elektronisk signatur¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Journalpost¤¤¤¤¤
Forekomst:               0-1¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class VerifiseringAvElektroniskSignatur {
  String elektronisksignaturSikkerhetsnivå
  String elektronisksignaturVerfisert
  Date verifisertdato
  String verfisertav
  static constraints = {
    elektronisksignaturSikkerhetsnivå(nullable: false)
    elektronisksignaturSikkerhetsnivå(unique: true)
    elektronisksignaturVerfisert(nullable: false)
    elektronisksignaturVerfisert(unique: true)
    verifisertdato(nullable: false)
    verifisertdato(unique: true)
    verfisertav(nullable: false)
    verfisertav(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
