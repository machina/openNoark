/**
Metadata for sletting av dokumenter
<br/>
Grupperes inn i:	Arkivdel, dokumentbeskrivelse
Forekomst:		0-M

Ved sletting av tidligere versjoner (siste versjon kan ikke slettes), produksjonsformat og varianter skal metadata grupperes inn i dokumentbeskrivelse. De tilhørende dokumentobjekter skal da slettes.

Ved sletting av innholdet i en arkivdel (som ikke har bevaringsverdi), skal alle mapper og underordnede arkivenheter som tilhørere arkivdelen slettes. 
*/
package no.friark.ds
class DeletionOfDocuments {
  String deletionType
  Date deletedDate
  String deletedBy
  static constraints = {
    deletionType(nullable: false)
    deletionType(unique: true)
    deletedDate(nullable: false)
    deletedDate(unique: true)
    deletedBy(nullable: false)
    deletedBy(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
