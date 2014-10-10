package com.ig.intellimeet

import grails.transaction.Transactional

@Transactional
class ImSessionService {

    def intelliMeetService

    def listRecentlyCreatedSessions(Integer max) {
        IMSession.findAllByIntelliMeetId(intelliMeetService?.currentIntelliMeetId, [max: max, sort: 'id', order: 'desc'])
    }
}
