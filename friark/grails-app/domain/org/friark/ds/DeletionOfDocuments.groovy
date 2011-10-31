package org.friark.ds
/**
Metadata for sletting av dokumenter amp;#xA;<br/> amp;#xA;Grupperes inn i: Arkivdel, dokumentbeskrivelse amp;#xA;Forekomst:  0-M amp;#xA; amp;#xA;Ved sletting av tidligere versjoner (siste versjon kan ikke slettes), produksjonsformat og varianter skal metadata grupperes inn i dokumentbeskrivelse. De tilhørende dokumentobjekter skal da slettes. amp;#xA; amp;#xA;Ved sletting av innholdet i en arkivdel (som ikke har bevaringsverdi), skal alle mapper og underordnede arkivenheter som tilhørere arkivdelen slettes. 
*/
class DeletionOfDocuments {
  String deletionType
  Date deletedDate
  String deletedBy
  static constraints = {
    deletionType(nullable: false)
    deletionType(unique: false)
    deletedDate(nullable: false)
    deletedDate(unique: false)
    deletedBy(nullable: false)
    deletedBy(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
