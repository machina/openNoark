package org.friark.ds
class RemarkType {
  String name
  static constraints = {
    name(nullable: false)
    name(unique: true)
    remark(nullable: true)
    remark(unique: true)
  }
  static hasMany = [remark:Remark]
  static mapping = {
  }
}
