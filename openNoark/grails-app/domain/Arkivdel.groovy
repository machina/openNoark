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
//  Klassifikasjonssystem referanseklassifikasjonsSystem
    static constraints = {
systemid(nullable: false)
tittel(nullable: false)
beskrivelse(nullable: true)
arkivdelstatus(nullable: false)
dokumentmedium(nullable: false)
oppbevaringssted(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: true)
avsluttetav(nullable: true)
arkivperiodestartdato(nullable: false)
arkivperiodesluttdato(nullable: true)
referanseforelder(nullable: false)
referanseforløper(nullable: true)
referansearvtaker(nullable: true)
referanseforelder( validator: {
	if(it.arkivstatus == "Opprettet") return true
	return "Kan ikke legge inn arkivdeler under et avsluttet arkiv."
})
//referanseklassifikasjonsSystem(nullable: false)
//referansemappe(minSize: 1)
//referanseregistrering(nullable: true)
}
static hasMany = [oppbevaringssted:String]

static auditable = true
static searchable = true

}
