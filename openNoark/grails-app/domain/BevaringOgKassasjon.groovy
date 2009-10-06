/**
Metadata for bevaring og kassasjon¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:       Arkivdel, Klasse, Basismappe, Forenklet registrering, Dokumentbeskrivelse¤¤¤¤¤
Forekomst:               0-1¤¤¤¤¤
 ¤¤¤¤¤
I Noark 4 har disse attributtene forskjellig navn avhengig av hvilket nivå i arkivstrukturen de er tilknyttet. Nedenfor er tatt med referanse til attributter på saksnivået.¤¤¤¤¤
 ¤¤¤¤¤
 ¤¤¤¤¤

*/
class BevaringOgKassasjon {
  String kassasjonsvedtak
  String kassasjonshjemmel
  String bevaringstid
  Date kassasjonsdato
  static constraints = {
    kassasjonsvedtak(nullable: false)
    kassasjonsvedtak(unique: true)
    kassasjonshjemmel(nullable: true)
    kassasjonshjemmel(unique: true)
    bevaringstid(nullable: false)
    bevaringstid(unique: true)
    kassasjonsdato(nullable: false)
    kassasjonsdato(unique: true)
    registrering(nullable: true)
    registrering(unique: false)
    arkivdel(nullable: true)
    arkivdel(unique: false)
    mappe(nullable: true)
    mappe(unique: false)
    klasse(nullable: true)
    klasse(unique: false)
    dokumentBeskrivelse(nullable: true)
    dokumentBeskrivelse(unique: false)
  }
  static hasMany = [registrering:ForenkletRegistrering, arkivdel:Arkivdel, mappe:Basismappe, klasse:Klasse, dokumentBeskrivelse:Dokumentbeskrivelse]
  static mapping = {
  }
}
