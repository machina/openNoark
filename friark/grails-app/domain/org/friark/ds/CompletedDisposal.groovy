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
    disposedOfDate(unique: false)
    disposedOfBy(nullable: false)
    disposedOfBy(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
