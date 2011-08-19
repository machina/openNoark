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
}
