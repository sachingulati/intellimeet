package com.ig.intellimeet

import com.ig.intellimeet.co.UserPreferenceCO
import grails.gorm.PagedResultList
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class UserPreferenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def userPreferenceService
    def tokenService
    def surveyService
    def intelliMeetService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.sort = params.sort ?: 'dateCreated'
        params.order = params.order ?: 'desc'
        Long intelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        PagedResultList pagedUserPreferences = UserPreference.createCriteria().list(params) {
            eq('intelliMeetId', intelliMeetId)
        }
        respond pagedUserPreferences, model: [userPreferenceInstanceCount: pagedUserPreferences?.totalCount]
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def save(UserPreferenceCO userPreferenceCO) {
        Token token = tokenService.extractToken(userPreferenceCO?.tokenId)
        if (Survey.get(token?.surveyId)?.isClosed) {
            log.info("Cannot save preference as the survey is already closed.")
            flash.error = message(code: 'survey.closed.error.message')
        } else if (!token?.isValid()) {
            flash.error = message(code: 'token.consumed.message')
        } else if (userPreferenceCO?.hasErrors()) {
            List<String> errors = []
            eachError(bean: userPreferenceCO) {
                errors << message(error: it)
            }
            flash.error = errors?.join("<br/>")
        } else {
            UserPreference userPreference = userPreferenceService.extractUserPreference(userPreferenceCO, token)
            if (userPreferenceService.save(userPreference)) {
                surveyService.updateSurveyStatusForEmail(token?.surveyId, User.get(token?.userId)?.username)
                token.isConsumed = true
                tokenService.save(token)
                render view: '/survey/thankyou'
                return
            }
        }
        render view: '/error'
        return
    }

}
