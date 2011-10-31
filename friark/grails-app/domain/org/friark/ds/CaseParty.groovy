package org.friark.ds
/**
Metadata for sakspart amp;#xA;<br/> amp;#xA;Grupperes inn i: Saksmappe<br/> amp;#xA;Forekomst:  0-M amp;#xA; amp;#xA;
*/
class CaseParty {
  String casePartyID
  String casePartyName
  String casePartyRole
  String postalAddress
  String postCode
  String postalTown
  String foreignAddress
  String emailAddress
  String telephoneNumber
  String contactPerson
  static constraints = {
    casePartyID(nullable: true)
    casePartyID(unique: true)
    casePartyName(nullable: false)
    casePartyName(unique: false)
    casePartyRole(nullable: false)
    casePartyRole(unique: false)
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
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
