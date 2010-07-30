/**
Metadata for møtemappe
<br/>
Metadata for basismappe inngår i møtemappe, følgende metadata kommer i tillegg.
*/
package org.friark.ds
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
    meetingDate(unique: true)
    meetingPlace(nullable: true)
    meetingPlace(unique: true)
    previousMeeting(nullable: true)
    previousMeeting(unique: true)
    nextMeeting(nullable: true)
    nextMeeting(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
