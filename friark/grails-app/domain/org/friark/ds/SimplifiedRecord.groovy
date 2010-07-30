/**
Metadata for forenklet registrering
*/
package org.friark.ds
class SimplifiedRecord extends Base{
  String recordType
  Date createdDate
  String createdBy
  Date archivedDate
  String archivedBy
  BasicFile parentFile
  Klass parentClass
  Series recordSection
  PreservationAndDisposal preservationAndDisposal
  static constraints = {
    recordSection( validator: {
      if(it == null || it.finalisedDate == null) return true
      return "Kan ikke legge en registrering under en avsluttet arkivdel."
    })
    parentFile( validator: {
      if(it == null || it.finalisedDate == null) return true
      return "Kan ikke legge en registrering under en avsluttet mappe."
    })
    recordType(nullable: false)
    recordType(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    archivedDate(nullable: false)
    archivedDate(unique: false)
    archivedBy(nullable: false)
    archivedBy(unique: false)
    parentFile(nullable: true)
    parentFile(unique: false)
    parentClass(nullable: true)
    parentClass(unique: false)
    recordSection(nullable: true)
    recordSection(unique: false)
    document(nullable: true)
    document(unique: true)
    documentObject(nullable: true)
    documentObject(unique: true)
    preservationAndDisposal(nullable: true)
    preservationAndDisposal(unique: false)
  }
  static hasMany = [document:DocumentLink, documentObject:DocumentObject]
  static mapping = {
    tablePerHierarchy false
  }
  static auditable = true
  static searchable = [except: ['recordSection','parentFile']]
}
