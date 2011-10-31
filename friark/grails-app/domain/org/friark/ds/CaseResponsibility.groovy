package org.friark.ds
/**
Metadata for saksansvar amp;#xA;<br/> amp;#xA;Grupperes inn i: Journalpost<br/> amp;#xA;Forekomst:  1-M amp;#xA; amp;#xA;Ved organinterne dokumenter som skal følges opp, er det behov for å gruppere informasjon om saksansvar fordi denne  kan forekomme flere ganger. 
*/
class CaseResponsibility {
  String administrativeUnit
  String executiveOfficer
  String registryManagementUnit
  static constraints = {
    administrativeUnit(nullable: false)
    administrativeUnit(unique: false)
    executiveOfficer(nullable: false)
    executiveOfficer(unique: false)
    registryManagementUnit(nullable: true)
    registryManagementUnit(unique: false)
    registryEntry(nullable: true)
    registryEntry(unique: true)
  }
  static hasMany = [registryEntry:RegistryEntry]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
