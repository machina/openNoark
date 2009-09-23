/**
Metadata for dokumentobjekt¤¤¤¤¤
 ¤¤¤¤¤

*/
class Dokumentobjekt extends Base{
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
    versjonsnummer(nullable: false)
    versjonsnummer(unique: true)
    variantformat(nullable: false)
    variantformat(unique: true)
    format(nullable: false)
    format(unique: true)
    formatdetaljer(nullable: true)
    formatdetaljer(unique: true)
    opprettetdato(nullable: false)
    opprettetdato(unique: true)
    opprettetav(nullable: false)
    opprettetav(unique: true)
    referansedokumentBeskrivelse(nullable: false)
    referansedokumentBeskrivelse(unique: true)
    referanseregistrering(nullable: false)
    referanseregistrering(unique: true)
    referansedokumentfil(nullable: false)
    referansedokumentfil(unique: true)
    sjekksumdokument(nullable: false)
    sjekksumdokument(unique: true)
    sjekksumalgoritme(nullable: false)
    sjekksumalgoritme(unique: true)
    filstørrelse(nullable: false)
    filstørrelse(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
  static auditable = true
}
