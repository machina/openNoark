/**
Metadata for journalpost

Metadata for basisregistrering inngår i journalpost, følgende metadata kommer i tillegg.
*/
package org.friark.ds
class RegistryEntry extends BasicRecord{
  String serialNumber
  String registryEntryType
  String recordStatus
  Date registryDate
  Date documentDate
  Date recivedDate
  Date sentDate
  Date dueDate
  Date confidentialityAssessedDate
  String numberOfAppendicies
  Date loanedDate
  String loanedTo
  CaseResponsibility caseResponsibility
  static constraints = {
    serialNumber(nullable: false)
    serialNumber(unique: true)
    registryEntryType(nullable: false)
    registryEntryType(unique: true)
    recordStatus(nullable: false)
    recordStatus(unique: true)
    registryDate(nullable: false)
    registryDate(unique: true)
    documentDate(nullable: true)
    documentDate(unique: true)
    recivedDate(nullable: true)
    recivedDate(unique: true)
    sentDate(nullable: true)
    sentDate(unique: true)
    dueDate(nullable: true)
    dueDate(unique: true)
    confidentialityAssessedDate(nullable: true)
    confidentialityAssessedDate(unique: true)
    numberOfAppendicies(nullable: true)
    numberOfAppendicies(unique: true)
    loanedDate(nullable: true)
    loanedDate(unique: true)
    loanedTo(nullable: true)
    loanedTo(unique: true)
    clients(minSize: 1)
    clients(unique: true)
    caseResponsibility(nullable: false)
    caseResponsibility(unique: false)
  }
  static hasMany = [clients:Client]
  static mapping = {
  }
}
