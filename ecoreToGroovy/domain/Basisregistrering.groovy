class Basisregistrering extends ForenkletRegistrering{
  String registreringsid
  String tittel
  String offentligtittel
  String beskrivelse
      String dokumentmedium
  static constraints = {
registreringsid(nullable: false)
tittel(nullable: false)
offentligtittel(nullable: true)
beskrivelse(nullable: true)
nøkkelord(nullable: true)
forfatter(nullable: true)
dokumentmedium(nullable: true)
oppbevaringssted(nullable: true)
}
static hasMany = [nøkkelord:String, forfatter:String, oppbevaringssted:String]
}
