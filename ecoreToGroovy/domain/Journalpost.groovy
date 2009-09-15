class Journalpost extends Basisregistrering{
  String løpenummer
  String journalposttype
  String journalstatus
  Date journaldato
  Date dokumentetsdato
  Date mottattdato
  Date sendtdato
  Date forfallsdato
  Date offentlighetsvurdertdato
  String antallvedlegg
  Date utlåntdato
  String utlånttil
static constraints = {
løpenummer(nullable: false)
journalposttype(nullable: false)
journalstatus(nullable: false)
journaldato(nullable: false)
dokumentetsdato(nullable: true)
mottattdato(nullable: true)
sendtdato(nullable: true)
forfallsdato(nullable: true)
offentlighetsvurdertdato(nullable: true)
antallvedlegg(nullable: true)
utlåntdato(nullable: true)
utlånttil(nullable: true)
}
static hasMany = [:]
}
