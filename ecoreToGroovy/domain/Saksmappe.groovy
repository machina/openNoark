class Saksmappe extends Basismappe{
  Date saksdato
  String administrativenhet
  String saksansvarlig
  String journalenhet
  String saksstatus
  Date utlåntdato
  String utlånttil
  static constraints = {
saksdato(nullable: false)
administrativenhet(nullable: false)
saksansvarlig(nullable: false)
journalenhet(nullable: true)
saksstatus(nullable: false)
utlåntdato(nullable: true)
utlånttil(nullable: true)
referansesekundærKlassifikasjon(nullable: true)
}
static hasMany = [referansesekundærKlassifikasjon:Klasse]
}
