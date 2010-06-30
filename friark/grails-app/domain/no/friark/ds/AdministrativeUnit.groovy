/**
Metadata for administrasjonsstruktur

Metadata for administrasjonsstruktur skal ikke avleves, men skal kunne migreres mellom systemer. Slik migrering kan omfatte flere metadata enn det som er listet opp her. 


*/
package no.friark.ds
class AdministrativeUnit {
  String administrativeUnitName
  Date createdDate
  String createdBy
  Date finalisedDate
  String administrativeUnitStatus
  String generalUnit
  static constraints = {
    administrativeUnitName(nullable: false)
    administrativeUnitName(unique: true)
    createdDate(nullable: false)
    createdDate(unique: true)
    createdBy(nullable: true)
    createdBy(unique: true)
    finalisedDate(nullable: true)
    finalisedDate(unique: true)
    administrativeUnitStatus(nullable: true)
    administrativeUnitStatus(unique: true)
    generalUnit(nullable: true)
    generalUnit(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
