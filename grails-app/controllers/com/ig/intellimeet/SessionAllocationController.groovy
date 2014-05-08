package com.ig.intellimeet

import com.ig.intellimeet.dto.SessionPreference
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(['ROLE_IM_OWNER'])
class SessionAllocationController {

    IntelliMeetService intelliMeetService
    SessionAllocationService sessionAllocationService

    def show() {
        IntelliMeet intelliMeet = intelliMeetService.getCurrentIntelliMeet()
        Map<Long, SessionPreference> sessionPreferenceMap = sessionAllocationService.getSessionPreferences();
        render(view: "sessionAllocation", model: [sessionPreferenceMap: sessionPreferenceMap, intelliMeet: intelliMeet] )
    }

    @Transactional
    def saveAsDraft() {

        params.imsession.each { sessionId, ids ->
            if (sessionId.isInteger()) {
                List<Integer> attendeeIds = ids.get("attendeeIds") as List
                sessionAllocationService.savePurposedSessionAllocation(sessionId as Integer, attendeeIds)
            }
        }
        redirect( action: "show")
    }

    @Transactional
    def save() {
        params.imsession.each { sessionId, ids ->
            if (sessionId.isInteger()) {
                List<Integer> attendeeIds = ids.get("attendeeIds") as List
                sessionAllocationService.savePurposedSessionAllocation(sessionId as Integer, attendeeIds)
                sessionAllocationService.freezeSessionAllocation(sessionId as Integer, attendeeIds)
            }
        }
        redirect( action: "show")
    }


}
