/**
Metadata for klassifikasjonssystem¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Klassifikasjonssystem extends Base{
  String klassifikasjonstype
  String tittel
  String beskrivelse
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  static constraints = {
    klassifikasjonstype(nullable: true)
    klassifikasjonstype(unique: false)
    tittel(nullable: false)
    tittel(unique: false)
    beskrivelse(nullable: true)
    beskrivelse(unique: false)
    opprettetdato(nullable: false)
    opprettetdato(unique: false)
    opprettetav(nullable: false)
    opprettetav(unique: false)
    avsluttetdato(nullable: true)
    avsluttetdato(unique: false)
    avsluttetav(nullable: true)
    avsluttetav(unique: false)
    referansebarn(nullable: true)
    referansebarn(unique: false)
  }
  static hasMany = [referansebarn:Klasse]
  static mapping = {
  }
  static searchable = true
  static auditable = true
  String toString(){"${tittel}"}
}
