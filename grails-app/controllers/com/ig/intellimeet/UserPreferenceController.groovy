package com.ig.intellimeet
import com.ig.intellimeet.co.UserPreferenceCO
import com.ig.intellimeet.enums.SessionStatus
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class UserPreferenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def userPreferenceService
    def tokenService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserPreference.list(params), model: [userPreferenceInstanceCount: UserPreference.count()]
    }

    def show(String tokenId) {
        Token token = tokenService.extractToken(tokenId)
        if(!token) {
            respond null
        }
        [sessions: IMSession.findAllByIntelliMeetIdAndSessionStatus(token?.intelliMeetId, SessionStatus.LIVE), tokenId: tokenId]
    }

    @Transactional
    def save(UserPreferenceCO userPreferenceCO) {
        Token token = tokenService.extractToken(userPreferenceCO?.tokenId)
        if(!token) {
            respond null
        }
        else if(!userPreferenceCO?.hasErrors()) {
            UserPreference userPreference  = userPreferenceService.extractUserPreference(userPreferenceCO)
            userPreference.userId = token?.userId
            userPreference.intelliMeetId = token?.intelliMeetId
            userPreferenceService.save userPreference
        }
    }
}
