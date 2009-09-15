class VerifiseringAvElektroniskSignatur {
  String elektronisksignaturSikkerhetsnivå
  String elektronisksignaturVerfisert
  Date verifisertdato
  String verfisertav
static constraints = {
elektronisksignaturSikkerhetsnivå(nullable: false)
elektronisksignaturVerfisert(nullable: false)
verifisertdato(nullable: false)
verfisertav(nullable: false)
}
static hasMany = [:]
}
