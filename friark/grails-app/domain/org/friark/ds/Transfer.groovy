/**
Metadata for avlevering

Metadata for avlevering skal avleveres som en egen fil.

*/
package org.friark.ds
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
    responsibleExport(unique: true)
    exportedDate(nullable: false)
    exportedDate(unique: true)
    numberOfFilesExported(nullable: false)
    numberOfFilesExported(unique: true)
    numberOfRecordsExported(nullable: false)
    numberOfRecordsExported(unique: true)
    numberOfDocumentsExported(nullable: false)
    numberOfDocumentsExported(unique: true)
    checksumMetadata(nullable: false)
    checksumMetadata(unique: true)
    checksumTransfer(nullable: false)
    checksumTransfer(unique: true)
    checksumAlgorithm(nullable: false)
    checksumAlgorithm(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
