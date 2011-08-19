/**
Metadata for verifisering av elektronisk signatur
<br/>
Grupperes inn i:	Journalpost<br/>
Forekomst:		0-1
*/
package org.friark.ds
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
}
