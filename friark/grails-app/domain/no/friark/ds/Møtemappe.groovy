/**
Metadata for møtemappe
<br/>
Metadata for basismappe inngår i møtemappe, følgende metadata kommer i tillegg.
*/
package no.friark.ds
class Møtemappe extends Basismappe{
  String møtenummer
  String utvalg
  Date møtedato
  String møtested
  Basismappe referanseforrigemøte
  Basismappe referansenestemøte
  static constraints = {
    møtenummer(nullable: false)
    møtenummer(unique: true)
    utvalg(nullable: false)
    utvalg(unique: true)
    møtedato(nullable: false)
    møtedato(unique: true)
    møtested(nullable: true)
    møtested(unique: true)
    referanseforrigemøte(nullable: true)
    referanseforrigemøte(unique: true)
    referansenestemøte(nullable: true)
    referansenestemøte(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
