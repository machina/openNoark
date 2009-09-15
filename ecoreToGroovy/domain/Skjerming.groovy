class Skjerming {
  String tilgangsrestriksjon
  String skjermingshjemmel
    String skjermingdokument
  String skjermingsvarighet
  Date skjermingopphørerdato
static constraints = {
tilgangsrestriksjon(nullable: false)
skjermingshjemmel(nullable: false)
skjermingmetadata(minSize: 1)
skjermingdokument(nullable: true)
skjermingsvarighet(nullable: false)
skjermingopphørerdato(nullable: false)
}
static hasMany = [skjermingmetadata:String]
}
