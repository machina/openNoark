/**
Metadata for journalpost

Metadata for basisregistrering inngår i journalpost, følgende metadata kommer i tillegg.
*/
package no.friark.ds
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
    løpenummer(unique: true)
    journalposttype(nullable: false)
    journalposttype(unique: true)
    journalstatus(nullable: false)
    journalstatus(unique: true)
    journaldato(nullable: false)
    journaldato(unique: true)
    dokumentetsdato(nullable: true)
    dokumentetsdato(unique: true)
    mottattdato(nullable: true)
    mottattdato(unique: true)
    sendtdato(nullable: true)
    sendtdato(unique: true)
    forfallsdato(nullable: true)
    forfallsdato(unique: true)
    offentlighetsvurdertdato(nullable: true)
    offentlighetsvurdertdato(unique: true)
    antallvedlegg(nullable: true)
    antallvedlegg(unique: true)
    utlåntdato(nullable: true)
    utlåntdato(unique: true)
    utlånttil(nullable: true)
    utlånttil(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
