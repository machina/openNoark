/**
Metadata for dokumentflyt¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Journalpost¤¤¤¤¤
Forekomst:               0-M¤¤¤¤¤
 ¤¤¤¤¤

*/
class Dokumentflyt {
  String flyttil
  String flytfra
  Date flytmottattdato
  Date flytsendtdato
  String flytstatus
  String flytmerknad
  static constraints = {
    flyttil(nullable: false)
    flyttil(unique: true)
    flytfra(nullable: false)
    flytfra(unique: true)
    flytmottattdato(nullable: false)
    flytmottattdato(unique: true)
    flytsendtdato(nullable: false)
    flytsendtdato(unique: true)
    flytstatus(nullable: false)
    flytstatus(unique: true)
    flytmerknad(nullable: true)
    flytmerknad(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
