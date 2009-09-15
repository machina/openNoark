class Administrasjonsstruktur {
  String administrativenhetnavn
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String administrativenhetsstatus
  String referanseoverordnetEnhet
static constraints = {
administrativenhetnavn(nullable: false)
opprettetdato(nullable: false)
opprettetav(nullable: true)
avsluttetdato(nullable: true)
administrativenhetsstatus(nullable: true)
referanseoverordnetEnhet(nullable: true)
}
static hasMany = [:]
}
