/**
Metadata for dokumentlink¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Dokumentbeskrivelse¤¤¤¤¤
Forekomst:               1¤¤¤¤¤
 ¤¤¤¤¤
Det skal opprettes en ny dokumentlink for hver gang et dokument knyttes til en registrering. ¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class Dokumentlink {
  ForenkletRegistrering referanseregistrering
  String tilknyttetregistreringSom
  String dokumentnummer
  Date tilknyttetdato
  String tilknyttetav
  Dokumentbeskrivelse dokumentbeskrivelse
  static constraints = {
    referanseregistrering(nullable: false)
    referanseregistrering(unique: false)
    tilknyttetregistreringSom(nullable: false)
    tilknyttetregistreringSom(unique: false)
    dokumentnummer(nullable: false)
    dokumentnummer(unique: false)
    tilknyttetdato(nullable: false)
    tilknyttetdato(unique: false)
    tilknyttetav(nullable: false)
    tilknyttetav(unique: false)
    dokumentbeskrivelse(nullable: true)
    dokumentbeskrivelse(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
