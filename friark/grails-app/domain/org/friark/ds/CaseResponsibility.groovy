/**
Metadata for saksansvar
<br/>
Grupperes inn i:	Journalpost<br/>
Forekomst:		1-M

Ved organinterne dokumenter som skal følges opp, er det behov for å gruppere informasjon om saksansvar fordi denne  kan forekomme flere ganger. 
*/
package org.friark.ds
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
}
