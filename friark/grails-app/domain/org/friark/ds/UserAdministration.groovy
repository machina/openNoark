/**
Metadata for brukeradministrasjon

Metadata for brukeradministrasjon skal ikke avleveres, men skal kunne migreres mellom systemer. Slik migrering kan omfatte flere metadata en det som er listet opp her.
*/
package org.friark.ds
class UserAdministration {
  String userName
  String userRole
  Date createdDate
  String createdBy
  Date finalisedDate
  String userStatus
  static constraints = {
    userName(nullable: false)
    userName(unique: true)
    userRole(nullable: false)
    userRole(unique: false)
    createdDate(nullable: false)
    createdDate(unique: false)
    createdBy(nullable: true)
    createdBy(unique: false)
    finalisedDate(nullable: true)
    finalisedDate(unique: false)
    userStatus(nullable: true)
    userStatus(unique: false)
  }
  static hasMany = [:]
  static mapping = {
  }
}
