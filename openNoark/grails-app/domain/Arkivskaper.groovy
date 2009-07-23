class Arkivskaper {
  String arkivskaperid
  String arkivskapernavn
  String beskrivelse
static constraints = {
arkivskaperid(nullable: false)
arkivskapernavn(nullable: false)
beskrivelse(nullable: true)
}
static hasMany = [:]
}
