class Møtemappe extends Basismappe{
  String møtenummer
  String utvalg
  Date møtedato
  String møtested
  Basismappe referanseforrigemøte
  Basismappe referansenestemøte
static constraints = {
møtenummer(nullable: false)
utvalg(nullable: false)
møtedato(nullable: false)
møtested(nullable: true)
referanseforrigemøte(nullable: true)
referansenestemøte(nullable: true)
}
static hasMany = [:]
}
