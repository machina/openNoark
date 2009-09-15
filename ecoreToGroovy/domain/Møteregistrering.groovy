class Møteregistrering extends Basisregistrering{
  String møteregistreringstype
  String møtesakstype
  String møteregistreringsstatus
  String administrativenhet
  String saksbehandler
    static constraints = {
møteregistreringstype(nullable: false)
møtesakstype(nullable: false)
møteregistreringsstatus(nullable: true)
administrativenhet(nullable: false)
saksbehandler(nullable: false)
referansetilMøteregistrering(nullable: true)
referanseframøteregistrering(nullable: true)
}
static hasMany = [referansetilMøteregistrering:ForenkletRegistrering, referanseframøteregistrering:ForenkletRegistrering]
}
