package no.friark.ds
class MerknadType {
  String navn
  static constraints = {
    navn(nullable: false)
    navn(unique: true)
    merknad(nullable: true)
    merknad(unique: true)
  }
  static hasMany = [merknad:Merknad]
  static mapping = {
  }
}
