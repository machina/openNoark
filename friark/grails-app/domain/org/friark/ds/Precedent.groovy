/**
Metadata for presedens
<br/>
Grupperes inn i:	Saksmappe, Journalpost<br/>
Forekomst:		0-M
*/
package org.friark.ds
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
    precedentDate(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    title(nullable: false)
    title(unique: true)
    description(nullable: true)
    description(unique: false)
    precedentAuthority(nullable: true)
    precedentAuthority(unique: false)
    leagalSourceFactor(nullable: false)
    leagalSourceFactor(unique: false)
    precedentApprovedDate(nullable: true)
    precedentApprovedDate(unique: false)
    precedentApprovedBy(nullable: true)
    precedentApprovedBy(unique: false)
    finalisedDate(nullable: true)
    finalisedDate(unique: false)
    finalisedBy(nullable: true)
    finalisedBy(unique: false)
    precedentStatus(nullable: true)
    precedentStatus(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
