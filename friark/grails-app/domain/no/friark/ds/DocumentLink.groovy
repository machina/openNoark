/**
Metadata for dokumentlink
<br/>
Grupperes inn i:	Dokumentbeskrivelse
Forekomst:		1
<br/>
Det skal opprettes en ny dokumentlink for hver gang et dokument knyttes til en registrering. 
*/
package no.friark.ds
class DocumentLink {
  SimplifiedRecord referenceRecord
  String linkedRecordAs
  String documentNumber
  Date linkedDate
  String linkedBy
  DocumentDescription documentDescription
  static constraints = {
    referenceRecord(nullable: false)
    referenceRecord(unique: false)
    linkedRecordAs(nullable: false)
    linkedRecordAs(unique: false)
    documentNumber(nullable: false)
    documentNumber(unique: false)
    linkedDate(nullable: false)
    linkedDate(unique: false)
    linkedBy(nullable: false)
    linkedBy(unique: false)
    documentDescription(nullable: true)
    documentDescription(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
