/**
Metadata for presedens
<br/>
Grupperes inn i:	Saksmappe, Journalpost<br/>
Forekomst:		0-M
*/
package no.friark.ds
class Presedens {
  Date presedensdato
  Date opprettetdato
  String opprettetav
  String tittel
  String beskrivelse
  String presedenshjemmel
  String rettskildefaktor
  Date presedensgodkjentdato
  String presedensgodkjentav
  Date avsluttetdato
  String avsluttetav
  String presedensstatus
  static constraints = {
    presedensdato(nullable: false)
    presedensdato(unique: true)
    opprettetdato(nullable: false)
    opprettetdato(unique: true)
    opprettetav(nullable: false)
    opprettetav(unique: true)
    tittel(nullable: false)
    tittel(unique: true)
    beskrivelse(nullable: true)
    beskrivelse(unique: true)
    presedenshjemmel(nullable: true)
    presedenshjemmel(unique: true)
    rettskildefaktor(nullable: false)
    rettskildefaktor(unique: true)
    presedensgodkjentdato(nullable: true)
    presedensgodkjentdato(unique: true)
    presedensgodkjentav(nullable: true)
    presedensgodkjentav(unique: true)
    avsluttetdato(nullable: true)
    avsluttetdato(unique: true)
    avsluttetav(nullable: true)
    avsluttetav(unique: true)
    presedensstatus(nullable: true)
    presedensstatus(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
