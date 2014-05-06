package com.ig.intellimeet

import com.ig.intellimeet.dto.SessionPreference
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_IM_OWNER'])
class SessionAllocationController {

    IntelliMeetService intelliMeetService

    def show() {
        Long currentIntelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        List<UserPreference> userPreferences = UserPreference.findAllByIntelliMeetId(currentIntelliMeetId)

        Map<Long, SessionPreference> sessionPreferenceMap = [:]

        userPreferences.each { UserPreference userPreference ->

            SessionPreference firstSessionPreference = sessionPreferenceMap.get(userPreference.firstPreferredSessionId)
            if(firstSessionPreference == null) {
                firstSessionPreference = newSessionPreference(userPreference)
                firstSessionPreference.sessionId = userPreference.firstPreferredSessionId
                firstSessionPreference.sessionTitle = userPreference.firstPreferredSessionTitle
                sessionPreferenceMap.put(firstSessionPreference.sessionId, firstSessionPreference)
            }
            firstSessionPreference?.preferenceOneUserIds?.add(userPreference.userId)

            SessionPreference secondSessionPreference = sessionPreferenceMap.get(userPreference.secondPreferredSessionId)
            if(secondSessionPreference == null) {
                secondSessionPreference = newSessionPreference(userPreference)
                secondSessionPreference.sessionId = userPreference.secondPreferredSessionId
                secondSessionPreference.sessionTitle = userPreference.secondPreferredSessionTitle
                sessionPreferenceMap.put(secondSessionPreference.sessionId, secondSessionPreference)
            }
            secondSessionPreference?.preferenceTwoUserIds?.add(userPreference.userId)

            SessionPreference thirdSessionPreference = sessionPreferenceMap.get(userPreference.thirdPreferredSessionId)
            if(thirdSessionPreference == null) {
                thirdSessionPreference = newSessionPreference(userPreference)
                thirdSessionPreference.sessionId = userPreference.thirdPreferredSessionId
                thirdSessionPreference.sessionTitle = userPreference.thirdPreferredSessionTitle
                sessionPreferenceMap.put(thirdSessionPreference.sessionId, thirdSessionPreference)
            }
            thirdSessionPreference?.preferenceThreeUserIds?.add(userPreference.userId)
        }

        render(view: "sessionAllocation", model: [sessionPreferenceMap: sessionPreferenceMap] )
    }

    private SessionPreference newSessionPreference (UserPreference userPreference){
        SessionPreference sessionPreference = new SessionPreference()
        sessionPreference.preferenceOneUserIds = []
        sessionPreference.preferenceTwoUserIds = []
        sessionPreference.preferenceThreeUserIds = []
        return sessionPreference
    }
}
