package com.ig.intellimeet

import com.ig.intellimeet.co.UserPreferenceCO
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

    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def save(UserPreferenceCO userPreferenceCO) {
        Token token = tokenService.extractToken(userPreferenceCO?.tokenId)
        if (!token?.isValid()) {
            flash.error = message(code: 'token.consumed.message')
            render view: '/error'
            return
        }
        if (!userPreferenceCO?.hasErrors()) {
            UserPreference userPreference = userPreferenceService.extractUserPreference(userPreferenceCO, token)
            userPreferenceService.save userPreference
            token.isConsumed = true
            tokenService.save(token)
            render view: '/survey/thankyou'
            return
        }
    }

}
