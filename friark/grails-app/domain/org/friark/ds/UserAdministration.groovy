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
    userRole(unique: true)
    createdDate(nullable: false)
    createdDate(unique: true)
    createdBy(nullable: true)
    createdBy(unique: true)
    finalisedDate(nullable: true)
    finalisedDate(unique: true)
    userStatus(nullable: true)
    userStatus(unique: true)
  }
  static hasMany = [:]
  static mapping = {
  }
}
