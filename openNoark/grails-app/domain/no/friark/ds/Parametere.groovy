package no.friark.ds
class Parametere {
  String key
  String value
  static constraints = {
    key(nullable: false)
    key(unique: true)
    value(nullable: true)
    value(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
