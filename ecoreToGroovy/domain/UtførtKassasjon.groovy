class UtførtKassasjon {
  Date kassertdato
  String kassertav
static constraints = {
kassertdato(nullable: false)
kassertav(nullable: false)
}
static hasMany = [:]
}
