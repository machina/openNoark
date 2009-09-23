/**
Metadata for møtedeltaker¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:        Møtemappe¤¤¤¤¤
Forekomst:               1-M¤¤¤¤¤
 ¤¤¤¤¤

*/
class Møtedeltaker {
  String møtedeltakernavn
  String møtedeltakerfunksjon
  static constraints = {
    møtedeltakernavn(nullable: false)
    møtedeltakernavn(unique: true)
    møtedeltakerfunksjon(nullable: false)
    møtedeltakerfunksjon(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
