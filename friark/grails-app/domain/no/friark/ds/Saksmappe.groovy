/**
Metadata for saksmappe

Metadata for basismappe inngår i saksmappe, følgende metadata kommer i tillegg.
*/
package no.friark.ds
class Saksmappe extends Basismappe{
  Date saksdato
  String administrativenhet
  String saksansvarlig
  String journalenhet
  String saksstatus
  Date utlåntdato
  String utlånttil
  Presedens presedens
  static constraints = {
    saksdato(nullable: false)
    saksdato(unique: false)
    administrativenhet(nullable: false)
    administrativenhet(unique: false)
    saksansvarlig(nullable: false)
    saksansvarlig(unique: false)
    journalenhet(nullable: true)
    journalenhet(unique: false)
    saksstatus(nullable: false)
    saksstatus(unique: false)
    utlåntdato(nullable: true)
    utlåntdato(unique: false)
    utlånttil(nullable: true)
    utlånttil(unique: false)
    referansesekundærKlassifikasjon(nullable: true)
    referansesekundærKlassifikasjon(unique: true)
    presedens(nullable: true)
    presedens(unique: false)
    sekundærklasseringer(nullable: true)
    sekundærklasseringer(unique: false)
  }
  static hasMany = [referansesekundærKlassifikasjon:Klasse, sekundærklasseringer:Klasse]
  static mapping = {
  }
  static belongsTo = Klasse
}
