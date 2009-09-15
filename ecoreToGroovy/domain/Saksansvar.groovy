class Saksansvar {
  String administrativenhet
  String saksbehandler
  String journalenhet
static constraints = {
administrativenhet(nullable: false)
saksbehandler(nullable: false)
journalenhet(nullable: true)
}
static hasMany = [:]
}
