/**
Metadata for kryssreferanse
<br/>
Grupperes inn i:	Klasse, Basismappe, Basisregistrering
Forekomst:		0-M
<br/>
Referansen kan gå fra en klasse til en annen klasse, fra en mappe til en annen mappe, fra en registrering til en annen registrering, fra en mappe til en registrering og fra en registrering til en mappe. Kryssreferansen  vil også omfatte spesialiseringer.  En kryssreferanse kan derfor gå fra en møtemappe til en saksmappe. 
*/
package org.friark.ds
class CrossReference {
  Klass toClass
  Klass fromClass
  BasicFile fromFile
  BasicFile toFile
  SimplifiedRecord toRecord
  SimplifiedRecord fromRecord
  static constraints = {
    toClass( validator: { val, obj ->
      if(val != null  && (obj.toFile != null || obj.toRecord != null)) return "Kryssreferanser kan bare ha en til attributt."
      return true
    })
    toFile( validator: { val, obj ->
      if(val != null  && (obj.toClass != null || obj.toRecord != null)) return "Kryssreferanser kan bare ha en til attributt."
      return true
    })
    toRecord( validator: { val, obj ->
      if(val != null  && (obj.toFile != null || obj.toClass != null)) return "Kryssreferanser kan bare ha en til attributt."
      return true
    })
    fromClass( validator: { val, obj ->
      if(val != null  && (obj.fromFile != null || obj.fromRecord != null)) return "Kryssreferanser kan bare ha en fra attributt."
      return true
    })
    fromFile( validator: { val, obj ->
      if(val != null  && (obj.fromClass != null || obj.fromRecord != null)) return "Kryssreferanser kan bare ha en fra attributt."
      return true
    })
    fromRecord( validator: { val, obj ->
      if(val != null  && (obj.fromFile != null || obj.fromClass != null)) return "Kryssreferanser kan bare ha en fra attributt."
      return true
    })
    toClass(nullable: true)
    toClass(unique: false)
    fromClass(nullable: true)
    fromClass(unique: false)
    fromFile(nullable: true)
    fromFile(unique: false)
    toFile(nullable: true)
    toFile(unique: false)
    toRecord(nullable: true)
    toRecord(unique: false)
    fromRecord(nullable: true)
    fromRecord(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
