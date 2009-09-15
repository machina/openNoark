class Avskrivning {
  Date avskrivningsdato
  String avskrevetav
  String avskrivningsmåte
  ForenkletRegistrering referanseavskriverJournalpost
  ForenkletRegistrering referanseavskrivesavJournalpost
static constraints = {
avskrivningsdato(nullable: false)
avskrevetav(nullable: false)
avskrivningsmåte(nullable: false)
referanseavskriverJournalpost(nullable: true)
referanseavskrivesavJournalpost(nullable: true)
}
static hasMany = [:]
}
