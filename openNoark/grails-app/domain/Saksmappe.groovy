/**
Metadata for saksmappe¤¤¤¤¤
 ¤¤¤¤¤
Metadata for basismappe inngår i saksmappe, følgende metadata kommer i tillegg.¤¤¤¤¤
 ¤¤¤¤¤

*/
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
    saksdato(unique: true)
    administrativenhet(nullable: false)
    administrativenhet(unique: true)
    saksansvarlig(nullable: false)
    saksansvarlig(unique: true)
    journalenhet(nullable: true)
    journalenhet(unique: true)
    saksstatus(nullable: false)
    saksstatus(unique: true)
    utlåntdato(nullable: true)
    utlåntdato(unique: true)
    utlånttil(nullable: true)
    utlånttil(unique: true)
    referansesekundærKlassifikasjon(nullable: true)
    referansesekundærKlassifikasjon(unique: true)
  }
  static hasMany = [referansesekundærKlassifikasjon:Klasse]
  static mapping = {
  }
  static belongsTo = Klasse
}
