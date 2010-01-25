/**
Metadata for endringslogg¤¤¤¤¤
 ¤¤¤¤¤
Metadata for endringslogg skal ikke grupperes inn i en annen arkivenhet, men avleveres som en egen fil.  Endringsloggen må derfor ha referanse til hvilken arkivenhet endringen tilhører, og hvilket metadataelement som er blitt endret. ¤¤¤¤¤
 ¤¤¤¤¤
Ikke alle endringer skal avleveres. Aktuelle endringer kan  være  endring av saksstatus, journal-status, tilgangsrestriksjon, klassifikasjon (referanse til klasse), saksansvarlig, saksbehandler. Nærmere spesifikasjon av hvilke endringer som skal avleveres, vil komme i en senere versjon. ¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Endringslogg {
  String referansearkivenhet
  String referansemetadata
  Date endretdato
  String endretav
  String tidligereverdi
  String nyverdi
  static constraints = {
    referansearkivenhet(nullable: false)
    referansearkivenhet(unique: true)
    referansemetadata(nullable: false)
    referansemetadata(unique: true)
    endretdato(nullable: false)
    endretdato(unique: true)
    endretav(nullable: false)
    endretav(unique: true)
    tidligereverdi(nullable: false)
    tidligereverdi(unique: true)
    nyverdi(nullable: false)
    nyverdi(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
