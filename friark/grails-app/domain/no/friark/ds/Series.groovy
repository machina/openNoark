/**
Metadata for arkivdel
*/
package no.friark.ds
class Series extends Base{
  String title
  String description
  String recordSectionStatus
  String documentMedium
  Date createdDate
  String createdBy
  Date finalisedDate
  String finalisedBy
  Date recordsPeriodStartDate
  Date recordsPeriodEndDate
  Fonds parent
  Series precursor
  Series successor
  ClassificationSystem classificationSystem
  PreservationAndDisposal preservationAndDisposal
  String periodStatus
  static constraints = {
    parent( validator: {
      if(it.fondsStatus == "Opprettet") return true
      return "Kan ikke legge inn arkivdeler under et avsluttet arkiv."
    })
    recordSectionStatus(inList: ["Opprettet", "Avsluttet"])
    periodStatus(inList: ["Aktiv periode", "Overlappingsperiode","Avsluttet periode"])
    title(nullable: false)
    title(unique: false)
    description(nullable: true)
    description(unique: false)
    recordSectionStatus(nullable: false)
    recordSectionStatus(unique: false)
    documentMedium(nullable: false)
    documentMedium(unique: false)
    storageLocation(nullable: true)
    storageLocation(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    finalisedDate(nullable: true)
    finalisedDate(unique: false)
    finalisedBy(nullable: true)
    finalisedBy(unique: false)
    recordsPeriodStartDate(nullable: true)
    recordsPeriodStartDate(unique: false)
    recordsPeriodEndDate(nullable: true)
    recordsPeriodEndDate(unique: false)
    parent(nullable: false)
    parent(unique: false)
    precursor(nullable: true)
    precursor(unique: false)
    successor(nullable: true)
    successor(unique: false)
    classificationSystem(nullable: true)
    classificationSystem(unique: false)
    file(nullable: true)
    file(unique: true)
    record(nullable: true)
    record(unique: true)
    preservationAndDisposal(nullable: true)
    preservationAndDisposal(unique: false)
    periodStatus(nullable: true)
    periodStatus(unique: false)
  }
  static hasMany = [storageLocation:String, file:BasicFile, record:SimplifiedRecord]
  static mapping = {
  }
  static auditable = true
  static searchable = [except: ['parent','classificationSystem']]
}
