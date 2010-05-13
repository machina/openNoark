/**
Metadata for korrespondansepart
<br/>
Grupperes inn i:	Journalpost
Forekomst:		1-M
*/
package no.friark.ds
class Korrespondansepart {
  String korrespondanseparttype
  String korrespondansepartnavn
  String postadresse
  String postnummer
  String poststed
  String utenlandsadresse
  String epostadresse
  String telefonnummer
  String kontaktperson
  Journalpost journalpost
  static constraints = {
    korrespondanseparttype(nullable: false)
    korrespondanseparttype(unique: true)
    korrespondansepartnavn(nullable: false)
    korrespondansepartnavn(unique: true)
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
    journalpost(nullable: false)
    journalpost(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
