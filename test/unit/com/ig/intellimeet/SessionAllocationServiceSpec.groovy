package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import com.ig.intellimeet.dto.IMSessionPreference
import com.ig.intellimeet.utils.TestUtil
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(SessionAllocationService)
@Mock([UserPreference, SessionPreference])
class SessionAllocationServiceSpec extends Specification {

    void setup() {
        def sessionPreferenceServiceMock = mockFor(SessionPreferenceService)
        sessionPreferenceServiceMock.demand.save(1..10) { SessionPreference sessionPreference ->
            sessionPreference?.save(failOnError: true, flush: true)
        }
        service.sessionPreferenceService = sessionPreferenceServiceMock.createMock()
    }

    def "SessionAllocationService: allocate(AllocationCO allocationCO), void"() {

        setup:
        Long intelliMeetId = 11l
        loadSomeSessionPreferences intelliMeetId
        AllocationCO allocationCO

        when:
        allocationCO = new AllocationCO()
        allocationCO.preferences = []
        allocationCO.preferences << new IMSessionPreference(sessionId: 1l, attendees: [11, 21, 31])
        allocationCO.preferences << new IMSessionPreference(sessionId: 2l, attendees: [51, 61])
        service.allocate allocationCO

        then:
        SessionPreference.get(1l).purposedAttendees == [11, 21, 31] // Check if attendees being saved into IMSession

    }

    @Unroll("#sno, Testing SessionAllocationService: updateProposedAttendees(IMSessionPreference imSessionPreference), void")
    def "SessionAllocationService: updateProposedAttendees(IMSessionPreference imSessionPreference), void"() {
        setup:
        Long intelliMeetId = 10l
        loadSomeSessionPreferences intelliMeetId
        IMSessionPreference imSessionPreference

        when:
        imSessionPreference = new IMSessionPreference(
                sessionId: sessionId,
                attendees: attendees
        )
        service.updateProposedAttendees imSessionPreference

        then:
        SessionPreference.get(sessionId)?.purposedAttendees == attendees

        where:
        sno | sessionId | attendees
        1   | 1l        | [2l, 3l]
        2   | 2l        | [4l, 5l]
        3   | null      | null
    }

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
