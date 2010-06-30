/**
Metadata for konvertering til arkivformat
<br/>
Grupperes inn i:	Dokumentobjekt
Forekomst:		0-1
<br/>
Metadata for konvertering skal grupperes i metadata for dokumentobjekt. Konvertering er valgfritt, og kan forekomme en gang.
*/
package no.friark.ds
class ConversionToArchivalFormat {
  Date convertedDate
  String convertedBy
  String previousFormat
  String previousFormatDetails
  static constraints = {
    convertedDate(nullable: false)
    convertedDate(unique: true)
    convertedBy(nullable: false)
    convertedBy(unique: true)
    previousFormat(nullable: false)
    previousFormat(unique: true)
    previousFormatDetails(nullable: true)
    previousFormatDetails(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
