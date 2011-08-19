/**
Metadata for endringslogg

Metadata for endringslogg skal ikke grupperes inn i en annen arkivenhet, men avleveres som en egen fil.  Endringsloggen må derfor ha referanse til hvilken arkivenhet endringen tilhører, og hvilket metadataelement som er blitt endret. 

Ikke alle endringer skal avleveres. Aktuelle endringer kan  være  endring av saksstatus, journal-status, tilgangsrestriksjon, klassifikasjon (referanse til klasse), saksansvarlig, saksbehandler. Nærmere spesifikasjon av hvilke endringer som skal avleveres, vil komme i en senere versjon. 
*/
package org.friark.ds
class ChangeLog {
  String recordUnit
  String metadata
  Date changedDate
  String changedBy
  String previousValue
  String newValue
  static constraints = {
    recordUnit(nullable: false)
    recordUnit(unique: false)
    metadata(nullable: false)
    metadata(unique: false)
    changedDate(nullable: false)
    changedDate(unique: false)
    changedBy(nullable: false)
    changedBy(unique: false)
    previousValue(nullable: false)
    previousValue(unique: false)
    newValue(nullable: false)
    newValue(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
