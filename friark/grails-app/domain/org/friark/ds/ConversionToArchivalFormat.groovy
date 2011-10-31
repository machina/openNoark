package org.friark.ds
/**
Metadata for konvertering til arkivformat amp;#xA;<br/> amp;#xA;Grupperes inn i: Dokumentobjekt amp;#xA;Forekomst:  0-1 amp;#xA;<br/> amp;#xA;Metadata for konvertering skal grupperes i metadata for dokumentobjekt. Konvertering er valgfritt, og kan forekomme en gang.
*/
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
  static searchable = false
  static loggable = false
}
