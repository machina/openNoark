/**
Metadata for konvertering til arkivformat¤¤¤¤¤
 ¤¤¤¤¤
Grupperes inn i:       Dokumentobjekt¤¤¤¤¤
Forekomst:               0-1¤¤¤¤¤
 ¤¤¤¤¤
Metadata for konvertering skal grupperes i metadata for dokumentobjekt. Konvertering er valgfritt, og kan forekomme en gang.¤¤¤¤¤
 ¤¤¤¤¤

*/
package no.friark.ds
class KonverteringTilArkivformat {
  Date konvertertdato
  String konvertertav
  String tidligereformat
  String tidligereformatdetaljer
  static constraints = {
    konvertertdato(nullable: false)
    konvertertdato(unique: true)
    konvertertav(nullable: false)
    konvertertav(unique: true)
    tidligereformat(nullable: false)
    tidligereformat(unique: true)
    tidligereformatdetaljer(nullable: true)
    tidligereformatdetaljer(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
