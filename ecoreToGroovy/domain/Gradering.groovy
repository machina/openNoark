class Gradering {
  String gradering
  Date graderingsdato
  String gradertav
  Date nedgraderingsdato
  String nedgradertav
static constraints = {
gradering(nullable: false)
graderingsdato(nullable: false)
gradertav(nullable: false)
nedgraderingsdato(nullable: true)
nedgradertav(nullable: true)
}
static hasMany = [:]
}
