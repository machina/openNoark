package org.friark.ds
/**
Metadata for verifisering av elektronisk signatur amp;#xA;<br/> amp;#xA;Grupperes inn i: Journalpost<br/> amp;#xA;Forekomst:  0-1
*/
class VerificationOfElectronicSignature {
  String electronicSignatureSecurityLevel
  String electronicSignatureVerified
  Date verifiedDate
  String verifiedBy
  static constraints = {
    electronicSignatureSecurityLevel(nullable: false)
    electronicSignatureSecurityLevel(unique: false)
    electronicSignatureVerified(nullable: false)
    electronicSignatureVerified(unique: false)
    verifiedDate(nullable: false)
    verifiedDate(unique: false)
    verifiedBy(nullable: false)
    verifiedBy(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
