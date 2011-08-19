/**
Metadata for basisregistrering

Metadata for forenkletRegistrering inngår i basisregistrering, følgende metadata kommer i tillegg.
*/
package org.friark.ds
class BasicRecord extends SimplifiedRecord{
  String recordID
  String title
  String officialTitle
  String description
  String documentMedium
  static constraints = {
    recordID(nullable: false)
    recordID(unique: true)
    title(nullable: false)
    title(unique: true)
    officialTitle(nullable: true)
    officialTitle(unique: true)
    description(nullable: true)
    description(unique: false)
    keyword(nullable: true)
    keyword(unique: false)
    author(nullable: true)
    author(unique: false)
    documentMedium(nullable: true)
    documentMedium(unique: false)
    storageLocation(nullable: true)
    storageLocation(unique: false)
    merknad(nullable: true)
    merknad(unique: false)
  }
  static hasMany = [keyword:String, author:String, storageLocation:String, merknad:Remark]
  static mapping = {
    tablePerHierarchy false
  }
}
