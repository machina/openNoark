class Brukeradministrasjon {
  String brukernavn
  String brukerrolle
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String brukerstatus
static constraints = {
brukernavn(nullable: false)
brukerrolle(nullable: false)
opprettetdato(nullable: false)
opprettetav(nullable: true)
avsluttetdato(nullable: true)
brukerstatus(nullable: true)
}
static hasMany = [:]
}
