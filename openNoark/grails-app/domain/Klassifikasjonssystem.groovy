class Klassifikasjonssystem {
  String systemid
  String klassifikasjonstype
  String tittel
  String beskrivelse
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  static constraints = {
systemid(nullable: false)
klassifikasjonstype(nullable: true)
tittel(nullable: false)
beskrivelse(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: true)
avsluttetav(nullable: true)
referansebarn(minSize: 0)
}
static hasMany = [referansebarn:Klasse]
static auditable = true

static searchable = true
}
