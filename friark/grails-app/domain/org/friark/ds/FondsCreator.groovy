package org.friark.ds
/**
Metadata for arkivskaper amp;#xA; amp;#xA;Grupperes inn i: Arkiv amp;#xA;Forekomst:  1-M amp;#xA;
*/
class FondsCreator {
  String fondsCreatorID
  String fondsCreatorName
  String description
  static constraints = {
    fondsCreatorID(nullable: false)
    fondsCreatorID(unique: true)
    fondsCreatorName(nullable: false)
    fondsCreatorName(unique: true)
    description(nullable: true)
    description(unique: false)
    fonds(nullable: true)
    fonds(unique: false)
  }
  static hasMany = [fonds:Fonds]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
