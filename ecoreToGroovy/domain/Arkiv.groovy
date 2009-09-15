class Arkiv {
  String systemid
  String tittel
  String beskrivelse
  String arkivstatus
  String dokumentmedium
    Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Arkiv referanseforelder
    static constraints = {
systemid(nullable: false)
tittel(nullable: false)
beskrivelse(nullable: true)
arkivstatus(nullable: true)
dokumentmedium(nullable: true)
oppbevaringssted(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: false)
avsluttetav(nullable: false)
referanseforelder(nullable: true)
referansebarnArkivdel(minSize: 1)
referansebarnArkiv(minSize: 1)
}
static hasMany = [oppbevaringssted:String, referansebarnArkivdel:Arkivdel, referansebarnArkiv:Arkiv]
}
