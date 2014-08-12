package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import com.ig.intellimeet.utils.TestUtil
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([SessionPreference])
@TestFor(SessionAllocationController)
class SessionAllocationControllerSpec extends Specification {


    void setup() {
        def sessionAllocationServiceMock = mockFor(SessionAllocationService)
        sessionAllocationServiceMock.demand.allocate(1..1) {AllocationCO allocationCO->
            return true
        }
        controller.sessionAllocationService = sessionAllocationServiceMock.createMock()
    }

    def "SessionAllocationController: saveAsDraft(AllocationCO), Check redirect"() {

        setup:
        Long intelliMeetId = 10l
        loadSomeSessionPreferences intelliMeetId
        Map paramsMap
        AllocationCO allocationCO = new AllocationCO()

        when:
        params.preferences = SAMPLE_PARAMS_MAP.preferences
        controller.saveAsDraft allocationCO

        then:
        flash.error == null
        response.redirectedUrl == '/sessionAllocation/show'
    }

    def "SessionAllocationController: saveAsDraft(AllocationCO), Data Binding"() {

        setup:
        Long intelliMeetId = 10l
        loadSomeSessionPreferences intelliMeetId
        Map paramsMap
        AllocationCO allocationCO = new AllocationCO()

        when:
        params.preferences = SAMPLE_PARAMS_MAP.preferences
        controller.saveAsDraft allocationCO

        then:
        flash.error == null
        response.redirectedUrl == '/sessionAllocation/show'
    }

    static final Map<String, ?> SAMPLE_PARAMS_MAP = [
            "preferences": [
                    ["sessionId": 1l, "attendees": [1, 2, 3, 4]],
                    ["sessionId": 2l, "attendees": [5, 6]],
                    ["sessionId": 3l, "attendees": [8, 9]],
                    ["sessionId": 4l, "attendees": [15, 7, 11]],
                    ["sessionId": 5l, "attendees": [14, 13]]
            ]
    ]

    static void loadSomeSessionPreferences(Long intelliMeetId) {
        createSessionPreferences intelliMeetId, 1l
        createSessionPreferences intelliMeetId, 2l
        createSessionPreferences intelliMeetId, 3l
        createSessionPreferences intelliMeetId, 4l
        createSessionPreferences intelliMeetId, 5l
    }

    static void createSessionPreferences(Long intelliMeetId, Long sessionId) {
        SessionPreference sessionPreference = TestUtil.createSessionPreference intelliMeetId
        sessionPreference.sessionId = sessionId
        sessionPreference.save(failOnError: true, flush: true)
    }

}
