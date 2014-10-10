package com.ig.intellimeet

import grails.transaction.Transactional

@Transactional
class ImSessionService {

    def listRecentlyCreatedSessions(Integer max) {
        IMSession.list([max: max, sort: 'id', order: 'desc'])
    }
}
