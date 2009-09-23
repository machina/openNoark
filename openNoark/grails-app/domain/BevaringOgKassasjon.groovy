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
  }
  static hasMany = [:]
  static mapping = {
  }
}
