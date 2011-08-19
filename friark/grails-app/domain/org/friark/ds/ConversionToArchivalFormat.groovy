/**
Metadata for konvertering til arkivformat
<br/>
Grupperes inn i:	Dokumentobjekt
Forekomst:		0-1
<br/>
Metadata for konvertering skal grupperes i metadata for dokumentobjekt. Konvertering er valgfritt, og kan forekomme en gang.
*/
package org.friark.ds
class ConversionToArchivalFormat {
  Date convertedDate
  String convertedBy
  String previousFormat
  String previousFormatDetails
  static constraints = {
    convertedDate(nullable: false)
    convertedDate(unique: false)
    convertedBy(nullable: false)
    convertedBy(unique: false)
    previousFormat(nullable: false)
    previousFormat(unique: false)
    previousFormatDetails(nullable: true)
    previousFormatDetails(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
