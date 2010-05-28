/**
Metadata for arkiv
*/
package no.friark.ds
class Fonds extends Base{
  String title
  String description
  String fondsStatus
  String documentMedium
  Date createdDate
  String createdBy
  Date finalisedDate
  String finalisedBy
  Fonds parent
  static constraints = {
    fondsStatus(inList: ["Opprettet", "Avsluttet"])
    title(nullable: false)
    title(unique: false)
    description(nullable: true)
    description(unique: false)
    fondsStatus(nullable: true)
    fondsStatus(unique: false)
    documentMedium(nullable: true)
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
    parent(nullable: true)
    parent(unique: false)
    referenceChildSeries(nullable: true)
    referenceChildSeries(unique: true)
    subFonds(nullable: true)
    subFonds(unique: true)
    fondsCreator(nullable: true)
    fondsCreator(unique: false)
  }
  static hasMany = [storageLocation:String, referenceChildSeries:Series, subFonds:Fonds, fondsCreator:FondsCreator]
  static mapping = {
  }
  static auditable = true
  static searchable = true
  static belongsTo = FondsCreator
}
