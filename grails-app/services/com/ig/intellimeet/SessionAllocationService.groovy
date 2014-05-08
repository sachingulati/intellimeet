package com.ig.intellimeet

import com.ig.intellimeet.dto.SessionPreference
import grails.transaction.Transactional

@Transactional
class SessionAllocationService {

    IntelliMeetService intelliMeetService

    /**
     * <p>Returns the session preference of users for current intellimeet
     * in map where session id is as key and {@link SessionPreference} is as value</p>
     * <p>Session preference contain user ids for first, second and third preference in seperate list.
     * It also contains purposed attendee ids.</p>
     * @return {@link Map} of {@link SessionPreference} with session id as key
     */
    Map<Long, SessionPreference> getSessionPreferences() {

        Long currentIntelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        List<UserPreference> userPreferences = UserPreference.findAllByIntelliMeetId(currentIntelliMeetId)

        Map<Long, SessionPreference> sessionPreferenceMap = [:]

        userPreferences.each { UserPreference userPreference ->

            SessionPreference firstSessionPreference = sessionPreferenceMap.get(userPreference.firstPreferredSessionId)
            if(firstSessionPreference == null) {
                firstSessionPreference = newSessionPreference(userPreference, currentIntelliMeetId)
                firstSessionPreference.sessionId = userPreference.firstPreferredSessionId
                firstSessionPreference.sessionTitle = UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreference.firstPreferredSessionId,currentIntelliMeetId)
                sessionPreferenceMap.put(firstSessionPreference.sessionId, firstSessionPreference)
            }
            firstSessionPreference?.preferenceOneUserIds?.add(userPreference.userId)

            SessionPreference secondSessionPreference = sessionPreferenceMap.get(userPreference.secondPreferredSessionId)
            if(secondSessionPreference == null) {
                secondSessionPreference = newSessionPreference(userPreference, currentIntelliMeetId)
                secondSessionPreference.sessionId = userPreference.secondPreferredSessionId
                secondSessionPreference.sessionTitle = UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreference.secondPreferredSessionId,currentIntelliMeetId)
                sessionPreferenceMap.put(secondSessionPreference.sessionId, secondSessionPreference)
            }
            secondSessionPreference?.preferenceTwoUserIds?.add(userPreference.userId)

            SessionPreference thirdSessionPreference = sessionPreferenceMap.get(userPreference.thirdPreferredSessionId)
            if(thirdSessionPreference == null) {
                thirdSessionPreference = newSessionPreference(userPreference, currentIntelliMeetId)
                thirdSessionPreference.sessionId = userPreference.thirdPreferredSessionId
                thirdSessionPreference.sessionTitle = UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreference.thirdPreferredSessionId,currentIntelliMeetId)
                sessionPreferenceMap.put(thirdSessionPreference.sessionId, thirdSessionPreference)
            }
            thirdSessionPreference?.preferenceThreeUserIds?.add(userPreference.userId)

            if(firstSessionPreference.sessionId.equals(userPreference.purposedSessionId)) {
                 firstSessionPreference.purposedAttendees.add(userPreference.userId)
            } else if (secondSessionPreference.sessionId.equals(userPreference.purposedSessionId)) {
                secondSessionPreference.purposedAttendees.add(userPreference.userId)
            } else if (thirdSessionPreference.sessionId.equals(userPreference.purposedSessionId)) {
                thirdSessionPreference.purposedAttendees.add(userPreference.userId)
            }
        }
        return sessionPreferenceMap
    }

    UserPreference savePurposedSessionAllocation(Integer sessionId, List attendeeIds){
        Long intelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        UserPreference userPreference = null
        attendeeIds.each { id ->
            userPreference = UserPreference.findByIntelliMeetIdAndUserId(intelliMeetId, id)
            println(userPreference)
            userPreference?.purposedSessionId = sessionId
            userPreference = userPreference?.save(flush: true)
        }
        userPreference
    }

    IMSession freezeSessionAllocation(Integer sessionId, List attendeeIds){
        IntelliMeet intelliMeet = intelliMeetService.getCurrentIntelliMeet()
        IMSession imSession = IMSession.findByIntelliMeetIdAndId(intelliMeet.id, sessionId)
        imSession.attendeeIds = []
        attendeeIds.each { id ->
            imSession.attendeeIds.add(id)
        }
        imSession = imSession.save(flush: true)
        imSession
    }

    private SessionPreference newSessionPreference (UserPreference userPreference, Long currentIntelliMeetId){
        SessionPreference sessionPreference = new SessionPreference()
        sessionPreference.preferenceOneUserIds = []
        sessionPreference.preferenceTwoUserIds = []
        sessionPreference.preferenceThreeUserIds = []
        sessionPreference.purposedAttendees = []

        return sessionPreference
    }

}
