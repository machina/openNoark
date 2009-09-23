/**
Metadata for utført kassasjon¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:       Dokumentbeskrivelse¤¤¤¤¤
Forekomst:               0-1¤¤¤¤¤
 ¤¤¤¤¤
Ved kassasjon skal dokumentobjektet slettes. ¤¤¤¤¤
 ¤¤¤¤¤

*/
class UtførtKassasjon {
  Date kassertdato
  String kassertav
  static constraints = {
    kassertdato(nullable: false)
    kassertdato(unique: true)
    kassertav(nullable: false)
    kassertav(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
