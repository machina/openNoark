/**
Metadata for dokumentflyt
<br/>
Grupperes inn i:	Journalpost
Forekomst:		0-M
*/
package no.friark.ds
class DocumentFlow {
  String flowTo
  String flowFrom
  Date flowRecivedDate
  Date flowSentDate
  String flowStatus
  String flowRemark
  static constraints = {
    flowTo(nullable: false)
    flowTo(unique: true)
    flowFrom(nullable: false)
    flowFrom(unique: true)
    flowRecivedDate(nullable: false)
    flowRecivedDate(unique: true)
    flowSentDate(nullable: false)
    flowSentDate(unique: true)
    flowStatus(nullable: false)
    flowStatus(unique: true)
    flowRemark(nullable: true)
    flowRemark(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
