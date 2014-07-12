package com.ig.intellimeet

class UserPreference {

    Long userId
    Long intelliMeetId
    String fullName
    String emailAddress
    Date dateCreated
    Date lastUpdated

    Long purposedSessionId

    Long firstPreferredSessionId
    Long secondPreferredSessionId
    Long thirdPreferredSessionId

    String firstPreferredSessionTitle
    String firstPreferredSessionOwners
    String secondPreferredSessionTitle
    String secondPreferredSessionOwners
    String thirdPreferredSessionTitle
    String thirdPreferredSessionOwners

    static mapWith = "mongo"

    static constraints = {
        fullName nullable: true
        purposedSessionId nullable: true
        firstPreferredSessionId nullable:true, validator: { val, obj ->
            if (val && (val == obj?.secondPreferredSessionId || val == obj?.thirdPreferredSessionId)) {
                return ['preference.unique.error']
            }
        }
        secondPreferredSessionId nullable:true, validator: { val, obj ->
            if (val && (val == obj?.firstPreferredSessionId || val == obj?.thirdPreferredSessionId)) {
                return ['preference.unique.error']
            }
        }
        thirdPreferredSessionId nullable:true, validator: { val, obj ->
            if (val && (val == obj?.firstPreferredSessionId || val == obj?.secondPreferredSessionId)) {
                return ['preference.unique.error']
            }
        }
        firstPreferredSessionTitle nullable: true
        firstPreferredSessionOwners nullable: true
        secondPreferredSessionTitle nullable: true
        secondPreferredSessionOwners nullable: true
        thirdPreferredSessionTitle nullable: true
        thirdPreferredSessionOwners nullable: true
    }

    void setFirstPreferredSessionId(Long firstPreferredSessionId) {
        this.firstPreferredSessionId = firstPreferredSessionId
        IMSession imSession = findSessionByIdAndIntelliMeetId firstPreferredSessionId, intelliMeetId
        this.firstPreferredSessionTitle = imSession?.title
        this.firstPreferredSessionOwners = imSession?.ownersEmail
    }

    void setSecondPreferredSessionId(Long secondPreferredSessionId) {
        this.secondPreferredSessionId = secondPreferredSessionId
        IMSession imSession = findSessionByIdAndIntelliMeetId firstPreferredSessionId, intelliMeetId
        this.secondPreferredSessionTitle = imSession?.title
        this.secondPreferredSessionOwners = imSession?.ownersEmail
    }

    void setThirdPreferredSessionId(Long thirdPreferredSessionId) {
        this.thirdPreferredSessionId = thirdPreferredSessionId
        IMSession imSession = findSessionByIdAndIntelliMeetId firstPreferredSessionId, intelliMeetId
        this.thirdPreferredSessionTitle = imSession?.title
        this.thirdPreferredSessionOwners = imSession?.ownersEmail
    }


    static String findSessionTitleByIdAndIntelliMeetId(Long sessionId, Long intelliMeetId) {
        findSessionByIdAndIntelliMeetId(sessionId, intelliMeetId)?.title
    }

    static IMSession findSessionByIdAndIntelliMeetId(Long sessionId, Long intelliMeetId) {
        IMSession.findByIdAndIntelliMeetId(sessionId, intelliMeetId)
    }

    void setUserId(Long userId) {
        this.userId = userId
        this.emailAddress = User.get(userId)?.username
    }

    Boolean checkIfAlreadyOpted(Long sessionId) {
        Boolean isOpted = false
        if (this.firstPreferredSessionId == sessionId || this.secondPreferredSessionId == sessionId || this.thirdPreferredSessionId == sessionId) {
            isOpted = true
        }
        isOpted
    }
}
