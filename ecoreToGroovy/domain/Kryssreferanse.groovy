class Kryssreferanse {
  String referansetilklasse
  String referansefraklasse
  String referansetilmappe
  String referanseframappe
  String referansetilregistrering
  String referansefraregistrering
static constraints = {
referansetilklasse(nullable: false)
referansefraklasse(nullable: false)
referansetilmappe(nullable: false)
referanseframappe(nullable: false)
referansetilregistrering(nullable: false)
referansefraregistrering(nullable: false)
}
static hasMany = [:]
}
