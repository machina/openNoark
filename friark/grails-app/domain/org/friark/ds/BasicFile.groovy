/**
Metadata for basismappe
*/
package org.friark.ds
class BasicFile extends Base{
  String fileID
  String fileType
  String title
  String officialTitle
  String description
  String documentMedium
  Date createdDate
  String createdBy
  Date finalisedDate
  String finalisedBy
  Klass parentClass
  BasicFile parentFile
  Series recordSection
  PreservationAndDisposal bevaringOgKassasjon
  static constraints = {
    recordSection( validator: {
      if(it == null || it.finalisedDate == null) return true
      return "Kan ikke legge en mappe under en avsluttet arkivdel."
    })
    fileID(nullable: false)
    fileID(unique: true)
    fileType(nullable: false)
    fileType(unique: false)
    title(nullable: false)
    title(unique: false)
    officialTitle(nullable: true)
    officialTitle(unique: false)
    description(nullable: true)
    description(unique: false)
    keyword(nullable: true)
    keyword(unique: false)
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
    parentClass(nullable: true)
    parentClass(unique: false)
    parentFile(nullable: true)
    parentFile(unique: false)
    childRecord(nullable: true)
    childRecord(unique: true)
    childFile(nullable: true)
    childFile(unique: true)
    recordSection(nullable: false)
    recordSection(unique: false)
    bevaringOgKassasjon(nullable: true)
    bevaringOgKassasjon(unique: false)
    merknad(nullable: true)
    merknad(unique: false)
  }
  static hasMany = [keyword:String, storageLocation:String, childRecord:SimplifiedRecord, childFile:BasicFile, merknad:Remark]
  static mapping = {
    tablePerHierarchy false
  }
  static auditable = true
  static searchable = [except: ['recordSection']]
}
