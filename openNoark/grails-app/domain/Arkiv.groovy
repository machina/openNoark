class Arkiv extends Base{
  String tittel
  String beskrivelse
  String arkivstatus
  String dokumentmedium
  Date opprettetdato
  String opprettetav
  Date avsluttetdato
  String avsluttetav
  Arkiv referanseforelder
	Arkiv forelder
    static constraints = {
tittel(nullable: false)
beskrivelse(nullable: true)
arkivstatus(nullable: true)
dokumentmedium(nullable: true)
oppbevaringssted(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
avsluttetdato(nullable: true)
avsluttetav(nullable: true)
referanseforelder(nullable: true)
//referansebarnArkivdel(minSize: 1)
//referansebarnArkiv(minSize: 1)
}
static hasMany = [oppbevaringssted:String, referansebarnArkivdel:Arkivdel, referansebarnArkiv:Arkiv, subArkiv: Arkiv]
static mappedBy = [subArkiv:'forelder',referansebarnArkiv:'referanseforelder']

	def beforeUpdate = {
		println "referansebarnArkivdel ${referansebarnArkivdel} ${referansebarnArkivdel?.size()}"
		println "referansebarnArkiv ${referansebarnArkiv} ${referansebarnArkiv?.size()}"
    if(referansebarnArkivdel && referansebarnArkivdel.size() == 0) referansebarnArkivdel = null
		if(referansebarnArkiv && referansebarnArkiv.size() == 0) referansebarnArkiv = null
  }  
	static auditable = true
	static searchable = true

}
