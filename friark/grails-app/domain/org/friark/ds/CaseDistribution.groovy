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
    distributedTo(unique: true)
    distributedBy(nullable: false)
    distributedBy(unique: true)
    distributedDate(nullable: false)
    distributedDate(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
