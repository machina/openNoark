/**
Metadata for saksmappe

Metadata for basismappe inngår i saksmappe, følgende metadata kommer i tillegg.
*/
package no.friark.ds
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
  static belongsTo = Klass
}
