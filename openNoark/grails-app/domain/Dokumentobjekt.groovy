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
    referansedokumentBeskrivelse( validator: { val, obj ->
      if(obj.referansedokumentBeskrivelse == null && obj.referanseregistrering == null) return "Dokumentobjekt må være tinknyttet enten et dokumentobjekt eller en registrering."
      if(obj.referansedokumentBeskrivelse != null && obj.referanseregistrering != null) return "Dokumentobjekt må være tinknyttet enten et dokumentobjekt eller en registrering."
      return true
    })
    versjonsnummer(nullable: false)
    versjonsnummer(unique: false)
    variantformat(nullable: false)
    variantformat(unique: false)
    format(nullable: false)
    format(unique: false)
    formatdetaljer(nullable: true)
    formatdetaljer(unique: false)
    opprettetdato(nullable: false)
    opprettetdato(unique: false)
    opprettetav(nullable: false)
    opprettetav(unique: false)
    referansedokumentBeskrivelse(nullable: true)
    referansedokumentBeskrivelse(unique: false)
    referanseregistrering(nullable: true)
    referanseregistrering(unique: false)
    referansedokumentfil(nullable: true)
    referansedokumentfil(unique: false)
    sjekksumdokument(nullable: true)
    sjekksumdokument(unique: false)
    sjekksumalgoritme(nullable: true)
    sjekksumalgoritme(unique: false)
    filstørrelse(nullable: true)
    filstørrelse(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static auditable = true
}
