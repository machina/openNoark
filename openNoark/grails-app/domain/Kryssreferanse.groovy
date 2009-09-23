/**
Metadata for kryssreferanse¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Klasse, Basismappe, Basisregistrering¤¤¤¤¤
Forekomst:               0-M¤¤¤¤¤
 ¤¤¤¤¤
Referansen kan gå fra en klasse til en annen klasse, fra en mappe til en annen mappe, fra en registrering til en annen registrering, fra en mappe til en registrering og fra en registrering til en mappe. Kryssreferansen  vil også omfatte spesialiseringer.  En kryssreferanse kan derfor gå fra en møtemappe til en saksmappe. ¤¤¤¤¤
 ¤¤¤¤¤

*/
class Kryssreferanse {
  String referansetilklasse
  String referansefraklasse
  String referansetilmappe
  String referanseframappe
  String referansetilregistrering
  String referansefraregistrering
  static constraints = {
    referansetilklasse(nullable: false)
    referansetilklasse(unique: true)
    referansefraklasse(nullable: false)
    referansefraklasse(unique: true)
    referansetilmappe(nullable: false)
    referansetilmappe(unique: true)
    referanseframappe(nullable: false)
    referanseframappe(unique: true)
    referansetilregistrering(nullable: false)
    referansetilregistrering(unique: true)
    referansefraregistrering(nullable: false)
    referansefraregistrering(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
