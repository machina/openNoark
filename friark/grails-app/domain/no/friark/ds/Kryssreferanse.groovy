/**
Metadata for kryssreferanse
<br/>
Grupperes inn i:	Klasse, Basismappe, Basisregistrering
Forekomst:		0-M
<br/>
Referansen kan gå fra en klasse til en annen klasse, fra en mappe til en annen mappe, fra en registrering til en annen registrering, fra en mappe til en registrering og fra en registrering til en mappe. Kryssreferansen  vil også omfatte spesialiseringer.  En kryssreferanse kan derfor gå fra en møtemappe til en saksmappe. 
*/
package no.friark.ds
class Kryssreferanse {
  Klasse tilKlasse
  Klasse fraKlasse
  Basismappe fraMappe
  Basismappe tilMappe
  ForenkletRegistrering fraRegistrering
  ForenkletRegistrering tilRegistrering
  static constraints = {
    tilKlasse( validator: { val, obj ->
      if(val != null  && (obj.tilMappe != null || obj.tilRegistrering != null)) return "Kryssreferanser kan bare ha en til attributt."
      return true
    })
    tilMappe( validator: { val, obj ->
      if(val != null  && (obj.tilKlasse != null || obj.tilRegistrering != null)) return "Kryssreferanser kan bare ha en til attributt."
      return true
    })
    tilRegistrering( validator: { val, obj ->
      if(val != null  && (obj.tilMappe != null || obj.tilKlasse != null)) return "Kryssreferanser kan bare ha en til attributt."
      return true
    })
    fraKlasse( validator: { val, obj ->
      if(val != null  && (obj.fraMappe != null || obj.fraRegistrering != null)) return "Kryssreferanser kan bare ha en fra attributt."
      return true
    })
    fraMappe( validator: { val, obj ->
      if(val != null  && (obj.fraKlasse != null || obj.fraRegistrering != null)) return "Kryssreferanser kan bare ha en fra attributt."
      return true
    })
    fraRegistrering( validator: { val, obj ->
      if(val != null  && (obj.fraMappe != null || obj.fraKlasse != null)) return "Kryssreferanser kan bare ha en fra attributt."
      return true
    })
    tilKlasse(nullable: true)
    tilKlasse(unique: false)
    fraKlasse(nullable: true)
    fraKlasse(unique: false)
    fraMappe(nullable: true)
    fraMappe(unique: false)
    tilMappe(nullable: true)
    tilMappe(unique: false)
    fraRegistrering(nullable: true)
    fraRegistrering(unique: false)
    tilRegistrering(nullable: true)
    tilRegistrering(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
