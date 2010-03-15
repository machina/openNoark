/**
Metadata for møteregistrering
<br/>
Metadata for basisregistrering inngår i møteregistrering, følgende metadata kommer i tillegg.

*/
package no.friark.ds
class Møteregistrering extends Basisregistrering{
  String møteregistreringstype
  String møtesakstype
  String møteregistreringsstatus
  String administrativenhet
  String saksbehandler
  static constraints = {
    møteregistreringstype(nullable: false)
    møteregistreringstype(unique: true)
    møtesakstype(nullable: false)
    møtesakstype(unique: true)
    møteregistreringsstatus(nullable: true)
    møteregistreringsstatus(unique: true)
    administrativenhet(nullable: false)
    administrativenhet(unique: true)
    saksbehandler(nullable: false)
    saksbehandler(unique: true)
    referansetilMøteregistrering(nullable: true)
    referansetilMøteregistrering(unique: true)
    referanseframøteregistrering(nullable: true)
    referanseframøteregistrering(unique: true)
  }
  static hasMany = [referansetilMøteregistrering:ForenkletRegistrering, referanseframøteregistrering:ForenkletRegistrering]
  static mapping = {
  }
}
