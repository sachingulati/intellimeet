package com.ig.intellimeet

class SessionPreference {

    Long intelliMeetId
    Long sessionId
    String sessionTitle
    String sessionOwners

    List<Long> purposedAttendees
    List<Long> preferenceOneUserIds
    List<Long> preferenceTwoUserIds
    List<Long> preferenceThreeUserIds

    static mapWith = "mongo"
}
