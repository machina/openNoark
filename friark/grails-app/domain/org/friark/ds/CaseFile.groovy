package org.friark.ds
/**
Metadata for saksmappe amp;#xA; amp;#xA;Metadata for basismappe inngår i saksmappe, følgende metadata kommer i tillegg.
*/
class CaseFile extends BasicFile{
  Date caseDate
  String administrativeUnit
  String caseResponsible
  String registryManagementUnit
  String caseStatus
  Date loanedDate
  String loanedTo
  Precedent precedent
  static constraints = {
    caseDate(nullable: false)
    caseDate(unique: false)
    administrativeUnit(nullable: false)
    administrativeUnit(unique: false)
    caseResponsible(nullable: false)
    caseResponsible(unique: false)
    registryManagementUnit(nullable: true)
    registryManagementUnit(unique: false)
    caseStatus(nullable: false)
    caseStatus(unique: false)
    loanedDate(nullable: true)
    loanedDate(unique: false)
    loanedTo(nullable: true)
    loanedTo(unique: false)
    secondaryClassification(nullable: true)
    secondaryClassification(unique: true)
    precedent(nullable: true)
    precedent(unique: false)
  }
  static hasMany = [secondaryClassification:Klass]
  static mapping = {
  }
  static searchable = false
  static loggable = false
  static belongsTo = Klass
}
