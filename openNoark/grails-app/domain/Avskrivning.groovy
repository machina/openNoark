/**
Metadata for avskrivning¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Journalpost¤¤¤¤¤
Forekomst:               0-M¤¤¤¤¤
 ¤¤¤¤¤
.Avskrivning er obligatorisk for inngående dokumenter og organinterne dokumenter som skal følges opp.¤¤¤¤¤
 ¤¤¤¤¤

*/
class Avskrivning {
  Date avskrivningsdato
  String avskrevetav
  String avskrivningsmåte
  ForenkletRegistrering referanseavskriverJournalpost
  ForenkletRegistrering referanseavskrivesavJournalpost
  static constraints = {
    avskrivningsdato(nullable: false)
    avskrivningsdato(unique: true)
    avskrevetav(nullable: false)
    avskrevetav(unique: true)
    avskrivningsmåte(nullable: false)
    avskrivningsmåte(unique: true)
    referanseavskriverJournalpost(nullable: true)
    referanseavskriverJournalpost(unique: true)
    referanseavskrivesavJournalpost(nullable: true)
    referanseavskrivesavJournalpost(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
