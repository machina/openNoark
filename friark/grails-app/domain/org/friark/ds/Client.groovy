package org.friark.ds
/**
Metadata for korrespondansepart amp;#xA;<br/> amp;#xA;Grupperes inn i: Journalpost amp;#xA;Forekomst:  1-M
*/
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
    clientType(unique: false)
    clientName(nullable: false)
    clientName(unique: true)
    postalAddress(nullable: true)
    postalAddress(unique: false)
    postCode(nullable: true)
    postCode(unique: false)
    postalTown(nullable: true)
    postalTown(unique: false)
    foreignAddress(nullable: true)
    foreignAddress(unique: false)
    emailAddress(nullable: true)
    emailAddress(unique: false)
    telephoneNumber(nullable: true)
    telephoneNumber(unique: false)
    contactPerson(nullable: true)
    contactPerson(unique: false)
    registryEntry(nullable: false)
    registryEntry(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
