/**
Metadata for saksfordeling¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Saksmappe, journalpost¤¤¤¤¤
Forekomst:               0-M¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Saksfordeling {
  String fordelttil
  String fordeltav
  String fordeltdato
  static constraints = {
    fordelttil(nullable: false)
    fordelttil(unique: true)
    fordeltav(nullable: false)
    fordeltav(unique: true)
    fordeltdato(nullable: false)
    fordeltdato(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
