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
sakspartnavn(nullable: false)
sakspartrolle(nullable: false)
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
