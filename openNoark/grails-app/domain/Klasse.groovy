class Klasse {
  String systemid
  String klasseid
  String tittel
  String beskrivelse
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Klassifikasjonssystem referanseforelderKlassifikasjonssystem
  Klasse referanseforelderKlasse
      static constraints = {
systemid(nullable: false, unique: true)
klasseid(nullable: false)
tittel(nullable: false)
beskrivelse(nullable: true)
nøkkelord(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: true)
avsluttetav(nullable: true)
referanseforelderKlassifikasjonssystem(nullable: true)
referanseforelderKlasse(nullable: true)
referansebarnKlasse(minSize: 1)
referansebarnBasismappe(minSize: 1)
referansebarnForenkletRegistrering(minSize: 1)
}
static hasMany = [nøkkelord:String, referansebarnKlasse:Klasse, referansebarnBasismappe:Basismappe, referansebarnForenkletRegistrering:ForenkletRegistrering]
static auditable = true

String fullId
static transients = [ "fullId" ]

	def afterLoad = {
			println "klasseid: ${owner.klasseid}"
      if(referanseforelderKlasse){
				fullId = "${referanseforelderKlasse.klasseid}.${klasseid}"
			}else{
				fullId = "${klasseid}"
			}
			println "fullId: ${fullId}"
   }

//static searchable = true
}
