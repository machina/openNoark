package org.friark.ds
/**
Metadata for saksfordeling amp;#xA;<br/> amp;#xA;Grupperes inn i: Saksmappe, journalpost amp;#xA;Forekomst:  0-M
*/
class CaseDistribution {
  String distributedTo
  String distributedBy
  String distributedDate
  static constraints = {
    distributedTo(nullable: false)
    distributedTo(unique: false)
    distributedBy(nullable: false)
    distributedBy(unique: false)
    distributedDate(nullable: false)
    distributedDate(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
