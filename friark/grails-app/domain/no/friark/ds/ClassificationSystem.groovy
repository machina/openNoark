/**
Metadata for klassifikasjonssystem
*/
package no.friark.ds
class ClassificationSystem extends Base{
  String classificationType
  String title
  String description
  Date createdDate
  String createdBy
  Date finalisedDate
  String finalisedBy
  static constraints = {
    classificationType(nullable: true)
    classificationType(unique: false)
    title(nullable: false)
    title(unique: false)
    description(nullable: true)
    description(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    finalisedDate(nullable: true)
    finalisedDate(unique: false)
    finalisedBy(nullable: true)
    finalisedBy(unique: false)
    child(nullable: true)
    child(unique: true)
  }
  static hasMany = [child:Klass]
  static mapping = {
  }
  static searchable = true
  static auditable = true
  String toString(){"${tittel}"}
}
