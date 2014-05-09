package com.ig.intellimeet
import com.ig.intellimeet.co.UserPreferenceCO
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class UserPreferenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def userPreferenceService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserPreference.list(params), model: [userPreferenceInstanceCount: UserPreference.count()]
    }

    @Transactional
    def save(UserPreferenceCO userPreferenceCO) {
        if(!userPreferenceCO?.hasErrors()) {
            UserPreference userPreference  = userPreferenceService.extractUserPreference(userPreferenceCO)
            userPreferenceService.save userPreference
        }
    }
}
