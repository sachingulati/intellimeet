package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import com.ig.intellimeet.dto.PreferenceDTO
import com.ig.intellimeet.dto.SessionPreferenceDTO
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(SessionAllocationService)
@Mock([UserPreference])
class SessionAllocationServiceSpec extends Specification {

    def setup() {
        def intelliMeetServiceMock = mockFor(IntelliMeetService)
        intelliMeetServiceMock.demand.getCurrentIntelliMeetId() {->
            return 1l
        }
        service.intelliMeetService = intelliMeetServiceMock?.createMock()
    }

    def cleanup() {
    }

    void "test for generateAllocationCO(List<UserPreference>): AllocationCO"() {
        setup:
        AllocationCO allocationCO
        List<UserPreference> userPreferenceList = []
        List<SessionPreferenceDTO> expectedPreferenceDTOList = []

        when:
        userPreferenceList.add createUserPreference(1l, 1l, 2l, 3l)
        userPreferenceList.add createUserPreference(2l, 4l, 2l, 5l)
        userPreferenceList.add createUserPreference(3l, 1l, 4l, 5l)
        userPreferenceList.add createUserPreference(4l, 3l, 4l, 5l)
        userPreferenceList.add createUserPreference(5l, 6l, 9l, 5l)
        userPreferenceList.add createUserPreference(6l, 6l, 8l, 2l)
        allocationCO = service.generateAllocationCO(userPreferenceList)
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 1l, sessionTitle: "Session1", firstPreferenceUserIdList: [new PreferenceDTO(value: 1l), new PreferenceDTO(value: 3l)],
                secondPreferenceUserIdList: [],
                thirdPreferenceUserIdList: [])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 2l, sessionTitle: "Session2", firstPreferenceUserIdList: [],
                secondPreferenceUserIdList: [new PreferenceDTO(value: 1l), new PreferenceDTO(value: 2l)],
                thirdPreferenceUserIdList: [new PreferenceDTO(value: 6l)])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 3l, sessionTitle: "Session3", firstPreferenceUserIdList: [new PreferenceDTO(value: 4l)],
                secondPreferenceUserIdList: [],
                thirdPreferenceUserIdList: [new PreferenceDTO(value: 1l)])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 4l, sessionTitle: "Session4", firstPreferenceUserIdList:[new PreferenceDTO(value: 2l)],
                secondPreferenceUserIdList: [new PreferenceDTO(value: 3l), new PreferenceDTO(value: 4l)],
                thirdPreferenceUserIdList: [])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 5l, sessionTitle: "Session5", firstPreferenceUserIdList: [],
                secondPreferenceUserIdList: [],
                thirdPreferenceUserIdList: [new PreferenceDTO(value: 2l), new PreferenceDTO(value: 3l), new PreferenceDTO(value: 4l), new PreferenceDTO(value: 5l)])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 6l, sessionTitle: "Session6", firstPreferenceUserIdList: [new PreferenceDTO(value: 5l), new PreferenceDTO(value: 6l)],
                secondPreferenceUserIdList: [],
                thirdPreferenceUserIdList: [])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 8l, sessionTitle: "Session8", firstPreferenceUserIdList: [],
                secondPreferenceUserIdList: [new PreferenceDTO(value: 6l)],
                thirdPreferenceUserIdList: [])
        expectedPreferenceDTOList << new SessionPreferenceDTO(sessionId: 9l, sessionTitle: "Session9", firstPreferenceUserIdList: [],
                secondPreferenceUserIdList: [new PreferenceDTO(value: 5l)],
                thirdPreferenceUserIdList: [])

        then:
        assert userPreferenceList
        allocationCO.preferenceDTOList.size()  == expectedPreferenceDTOList.size()
        allocationCO.preferenceDTOList.sort{it.sessionTitle}  == expectedPreferenceDTOList.sort{it.sessionTitle}

    }

    UserPreference createUserPreference(Long userId, Long firstPreferredSessionId, Long secondPreferredSessionId, Long thirdPreferredSessionId) {
        new UserPreference(
                userId: userId,
                intelliMeetId: 1l,
                emailAddress: "${userId}@ig.com",
                firstPreferredSessionId: firstPreferredSessionId,
                firstPreferredSessionTitle: "Session${firstPreferredSessionId}",
                secondPreferredSessionId: secondPreferredSessionId,
                secondPreferredSessionTitle: "Session${secondPreferredSessionId}",
                thirdPreferredSessionId: thirdPreferredSessionId,
                thirdPreferredSessionTitle: "Session${thirdPreferredSessionId}"
        )
    }
}
