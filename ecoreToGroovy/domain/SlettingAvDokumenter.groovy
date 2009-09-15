class SlettingAvDokumenter {
  String slettingstype
  Date slettetdato
  String slettetav
static constraints = {
slettingstype(nullable: false)
slettetdato(nullable: false)
slettetav(nullable: false)
}
static hasMany = [:]
}
