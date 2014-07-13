package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_IM_OWNER'])
class SessionAllocationController {

    IntelliMeetService intelliMeetService
    SessionAllocationService sessionAllocationService

    def show() {
        Long intelliMeetId = intelliMeetService.currentIntelliMeetId
        sessionAllocationService.saveSessionWisePreference intelliMeetId
        List<SessionPreference> sessionPreferenceList = SessionPreference.findAllByIntelliMeetId intelliMeetId
        render(view: "show", model: [sessionPreferenceList: sessionPreferenceList])
    }

    def saveAsDraft(AllocationCO allocationCO) {
        if(!allocationCO.hasErrors()) {
            return
        }
        redirect action: 'show'
    }

    def save() {
        params.imsession.each { sessionId, ids ->
            if (sessionId.isInteger()) {
                List<Integer> attendeeIds = ids.get("attendeeIds") as List
                sessionAllocationService.savePurposedSessionAllocation(sessionId as Integer, attendeeIds)
                sessionAllocationService.freezeSessionAllocation(sessionId as Integer, attendeeIds)
            }
        }
        redirect(action: "show")
    }


}
