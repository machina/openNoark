/**
Metadata for saksfordeling
<br/>
Grupperes inn i:	Saksmappe, journalpost
Forekomst:		0-M
*/
package org.friark.ds
class CaseDistribution {
  String distributedTo
  String distributedBy
  String distributedDate
  static constraints = {
    distributedTo(nullable: false)
    distributedTo(unique: false)
    distributedBy(nullable: false)
    distributedBy(unique: false)
    distributedDate(nullable: false)
    distributedDate(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
