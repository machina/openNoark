package org.friark.ds
/**
Metadata for møtemappe amp;#xA;<br/> amp;#xA;Metadata for basismappe inngår i møtemappe, følgende metadata kommer i tillegg.
*/
class MeetingFile extends BasicFile{
  String meetingNumber
  String board
  Date meetingDate
  String meetingPlace
  BasicFile previousMeeting
  BasicFile nextMeeting
  static constraints = {
    meetingNumber(nullable: false)
    meetingNumber(unique: true)
    board(nullable: false)
    board(unique: true)
    meetingDate(nullable: false)
    meetingDate(unique: false)
    meetingPlace(nullable: true)
    meetingPlace(unique: false)
    previousMeeting(nullable: true)
    previousMeeting(unique: false)
    nextMeeting(nullable: true)
    nextMeeting(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
