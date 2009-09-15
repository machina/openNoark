class Presedens {
  Date presedensdato
  Date opprettetdato
  String opprettetav
  String tittel
  String beskrivelse
  String presedenshjemmel
  String rettskildefaktor
  Date presedensgodkjentdato
  String presedensgodkjentav
  Date avsluttetdato
  String avsluttetav
  String presedensstatus
static constraints = {
presedensdato(nullable: false)
opprettetdato(nullable: false)
opprettetav(nullable: false)
tittel(nullable: false)
beskrivelse(nullable: true)
presedenshjemmel(nullable: true)
rettskildefaktor(nullable: false)
presedensgodkjentdato(nullable: true)
presedensgodkjentav(nullable: true)
avsluttetdato(nullable: true)
avsluttetav(nullable: true)
presedensstatus(nullable: true)
}
static hasMany = [:]
}
