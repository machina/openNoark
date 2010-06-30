/**
Metadata for dokumentbeskrivelse

En dokumentbeskrivelse kan være knyttet til mer enn en registrering, og ved avlevering vil metadata bli duplisert for hver tilknytning. Referansen til registreringen finnes i objektet dokumentlink nedenfor. 

*/
package no.friark.ds
class DocumentDescription extends Base{
  String documentType
  String documentStatus
  String title
  String description
  String author
  Date createdDate
  String createdBy
  String documentMedium
  String storageLocation
  PreservationAndDisposal preservationAndDisposal
  Date disposalDate
  String disposedBy
  static constraints = {
    documentType(nullable: false)
    documentType(unique: false)
    documentStatus(nullable: false)
    documentStatus(unique: false)
    title(nullable: false)
    title(unique: false)
    description(nullable: true)
    description(unique: false)
    author(nullable: true)
    author(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    documentMedium(nullable: true)
    documentMedium(unique: false)
    storageLocation(nullable: true)
    storageLocation(unique: false)
    documentObject(nullable: true)
    documentObject(unique: true)
    preservationAndDisposal(nullable: true)
    preservationAndDisposal(unique: false)
    remark(nullable: true)
    remark(unique: false)
    records(nullable: true)
    records(unique: true)
    disposalDate(nullable: true)
    disposalDate(unique: false)
    disposedBy(nullable: true)
    disposedBy(unique: false)
  }
  static hasMany = [documentObject:DocumentObject, remark:Remark, records:DocumentLink]
  static mapping = {
  }
  static searchable = true
  static auditable = true
}
