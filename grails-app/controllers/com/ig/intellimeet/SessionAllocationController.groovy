package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_IM_OWNER'])
class SessionAllocationController {

    IntelliMeetService intelliMeetService
    SessionAllocationService sessionAllocationService

    def show() {
        params?.sort = params?.sort?:'id'
        Long intelliMeetId = intelliMeetService.currentIntelliMeetId
        sessionAllocationService.saveSessionWisePreference intelliMeetId
        List<SessionPreference> sessionPreferenceList = SessionPreference.findAllByIntelliMeetId(intelliMeetId,params)
        render(view: "show", model: [sessionPreferenceList: sessionPreferenceList])
    }

    def saveAsDraft(AllocationCO allocationCO) {
        if(allocationCO.hasErrors()) {
            flash.error =  message code: 'allocation.error.message', default: 'Error allocating sessions! Please contact site administrator.'
        }
        sessionAllocationService.allocate allocationCO
        redirect action: 'show'
    }

    def save() {
        params.imsession.each { sessionId, ids ->
            if (sessionId.isInteger()) {
                List<Integer> attendeeIds = ids.get("attendeeIds") as List

            }
        }
        redirect(action: "show")
    }


}
