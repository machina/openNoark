/**
Metadata for avskrivning

Grupperes inn i:	Journalpost
Forekomst:		0-M
.Avskrivning er obligatorisk for inngående dokumenter og organinterne dokumenter som skal følges opp.

*/
package org.friark.ds
class SignOff {
  Date signOffDate
  String signedOffBy
  String signOffMethod
  SimplifiedRecord signOffsRegistryEntry
  SimplifiedRecord signOffedByRegistryEntry
  static constraints = {
    signOffDate(nullable: false)
    signOffDate(unique: false)
    signedOffBy(nullable: false)
    signedOffBy(unique: false)
    signOffMethod(nullable: false)
    signOffMethod(unique: false)
    signOffsRegistryEntry(nullable: true)
    signOffsRegistryEntry(unique: true)
    signOffedByRegistryEntry(nullable: true)
    signOffedByRegistryEntry(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
