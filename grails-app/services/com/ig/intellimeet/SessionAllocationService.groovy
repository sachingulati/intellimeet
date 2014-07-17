package com.ig.intellimeet

import com.ig.intellimeet.co.AllocationCO
import com.ig.intellimeet.dto.IMSessionPreference
import com.mongodb.*
import grails.transaction.Transactional

@Transactional
class SessionAllocationService {

    def intelliMeetService
    def sessionPreferenceService

    void allocate(AllocationCO allocationCO) {
        allocationCO?.preferences?.each {IMSessionPreference imSessionPreference->
            updateProposedAttendees imSessionPreference
        }
    }

    void updateProposedAttendees(IMSessionPreference imSessionPreference) {
        SessionPreference sessionPreference = SessionPreference.findBySessionId(imSessionPreference?.sessionId)
        if(sessionPreference) {
            sessionPreference.purposedAttendees = imSessionPreference.attendees
        }
        sessionPreferenceService.save sessionPreference
    }

    void saveSessionWisePreference(Long intelliMeetId) {
        MapReduceOutput output = calculateUserPreferencesGroupedBySession intelliMeetId
        SessionPreference sessionPreference
        IMSession session
        for (DBObject object : output?.results()) {
            sessionPreference = SessionPreference.findBySessionIdAndIntelliMeetId((Long) object['_id'], intelliMeetId) ?:
                    new SessionPreference(intelliMeetId: intelliMeetId)

            session = IMSession.get((Long) object['_id'])
            sessionPreference?.with {
                if (session) {
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

}
