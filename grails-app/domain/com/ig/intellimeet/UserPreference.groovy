package com.ig.intellimeet

class UserPreference {

    Long userId
    Long intelliMeetId
    String fullName
    String emailAddress
    Date dateCreated
    Date lastUpdated

    Long firstPreferredSessionId
    Long secondPreferredSessionId
    Long thirdPreferredSessionId

    String firstPreferredSessionTitle
    String secondPreferredSessionTitle
    String thirdPreferredSessionTitle

    static constraints = {
        fullName nullable: true
        firstPreferredSessionId validator: { val, obj ->
            if (val == obj?.secondPreferredSessionId || val == obj?.thirdPreferredSessionId) {
                return ['preference.unique.error']
            }
        }
        secondPreferredSessionId validator: { val, obj ->
            if (val == obj?.firstPreferredSessionId || val == obj?.thirdPreferredSessionId) {
                return ['preference.unique.error']
            }
        }
        thirdPreferredSessionId validator: { val, obj ->
            if (val == obj?.firstPreferredSessionId || val == obj?.secondPreferredSessionId) {
                return ['preference.unique.error']
            }
        }
    }

    void setFirstPreferredSessionId(Long firstPreferredSessionId) {
        this.firstPreferredSessionId = firstPreferredSessionId
        this.firstPreferredSessionTitle = findSessionTitleByIdAndIntelliMeetId(firstPreferredSessionId, intelliMeetId)
    }

    void setSecondPreferredSessionId(Long secondPreferredSessionId) {
        this.secondPreferredSessionId = secondPreferredSessionId
        this.secondPreferredSessionTitle = findSessionTitleByIdAndIntelliMeetId(secondPreferredSessionId, intelliMeetId)
    }

    void setThirdPreferredSessionId(Long thirdPreferredSessionId) {
        this.thirdPreferredSessionId = thirdPreferredSessionId
        this.thirdPreferredSessionTitle = findSessionTitleByIdAndIntelliMeetId(thirdPreferredSessionId, intelliMeetId)
    }


    static String findSessionTitleByIdAndIntelliMeetId(Long sessionId, Long intelliMeetId) {
        IMSession.findByIdAndIntelliMeetId(sessionId, intelliMeetId)?.title
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
