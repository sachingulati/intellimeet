package com.ig.intellimeet

class SessionPreference {

    Long sessionId
    String sessionTitle

    List<Long> purposedAttendees
    List<Long> preferenceOneUserIds
    List<Long> preferenceTwoUserIds
    List<Long> preferenceThreeUserIds

    static mapWith = "mongo"
}
