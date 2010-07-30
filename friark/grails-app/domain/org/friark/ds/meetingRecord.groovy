/**
Metadata for møteregistrering
<br/>
Metadata for basisregistrering inngår i møteregistrering, følgende metadata kommer i tillegg.

*/
package org.friark.ds
class meetingRecord extends BasicRecord{
  String moeteregistreringstype
  String moetesakstype
  String moeteregistreringsstatus
  String administrativenhet
  String saksbehandler
  static constraints = {
    moeteregistreringstype(nullable: false)
    moeteregistreringstype(unique: true)
    moetesakstype(nullable: false)
    moetesakstype(unique: true)
    moeteregistreringsstatus(nullable: true)
    moeteregistreringsstatus(unique: true)
    administrativenhet(nullable: false)
    administrativenhet(unique: true)
    saksbehandler(nullable: false)
    saksbehandler(unique: true)
    toMeetingRecord(nullable: true)
    toMeetingRecord(unique: true)
    fromMeetingRecord(nullable: true)
    fromMeetingRecord(unique: true)
  }
  static hasMany = [toMeetingRecord:SimplifiedRecord, fromMeetingRecord:SimplifiedRecord]
  static mapping = {
  }
}
