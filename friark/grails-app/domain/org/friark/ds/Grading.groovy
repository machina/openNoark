package org.friark.ds
/**
Metadata for gradering amp;#xA;<br/> amp;#xA;Grupperes inn i: Basismappe, Forenklet registrering, Dokmentbeskrivelse. amp;#xA;Forekomst: 0-1
*/
class Grading {
  String grading
  Date gradingDate
  String gradingBy
  Date downGradingDate
  String downGradedBy
  static constraints = {
    grading(nullable: false)
    grading(unique: false)
    gradingDate(nullable: false)
    gradingDate(unique: false)
    gradingBy(nullable: false)
    gradingBy(unique: false)
    downGradingDate(nullable: true)
    downGradingDate(unique: false)
    downGradedBy(nullable: true)
    downGradedBy(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
