/**
Metadata for arkivskaper¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Arkiv¤¤¤¤¤
Forekomst:               1-M¤¤¤¤¤
 ¤¤¤¤¤

*/
class Arkivskaper {
  String arkivskaperid
  String arkivskapernavn
  String beskrivelse
  static constraints = {
    arkivskaperid(nullable: false)
    arkivskaperid(unique: true)
    arkivskapernavn(nullable: false)
    arkivskapernavn(unique: true)
    beskrivelse(nullable: true)
    beskrivelse(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = true
}
