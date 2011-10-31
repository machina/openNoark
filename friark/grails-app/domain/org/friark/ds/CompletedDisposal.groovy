package org.friark.ds
/**
Metadata for utført kassasjon amp;#xA;<br/> amp;#xA;Grupperes inn i: Dokumentbeskrivelse<br/> amp;#xA;Forekomst:  0-1 amp;#xA; amp;#xA;Ved kassasjon skal dokumentobjektet slettes.  amp;#xA;
*/
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
  static searchable = false
  static loggable = false
}
