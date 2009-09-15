class Dokumentflyt {
  String flyttil
  String flytfra
  Date flytmottattdato
  Date flytsendtdato
  String flytstatus
  String flytmerknad
static constraints = {
flyttil(nullable: false)
flytfra(nullable: false)
flytmottattdato(nullable: false)
flytsendtdato(nullable: false)
flytstatus(nullable: false)
flytmerknad(nullable: true)
}
static hasMany = [:]
}
