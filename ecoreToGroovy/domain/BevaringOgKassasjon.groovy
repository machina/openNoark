class BevaringOgKassasjon {
  String kassasjonsvedtak
  String kassasjonshjemmel
  String bevaringstid
  Date kassasjonsdato
static constraints = {
kassasjonsvedtak(nullable: false)
kassasjonshjemmel(nullable: true)
bevaringstid(nullable: false)
kassasjonsdato(nullable: false)
}
static hasMany = [:]
}
