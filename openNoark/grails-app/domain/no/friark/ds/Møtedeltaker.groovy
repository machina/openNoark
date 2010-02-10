/**
Metadata for møtedeltaker
<br/>
Grupperes inn i:	Møtemappe
Forekomst:		1-M

*/
package no.friark.ds
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
