/**
Metadata for sakspart
<br/>
Grupperes inn i:	Saksmappe<br/>
Forekomst:		0-M


*/
package org.friark.ds
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
    casePartyName(unique: true)
    casePartyRole(nullable: false)
    casePartyRole(unique: true)
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
  }
  static hasMany = [:]
  static mapping = {
  }
}
