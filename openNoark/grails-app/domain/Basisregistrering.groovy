/**
Metadata for basisregistrering¤¤¤¤¤
 ¤¤¤¤¤
Metadata for forenkletRegistrering inngår i basisregistrering, følgende metadata kommer i tillegg.¤¤¤¤¤
 ¤¤¤¤¤

*/
class Basisregistrering extends ForenkletRegistrering{
  String registreringsid
  String tittel
  String offentligtittel
  String beskrivelse
  String dokumentmedium
  static constraints = {
    registreringsid(nullable: false)
    registreringsid(unique: true)
    tittel(nullable: false)
    tittel(unique: true)
    offentligtittel(nullable: true)
    offentligtittel(unique: true)
    beskrivelse(nullable: true)
    beskrivelse(unique: true)
    nøkkelord(nullable: true)
    nøkkelord(unique: false)
    forfatter(nullable: true)
    forfatter(unique: false)
    dokumentmedium(nullable: true)
    dokumentmedium(unique: true)
    oppbevaringssted(nullable: true)
    oppbevaringssted(unique: false)
  }
  static hasMany = [nøkkelord:String, forfatter:String, oppbevaringssted:String]
  static mapping = {
    tablePerHierarchy false
  }
}
