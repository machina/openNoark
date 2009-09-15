class ForenkletRegistrering {
  String systemid
  String registreringstype
  Date opprettetdato
  String opprettetav
  Date arkivertdato
  String arkivertav
  Basismappe referanseforelderBasismappe
  Klasse referanseforelderKlasse
  Arkivdel referansearkivdel
    static constraints = {
systemid(nullable: false)
registreringstype(nullable: false)
opprettetdato(nullable: false)
opprettetav(nullable: false)
arkivertdato(nullable: false)
arkivertav(nullable: false)
referanseforelderBasismappe(nullable: false)
referanseforelderKlasse(nullable: false)
referansearkivdel(nullable: true)
referansedokumentBeskrivelse(nullable: true)
referansedokumentObjekt(nullable: true)
}
static hasMany = [referansedokumentBeskrivelse:Dokumentbeskrivelse, referansedokumentObjekt:Dokumentobjekt]
}
