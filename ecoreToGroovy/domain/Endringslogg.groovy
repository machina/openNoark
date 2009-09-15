class Endringslogg {
  String referansearkivenhet
  String referansemetadata
  Date endretdato
  String endretav
  String tidligereverdi
  String nyverdi
static constraints = {
referansearkivenhet(nullable: false)
referansemetadata(nullable: false)
endretdato(nullable: false)
endretav(nullable: false)
tidligereverdi(nullable: false)
nyverdi(nullable: false)
}
static hasMany = [:]
}
