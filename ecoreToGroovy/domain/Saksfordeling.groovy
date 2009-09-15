class Saksfordeling {
  String fordelttil
  String fordeltav
  String fordeltdato
static constraints = {
fordelttil(nullable: false)
fordeltav(nullable: false)
fordeltdato(nullable: false)
}
static hasMany = [:]
}
