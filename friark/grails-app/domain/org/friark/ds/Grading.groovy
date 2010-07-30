/**
Metadata for gradering
<br/>
Grupperes inn i:	Basismappe, Forenklet registrering, Dokmentbeskrivelse.
Forekomst:	0-1
*/
package org.friark.ds
class Grading {
  String grading
  Date gradingDate
  String gradingBy
  Date downGradingDate
  String downGradedBy
  static constraints = {
    grading(nullable: false)
    grading(unique: true)
    gradingDate(nullable: false)
    gradingDate(unique: true)
    gradingBy(nullable: false)
    gradingBy(unique: true)
    downGradingDate(nullable: true)
    downGradingDate(unique: true)
    downGradedBy(nullable: true)
    downGradedBy(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
