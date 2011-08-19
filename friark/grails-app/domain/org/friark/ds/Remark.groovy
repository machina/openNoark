/**
Metadata for merknad
<br/>
Grupperes inn i:	Basismappe, Basisregistrering, Dokumentbeskrivelse
Forekomst:		0-M

*/
package org.friark.ds
class Remark {
  String remarkText
  Date remarkDate
  String remarkRegisteredBy
  BasicFile basicFile
  BasicRecord basicRecord
  DocumentDescription documentDescription
  RemarkType remarkType
  static constraints = {
    remarkText(nullable: false)
    remarkText(unique: false)
    remarkDate(nullable: false)
    remarkDate(unique: false)
    remarkRegisteredBy(nullable: false)
    remarkRegisteredBy(unique: false)
    basicFile(nullable: true)
    basicFile(unique: false)
    basicRecord(nullable: true)
    basicRecord(unique: false)
    documentDescription(nullable: true)
    documentDescription(unique: false)
    remarkType(nullable: false)
    remarkType(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
