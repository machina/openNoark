/**
Metadata for klasse
*/
package no.friark.ds
class Klass extends Base{
  String classID
  String title
  String description
  Date createdDate
  String createdBy
  Date finalisedDate
  String finalisedBy
  ClassificationSystem parentClassificationSystem
  Klass parentClass
  PreservationAndDisposal preservationAndDisposal
  Screening screening
  static constraints = {
    classID(nullable: false)
    classID(unique: false)
    title(nullable: false)
    title(unique: false)
    description(nullable: true)
    description(unique: false)
    keyword(nullable: true)
    keyword(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: false)
    createdBy(unique: false)
    finalisedDate(nullable: true)
    finalisedDate(unique: false)
    finalisedBy(nullable: true)
    finalisedBy(unique: false)
    parentClassificationSystem(nullable: false)
    parentClassificationSystem(unique: false)
    parentClass(nullable: true)
    parentClass(unique: false)
    childClass(nullable: true)
    childClass(unique: true)
    childFile(nullable: true)
    childFile(unique: true)
    childRecord(nullable: true)
    childRecord(unique: true)
    preservationAndDisposal(nullable: true)
    preservationAndDisposal(unique: false)
    screening(nullable: true)
    screening(unique: true)
  }
  static hasMany = [keyword:String, childClass:Klass, childFile:BasicFile, childRecord:SimplifiedRecord]
  static mapping = {
  }
  String fullId
  static auditable = true
  static transients = ["fullId"]
  def afterLoad = {
    if(parentClass){
    	fullId = "${parentClass.classID}.${classID}"
    }else{
    	fullId = "${classID}"
    }
    println "fullId: ${fullId}"
  }
  String toString(){"Klasse : ${fullId}"}
}
