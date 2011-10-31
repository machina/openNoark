package org.friark.ds
/**
Metadata for dokumentflyt amp;#xA;<br/> amp;#xA;Grupperes inn i: Journalpost amp;#xA;Forekomst:  0-M
*/
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
    flowRecivedDate(unique: false)
    flowSentDate(nullable: false)
    flowSentDate(unique: false)
    flowStatus(nullable: false)
    flowStatus(unique: false)
    flowRemark(nullable: true)
    flowRemark(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
