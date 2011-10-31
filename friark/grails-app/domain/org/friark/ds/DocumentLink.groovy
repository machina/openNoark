package org.friark.ds
/**
Metadata for dokumentlink amp;#xA;<br/> amp;#xA;Grupperes inn i: Dokumentbeskrivelse amp;#xA;Forekomst:  1 amp;#xA;<br/> amp;#xA;Det skal opprettes en ny dokumentlink for hver gang et dokument knyttes til en registrering. 
*/
class DocumentLink {
  String linkedRecordAs
  String documentNumber
  Date linkedDate
  String linkedBy
  SimplifiedRecord referenceRecord
  DocumentDescription documentDescription
  static constraints = {
    linkedRecordAs(nullable: false)
    linkedRecordAs(unique: false)
    documentNumber(nullable: false)
    documentNumber(unique: false)
    linkedDate(nullable: false)
    linkedDate(unique: false)
    linkedBy(nullable: false)
    linkedBy(unique: false)
    referenceRecord(nullable: false)
    referenceRecord(unique: false)
    documentDescription(nullable: true)
    documentDescription(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
