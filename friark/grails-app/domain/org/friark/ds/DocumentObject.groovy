/**
Metadata for dokumentobjekt
*/
package org.friark.ds
class DocumentObject extends Base{
  String versionNumber
  String variantFormat
  String format
  String formatDetails
  Date createdDate
  String createdBy
  DocumentDescription documentDescription
  SimplifiedRecord record
  String documentFile
  String checksum
  String checksumAlgorithm
  String fileSize
  static constraints = {
    documentDescription( validator: { val, obj ->
      if(obj.documentDescription == null && obj.record == null) return "Dokumentobjekt må være tilknyttet enten et dokumentobjekt eller en registrering."
      if(obj.documentDescription != null && obj.record != null) return "Dokumentobjekt må være tilknyttet enten et dokumentobjekt eller en registrering."
      return true
    })
    versionNumber(nullable: false)
    versionNumber(unique: false)
    variantFormat(nullable: false)
    variantFormat(unique: false)
    format(nullable: false)
    format(unique: false)
    formatDetails(nullable: true)
    formatDetails(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    documentDescription(nullable: true)
    documentDescription(unique: false)
    record(nullable: true)
    record(unique: false)
    documentFile(nullable: true)
    documentFile(unique: false)
    checksum(nullable: true)
    checksum(unique: false)
    checksumAlgorithm(nullable: true)
    checksumAlgorithm(unique: false)
    fileSize(nullable: true)
    fileSize(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
