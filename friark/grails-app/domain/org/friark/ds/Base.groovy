package org.friark.ds
class Base {
  String systemID
  static constraints = {
    systemID(nullable: false)
    systemID(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
