package org.friark.ds
/**
Metadata for avskrivning amp;#xA; amp;#xA;Grupperes inn i: Journalpost amp;#xA;Forekomst:  0-M amp;#xA;.Avskrivning er obligatorisk for inngående dokumenter og organinterne dokumenter som skal følges opp. amp;#xA;
*/
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
  static searchable = false
  static loggable = false
}
