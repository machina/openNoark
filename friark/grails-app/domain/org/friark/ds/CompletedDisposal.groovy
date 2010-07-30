/**
Metadata for utført kassasjon
<br/>
Grupperes inn i:	Dokumentbeskrivelse<br/>
Forekomst:		0-1

Ved kassasjon skal dokumentobjektet slettes. 

*/
package org.friark.ds
class CompletedDisposal {
  Date disposedOfDate
  String disposedOfBy
  static constraints = {
    disposedOfDate(nullable: false)
    disposedOfDate(unique: true)
    disposedOfBy(nullable: false)
    disposedOfBy(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
