class KonverteringTilArkivformat {
  Date konvertertdato
  String konvertertav
  String tidligereformat
  String tidligereformatdetaljer
static constraints = {
konvertertdato(nullable: false)
konvertertav(nullable: false)
tidligereformat(nullable: false)
tidligereformatdetaljer(nullable: true)
}
static hasMany = [:]
}
