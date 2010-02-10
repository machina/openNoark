/**
Metadata for utført kassasjon
<br/>
Grupperes inn i:	Dokumentbeskrivelse<br/>
Forekomst:		0-1

Ved kassasjon skal dokumentobjektet slettes. 

*/
package no.friark.ds
class UtførtKassasjon {
  Date kassertdato
  String kassertav
  static constraints = {
    kassertdato(nullable: false)
    kassertdato(unique: true)
    kassertav(nullable: false)
    kassertav(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
