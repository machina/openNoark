/**
Metadata for presedens
<br/>
Grupperes inn i:	Saksmappe, Journalpost<br/>
Forekomst:		0-M
*/
package no.friark.ds
class Precedent {
  Date precedentDate
  Date createdDate
  String createdBy
  String title
  String description
  String precedentAuthority
  String leagalSourceFactor
  Date precedentApprovedDate
  String precedentApprovedBy
  Date finalisedDate
  String finalisedBy
  String precedentStatus
  static constraints = {
    precedentDate(nullable: false)
    precedentDate(unique: true)
    createdDate(nullable: false)
    createdDate(unique: true)
    createdBy(nullable: false)
    createdBy(unique: true)
    title(nullable: false)
    title(unique: true)
    description(nullable: true)
    description(unique: true)
    precedentAuthority(nullable: true)
    precedentAuthority(unique: true)
    leagalSourceFactor(nullable: false)
    leagalSourceFactor(unique: true)
    precedentApprovedDate(nullable: true)
    precedentApprovedDate(unique: true)
    precedentApprovedBy(nullable: true)
    precedentApprovedBy(unique: true)
    finalisedDate(nullable: true)
    finalisedDate(unique: true)
    finalisedBy(nullable: true)
    finalisedBy(unique: true)
    precedentStatus(nullable: true)
    precedentStatus(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
