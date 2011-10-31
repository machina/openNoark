package org.friark.ds
/**
Metadata for journalpost amp;#xA; amp;#xA;Metadata for basisregistrering inngår i journalpost, følgende metadata kommer i tillegg.
*/
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
    registryEntryType(unique: false)
    recordStatus(nullable: false)
    recordStatus(unique: false)
    registryDate(nullable: false)
    registryDate(unique: false)
    documentDate(nullable: true)
    documentDate(unique: false)
    recivedDate(nullable: true)
    recivedDate(unique: false)
    sentDate(nullable: true)
    sentDate(unique: false)
    dueDate(nullable: true)
    dueDate(unique: false)
    confidentialityAssessedDate(nullable: true)
    confidentialityAssessedDate(unique: false)
    numberOfAppendicies(nullable: true)
    numberOfAppendicies(unique: false)
    loanedDate(nullable: true)
    loanedDate(unique: false)
    loanedTo(nullable: true)
    loanedTo(unique: false)
    clients(minSize: 1)
    clients(unique: false)
    caseResponsibility(nullable: false)
    caseResponsibility(unique: false)
  }
  static hasMany = [clients:Client]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
