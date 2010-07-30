/**
Metadata for korrespondansepart
<br/>
Grupperes inn i:	Journalpost
Forekomst:		1-M
*/
package org.friark.ds
class Client {
  String clientType
  String clientName
  String postalAddress
  String postCode
  String postalTown
  String foreignAddress
  String emailAddress
  String telephoneNumber
  String contactPerson
  RegistryEntry registryEntry
  static constraints = {
    clientType(nullable: false)
    clientType(unique: true)
    clientName(nullable: false)
    clientName(unique: true)
    postalAddress(nullable: true)
    postalAddress(unique: true)
    postCode(nullable: true)
    postCode(unique: true)
    postalTown(nullable: true)
    postalTown(unique: true)
    foreignAddress(nullable: true)
    foreignAddress(unique: true)
    emailAddress(nullable: true)
    emailAddress(unique: true)
    telephoneNumber(nullable: true)
    telephoneNumber(unique: true)
    contactPerson(nullable: true)
    contactPerson(unique: true)
    registryEntry(nullable: false)
    registryEntry(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
