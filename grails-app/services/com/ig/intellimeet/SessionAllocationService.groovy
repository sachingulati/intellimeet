package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import com.ig.intellimeet.dto.PreferenceDTO
import com.ig.intellimeet.dto.SessionPreferenceDTO
import com.mongodb.*
import grails.transaction.Transactional

@Transactional
class SessionAllocationService {

    def intelliMeetService
    def sessionPreferenceService

    Map<Long, SessionPreference> getSessionPreferences() {

        Long currentIntelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        List<UserPreference> userPreferences = UserPreference.findAllByIntelliMeetId(currentIntelliMeetId)

        Map<Long, SessionPreference> sessionPreferenceMap = [:]

        userPreferences.each { UserPreference userPreference ->

            SessionPreference firstSessionPreference = sessionPreferenceMap.get(userPreference.firstPreferredSessionId)
            if (firstSessionPreference == null) {
                firstSessionPreference = newSessionPreference(userPreference, currentIntelliMeetId)
                firstSessionPreference.sessionId = userPreference.firstPreferredSessionId
                firstSessionPreference.sessionTitle = UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreference.firstPreferredSessionId, currentIntelliMeetId)
                sessionPreferenceMap.put(firstSessionPreference.sessionId, firstSessionPreference)
            }
            firstSessionPreference?.preferenceOneUserIds?.add(userPreference.userId)

            SessionPreference secondSessionPreference = sessionPreferenceMap.get(userPreference.secondPreferredSessionId)
            if (secondSessionPreference == null) {
                secondSessionPreference = newSessionPreference(userPreference, currentIntelliMeetId)
                secondSessionPreference.sessionId = userPreference.secondPreferredSessionId
                secondSessionPreference.sessionTitle = UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreference.secondPreferredSessionId, currentIntelliMeetId)
                sessionPreferenceMap.put(secondSessionPreference.sessionId, secondSessionPreference)
            }
            secondSessionPreference?.preferenceTwoUserIds?.add(userPreference.userId)

            SessionPreference thirdSessionPreference = sessionPreferenceMap.get(userPreference.thirdPreferredSessionId)
            if (thirdSessionPreference == null) {
                thirdSessionPreference = newSessionPreference(userPreference, currentIntelliMeetId)
                thirdSessionPreference.sessionId = userPreference.thirdPreferredSessionId
                thirdSessionPreference.sessionTitle = UserPreference.findSessionTitleByIdAndIntelliMeetId(userPreference.thirdPreferredSessionId, currentIntelliMeetId)
                sessionPreferenceMap.put(thirdSessionPreference.sessionId, thirdSessionPreference)
            }
            thirdSessionPreference?.preferenceThreeUserIds?.add(userPreference.userId)

            if (firstSessionPreference.sessionId.equals(userPreference.purposedSessionId)) {
                firstSessionPreference.purposedAttendees.add(userPreference.userId)
            } else if (secondSessionPreference.sessionId.equals(userPreference.purposedSessionId)) {
                secondSessionPreference.purposedAttendees.add(userPreference.userId)
            } else if (thirdSessionPreference.sessionId.equals(userPreference.purposedSessionId)) {
                thirdSessionPreference.purposedAttendees.add(userPreference.userId)
            }
        }
        return sessionPreferenceMap
    }

    AllocationCO generateAllocationCO(List<UserPreference> userPreferenceList) {
        AllocationCO allocationCO = new AllocationCO()
        PreferenceDTO preferenceDTO
        userPreferenceList?.each { UserPreference userPreference ->
            preferenceDTO = new PreferenceDTO(email: userPreference?.emailAddress, value: userPreference?.userId)

            SessionPreferenceDTO firstSessionPreferenceDTO = allocationCO?.preferenceDTOList?.find {
                it.sessionId == userPreference?.firstPreferredSessionId
            }
            if (!firstSessionPreferenceDTO) {
                firstSessionPreferenceDTO = new SessionPreferenceDTO(sessionId: userPreference?.firstPreferredSessionId, sessionTitle: userPreference?.firstPreferredSessionTitle, firstPreferenceUserIdList: [], secondPreferenceUserIdList: [], thirdPreferenceUserIdList: [])
                firstSessionPreferenceDTO?.firstPreferenceUserIdList << preferenceDTO
                allocationCO?.preferenceDTOList?.add firstSessionPreferenceDTO
            } else {
                firstSessionPreferenceDTO?.firstPreferenceUserIdList << preferenceDTO
            }

            SessionPreferenceDTO secondSessionPreferenceDTO = allocationCO?.preferenceDTOList?.find {
                it.sessionId == userPreference?.secondPreferredSessionId
            }
            if (!secondSessionPreferenceDTO) {
                secondSessionPreferenceDTO = new SessionPreferenceDTO(sessionId: userPreference?.secondPreferredSessionId, sessionTitle: userPreference?.secondPreferredSessionTitle, firstPreferenceUserIdList: [], secondPreferenceUserIdList: [], thirdPreferenceUserIdList: [])
                secondSessionPreferenceDTO?.secondPreferenceUserIdList << preferenceDTO
                allocationCO?.preferenceDTOList?.add secondSessionPreferenceDTO
            } else {
                secondSessionPreferenceDTO?.secondPreferenceUserIdList << preferenceDTO
            }


            SessionPreferenceDTO thirdSessionPreferenceDTO = allocationCO?.preferenceDTOList?.find {
                it.sessionId == userPreference?.thirdPreferredSessionId
            }
            if (!thirdSessionPreferenceDTO) {
                thirdSessionPreferenceDTO = new SessionPreferenceDTO(sessionId: userPreference?.thirdPreferredSessionId, sessionTitle: userPreference?.thirdPreferredSessionTitle, firstPreferenceUserIdList: [], secondPreferenceUserIdList: [], thirdPreferenceUserIdList: [])
                thirdSessionPreferenceDTO?.thirdPreferenceUserIdList << preferenceDTO
                allocationCO?.preferenceDTOList?.add thirdSessionPreferenceDTO
            } else {
                thirdSessionPreferenceDTO?.thirdPreferenceUserIdList << preferenceDTO
            }

        }
        allocationCO
    }

    void saveSessionWisePreference(Long intelliMeetId) {
        MapReduceOutput output = calculateUserPreferencesGroupedBySession intelliMeetId
        SessionPreference sessionPreference
        IMSession session
        for (DBObject object : output?.results()) {
            sessionPreference = new SessionPreference()
            sessionPreference?.with {
                session = IMSession.get((Long)object['_id'])
                if(session) {
                    sessionId = object['_id'] as Long
                    sessionTitle = session?.title
                    sessionOwners = session?.ownersEmail
                    preferenceOneUserIds = object['value']['preferenceOneUserIds'] as List<Long>
                    preferenceTwoUserIds = object['value']['preferenceTwoUserIds'] as List<Long>
                    preferenceThreeUserIds = object['value']['preferenceThreeUserIds'] as List<Long>
                }
            }
            sessionPreferenceService.save sessionPreference
        }
    }

    MapReduceOutput calculateUserPreferencesGroupedBySession(Long intelliMeeId) {
        DBCollection userPreferenceCollection = UserPreference.collection
        String map = """
function() {
    emit(this.firstPreferredSessionId, {'preferenceOneUserIds': [this.userId]});
    emit(this.secondPreferredSessionId, {'preferenceTwoUserIds': [this.userId]});
    emit(this.thirdPreferredSessionId, {'preferenceThreeUserIds': [this.userId]});
}
"""
        String reduce = """
function(key,values) {
    var result = {'preferenceOneUserIds': [], 'preferenceTwoUserIds': [], 'preferenceThreeUserIds': []};
    values.forEach(function(val) {
        if('preferenceOneUserIds' in val) {
            result.preferenceOneUserIds = result.preferenceOneUserIds.concat(val.preferenceOneUserIds);
        }
        if('preferenceTwoUserIds' in val) {
            result.preferenceTwoUserIds = result.preferenceTwoUserIds.concat(val.preferenceTwoUserIds);
        }
        if('preferenceThreeUserIds' in val) {
            result.preferenceThreeUserIds = result.preferenceThreeUserIds.concat(val.preferenceThreeUserIds);
        }
    });
    return result;
}
"""
        BasicDBObject query = new BasicDBObject('intelliMeetId', intelliMeeId)
        MapReduceCommand cmd = new MapReduceCommand(userPreferenceCollection, map, reduce, null, MapReduceCommand.OutputType.INLINE, query);
        userPreferenceCollection.mapReduce(cmd);
    }

    UserPreference savePurposedSessionAllocation(Integer sessionId, List attendeeIds) {
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

    IMSession freezeSessionAllocation(Integer sessionId, List attendeeIds) {
        IntelliMeet intelliMeet = intelliMeetService.getCurrentIntelliMeet()
        IMSession imSession = IMSession.findByIntelliMeetIdAndId(intelliMeet.id, sessionId)
        imSession.attendeeIds = []
        attendeeIds.each { id ->
            imSession.attendeeIds.add(id)
        }
        imSession = imSession.save(flush: true)
        imSession
    }

    private SessionPreference newSessionPreference(UserPreference userPreference, Long currentIntelliMeetId) {
        SessionPreference sessionPreference = new SessionPreference()
        sessionPreference.preferenceOneUserIds = []
        sessionPreference.preferenceTwoUserIds = []
        sessionPreference.preferenceThreeUserIds = []
        sessionPreference.purposedAttendees = []

        return sessionPreference
    }

}
