class Basismappe {
  String systemid
  String mappeid
  String mappetype
  String tittel
  String offentligtittel
  String beskrivelse
    String dokumentmedium
    Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Klasse referanseforelderKlasse
  Basismappe referanseforelderBasismappe
      Arkivdel referansearkivdel
static constraints = {
systemid(nullable: false)
mappeid(nullable: false)
mappetype(nullable: false)
tittel(nullable: false)
offentligtittel(nullable: true)
beskrivelse(nullable: true)
nøkkelord(nullable: true)
dokumentmedium(nullable: true)
oppbevaringssted(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: false)
avsluttetav(nullable: false)
referanseforelderKlasse(nullable: false)
referanseforelderBasismappe(nullable: false)
referansebarnForenkletRegistrering(minSize: 1)
referansebarnBasismappe(minSize: 1)
referansearkivdel(nullable: false)
}
static hasMany = [nøkkelord:String, oppbevaringssted:String, referansebarnForenkletRegistrering:ForenkletRegistrering, referansebarnBasismappe:Basismappe]
}
