/**
Metadata for merknad
<br/>
Grupperes inn i:	Basismappe, Basisregistrering, Dokumentbeskrivelse
Forekomst:		0-M

*/
package no.friark.ds
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
    remarkText(unique: true)
    remarkDate(nullable: false)
    remarkDate(unique: true)
    remarkRegisteredBy(nullable: false)
    remarkRegisteredBy(unique: true)
    basicFile(nullable: true)
    basicFile(unique: false)
    basicRecord(nullable: true)
    basicRecord(unique: false)
    documentDescription(nullable: true)
    documentDescription(unique: false)
    remarkType(nullable: false)
    remarkType(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
