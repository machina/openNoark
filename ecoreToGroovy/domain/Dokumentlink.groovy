class Dokumentlink {
  ForenkletRegistrering referanseregistrering
  String tilknyttetregistreringSom
  String dokumentnummer
  Date tilknyttetdato
  String tilknyttetav
static constraints = {
referanseregistrering(nullable: false)
tilknyttetregistreringSom(nullable: false)
dokumentnummer(nullable: false)
tilknyttetdato(nullable: false)
tilknyttetav(nullable: false)
}
static hasMany = [:]
}
