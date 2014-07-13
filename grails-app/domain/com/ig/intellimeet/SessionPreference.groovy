package com.ig.intellimeet

import com.ig.intellimeet.enums.AllocationStatus

class SessionPreference {

    Long intelliMeetId
    Long sessionId
    String sessionTitle
    String sessionOwners

    AllocationStatus status

    List<Long> purposedAttendees
    List<Long> preferenceOneUserIds
    List<Long> preferenceTwoUserIds
    List<Long> preferenceThreeUserIds

    static mapWith = "mongo"

    static constraints = {
        intelliMeetId nullable: false
        sessionId nullable: false
        sessionTitle nullable: false
        sessionOwners nullable: false
        status nullable: true
    }
}
