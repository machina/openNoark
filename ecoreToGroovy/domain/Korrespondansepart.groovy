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
static constraints = {
korrespondanseparttype(nullable: false)
korrespondansepartnavn(nullable: false)
postadresse(nullable: true)
postnummer(nullable: true)
poststed(nullable: true)
utenlandsadresse(nullable: true)
epostadresse(nullable: true)
telefonnummer(nullable: true)
kontaktperson(nullable: true)
}
static hasMany = [:]
}
