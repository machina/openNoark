/**
Metadata for dokumentlink¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Dokumentbeskrivelse¤¤¤¤¤
Forekomst:               1¤¤¤¤¤
 ¤¤¤¤¤
Det skal opprettes en ny dokumentlink for hver gang et dokument knyttes til en registrering. ¤¤¤¤¤
 ¤¤¤¤¤

*/
class Dokumentlink {
  ForenkletRegistrering referanseregistrering
  String tilknyttetregistreringSom
  String dokumentnummer
  Date tilknyttetdato
  String tilknyttetav
  static constraints = {
    referanseregistrering(nullable: false)
    referanseregistrering(unique: true)
    tilknyttetregistreringSom(nullable: false)
    tilknyttetregistreringSom(unique: true)
    dokumentnummer(nullable: false)
    dokumentnummer(unique: true)
    tilknyttetdato(nullable: false)
    tilknyttetdato(unique: true)
    tilknyttetav(nullable: false)
    tilknyttetav(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
