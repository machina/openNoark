package org.friark.ds
/**
Metadata for møtedeltaker amp;#xA;<br/> amp;#xA;Grupperes inn i: Møtemappe amp;#xA;Forekomst:  1-M amp;#xA;
*/
class MeetingParticipant {
  String meetingParticipantName
  String meetingParticipantFunction
  static constraints = {
    meetingParticipantName(nullable: false)
    meetingParticipantName(unique: false)
    meetingParticipantFunction(nullable: false)
    meetingParticipantFunction(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
  static searchable = false
  static loggable = false
}
