/**
Metadata for møtedeltaker
<br/>
Grupperes inn i:	Møtemappe
Forekomst:		1-M

*/
package org.friark.ds
class MeetingParticipant {
  String meetingParticipantName
  String meetingParticipantFunction
  static constraints = {
    meetingParticipantName(nullable: false)
    meetingParticipantName(unique: true)
    meetingParticipantFunction(nullable: false)
    meetingParticipantFunction(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
