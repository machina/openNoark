class Arkivdel {
  String systemid
  String tittel
  String beskrivelse
  String arkivdelstatus
  String dokumentmedium
    Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Date arkivperiodestartdato
  Date arkivperiodesluttdato
  Arkiv referanseforelder
  Arkivdel referanseforløper
  Arkivdel referansearvtaker
  Klassifikasjonssystem referanseklassifikasjonsSystem
    static constraints = {
systemid(nullable: false)
tittel(nullable: false)
beskrivelse(nullable: true)
arkivdelstatus(nullable: false)
dokumentmedium(nullable: false)
oppbevaringssted(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: false)
avsluttetav(nullable: false)
arkivperiodestartdato(nullable: false)
arkivperiodesluttdato(nullable: false)
referanseforelder(nullable: false)
referanseforløper(nullable: false)
referansearvtaker(nullable: false)
referanseklassifikasjonsSystem(nullable: false)
referansemappe(minSize: 1)
referanseregistrering(nullable: true)
}
static hasMany = [oppbevaringssted:String, referansemappe:Basismappe, referanseregistrering:ForenkletRegistrering]
}
