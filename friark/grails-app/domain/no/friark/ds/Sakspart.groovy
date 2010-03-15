/**
Metadata for sakspart
<br/>
Grupperes inn i:	Saksmappe<br/>
Forekomst:		0-M


*/
package no.friark.ds
class Sakspart {
  String sakspartid
  String sakspartnavn
  String sakspartrolle
  String postadresse
  String postnummer
  String poststed
  String utenlandsadresse
  String epostadresse
  String telefonnummer
  String kontaktperson
  static constraints = {
    sakspartid(nullable: true)
    sakspartid(unique: true)
    sakspartnavn(nullable: false)
    sakspartnavn(unique: true)
    sakspartrolle(nullable: false)
    sakspartrolle(unique: true)
    postadresse(nullable: true)
    postadresse(unique: true)
    postnummer(nullable: true)
    postnummer(unique: true)
    poststed(nullable: true)
    poststed(unique: true)
    utenlandsadresse(nullable: true)
    utenlandsadresse(unique: true)
    epostadresse(nullable: true)
    epostadresse(unique: true)
    telefonnummer(nullable: true)
    telefonnummer(unique: true)
    kontaktperson(nullable: true)
    kontaktperson(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
