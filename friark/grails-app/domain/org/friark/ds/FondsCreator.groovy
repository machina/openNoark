/**
Metadata for arkivskaper

Grupperes inn i:	Arkiv
Forekomst:		1-M

*/
package org.friark.ds
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
    description(unique: true)
    fonds(nullable: true)
    fonds(unique: false)
  }
  static hasMany = [fonds:Fonds]
  static mapping = {
  }
  static searchable = [except: ['arkiv']]
}
