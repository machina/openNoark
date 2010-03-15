/**
Metadata for sletting av dokumenter
<br/>
Grupperes inn i:	Arkivdel, dokumentbeskrivelse
Forekomst:		0-M

Ved sletting av tidligere versjoner (siste versjon kan ikke slettes), produksjonsformat og varianter skal metadata grupperes inn i dokumentbeskrivelse. De tilhørende dokumentobjekter skal da slettes.

Ved sletting av innholdet i en arkivdel (som ikke har bevaringsverdi), skal alle mapper og underordnede arkivenheter som tilhørere arkivdelen slettes. 
*/
package no.friark.ds
class SlettingAvDokumenter {
  String slettingstype
  Date slettetdato
  String slettetav
  static constraints = {
    slettingstype(nullable: false)
    slettingstype(unique: true)
    slettetdato(nullable: false)
    slettetdato(unique: true)
    slettetav(nullable: false)
    slettetav(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
