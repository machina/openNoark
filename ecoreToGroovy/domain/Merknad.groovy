class Merknad {
  String merknadstekst
  String merknadstype
  Date merknadsdato
  String merknadregistrertav
static constraints = {
merknadstekst(nullable: false)
merknadstype(nullable: true)
merknadsdato(nullable: false)
merknadregistrertav(nullable: false)
}
static hasMany = [:]
}
