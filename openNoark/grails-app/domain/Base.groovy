class Base {
  String systemid
  static constraints = {
    systemid(nullable: false)
    systemid(unique: true)
  }
  static hasMany = [:]
  static mapping = {
    tablePerHierarchy false
  }
}
