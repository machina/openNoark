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
    electronicSignatureSecurityLevel(unique: true)
    electronicSignatureVerified(nullable: false)
    electronicSignatureVerified(unique: true)
    verifiedDate(nullable: false)
    verifiedDate(unique: true)
    verifiedBy(nullable: false)
    verifiedBy(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
