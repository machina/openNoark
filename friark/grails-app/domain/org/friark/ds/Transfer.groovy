package org.friark.ds
/**
Metadata for avlevering amp;#xA; amp;#xA;Metadata for avlevering skal avleveres som en egen fil. amp;#xA;
*/
class Transfer {
  String responsibleExport
  Date exportedDate
  String numberOfFilesExported
  String numberOfRecordsExported
  String numberOfDocumentsExported
  String checksumMetadata
  String checksumTransfer
  String checksumAlgorithm
  static constraints = {
    responsibleExport(nullable: false)
    responsibleExport(unique: false)
    exportedDate(nullable: false)
    exportedDate(unique: false)
    numberOfFilesExported(nullable: false)
    numberOfFilesExported(unique: false)
    numberOfRecordsExported(nullable: false)
    numberOfRecordsExported(unique: false)
    numberOfDocumentsExported(nullable: false)
    numberOfDocumentsExported(unique: false)
    checksumMetadata(nullable: false)
    checksumMetadata(unique: false)
    checksumTransfer(nullable: false)
    checksumTransfer(unique: false)
    checksumAlgorithm(nullable: false)
    checksumAlgorithm(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
