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

    static constraints = {
        fullName nullable: true
        purposedSessionId nullable: true
        firstPreferredSessionId validator: {val, obj->
            if(val == obj?.secondPreferredSessionId || val == obj?.thirdPreferredSessionId) {
                return ['preference.unique.error']
            }
        }
        secondPreferredSessionId validator: {val, obj->
            if(val == obj?.firstPreferredSessionId || val == obj?.thirdPreferredSessionId) {
                return ['preference.unique.error']
            }
        }
        thirdPreferredSessionId validator: {val, obj->
            if(val == obj?.firstPreferredSessionId || val == obj?.secondPreferredSessionId) {
                return ['preference.unique.error']
            }
        }
    }

    void setFirstPreferredSessionId(Long firstPreferredSessionId) {
        this.firstPreferredSessionId = firstPreferredSessionId
    }

    void setSecondPreferredSessionId(Long secondPreferredSessionId) {
        this.secondPreferredSessionId = secondPreferredSessionId
    }

    void setThirdPreferredSessionId(Long thirdPreferredSessionId) {
        this.thirdPreferredSessionId = thirdPreferredSessionId
    }


    static String findSessionTitleByIdAndIntelliMeetId(Long sessionId, Long intelliMeetId) {
        IMSession.findByIdAndIntelliMeetId(sessionId, intelliMeetId)?.title
    }

    void setUserId(Long userId) {
        this.userId = userId
        this.emailAddress  = User.findById(userId)?.username
    }
}
