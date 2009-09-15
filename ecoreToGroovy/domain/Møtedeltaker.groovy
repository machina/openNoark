class Møtedeltaker {
  String møtedeltakernavn
  String møtedeltakerfunksjon
static constraints = {
møtedeltakernavn(nullable: false)
møtedeltakerfunksjon(nullable: false)
}
static hasMany = [:]
}
