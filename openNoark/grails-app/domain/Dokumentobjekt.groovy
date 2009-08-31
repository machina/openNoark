class Dokumentobjekt {
	Long id
  String systemid
  String versjonsnummer
  String variantformat
  String format
  String formatdetaljer
  Date opprettetdato
  String opprettetav
  Dokumentbeskrivelse referansedokumentBeskrivelse
  ForenkletRegistrering referanseregistrering
  String referansedokumentfil
  String sjekksumdokument
  String sjekksumalgoritme
  String filstørrelse
static constraints = {
systemid(nullable: false)
versjonsnummer(nullable: false)
variantformat(nullable: false)
format(nullable: false)
formatdetaljer(nullable: true)
opprettetdato(nullable: false)
opprettetav(nullable: false)
referansedokumentBeskrivelse(nullable: true)
referanseregistrering(nullable: true)
referansedokumentfil(nullable: false)
sjekksumdokument(nullable: false)
sjekksumalgoritme(nullable: false)
filstørrelse(nullable: false)
}
static hasMany = [:]
static auditable = true


}
