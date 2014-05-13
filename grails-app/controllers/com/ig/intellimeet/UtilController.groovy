package com.ig.intellimeet

import com.ig.intellimeet.enums.SessionStatus
import com.ig.intellimeet.utils.TestUtil

class UtilController {

    def surveyService
    def springSecurityService
    def intelliMeetService

    def beforeInterceptor = {
        if (!['farid@intelligrape.com', 'puneet.behl@intelligrape.com']?.contains(springSecurityService?.currentUser?.username)) {
            return
        }
    }

    def checkHealth() {
        render("Success")
    }

    def sendTestEmail() {
        grailsApplication.config.grails.mail.disabled = false
        surveyService.sendSurveyEmail(params.email)
    }

    def assignRoles() {
        log.info("Assigning roles...")
        TestUtil.createUserRole('dmittal@intelligrape.com', 'ROLE_ADMIN').save(failOnError: true, flush: true)
        TestUtil.createUserRole('puneet.behl@intelligrape.com', 'ROLE_IM_OWNER').save(failOnError: true, flush: true)
        TestUtil.createUserRole('puneet.behl@intelligrape.com', 'ROLE_ADMIN').save(failOnError: true, flush: true)
        TestUtil.createUserRole('farid@intelligrape.com', 'ROLE_IM_OWNER').save(failOnError: true, flush: true)
        TestUtil.createUserRole('farid@intelligrape.com', 'ROLE_ADMIN').save(failOnError: true, flush: true)
        TestUtil.createUserRole('mohit@intelligrape.com', 'ROLE_IM_OWNER').save(failOnError: true, flush: true)
        TestUtil.createUserRole('vivek.sachdeva@intelligrape.com', 'ROLE_IM_OWNER').save(failOnError: true, flush: true)
        log.info('Finished Assigning roles...')
    }

    def thankyou() {
        render view: '/survey/thankyou'
        return
    }

    def pref() {
        Boolean hasFilledPreferences = false
        render view: '/survey/session', model: [sessions: IMSession.findAllByIntelliMeetIdAndSessionStatus(intelliMeetService?.currentIntelliMeetId, SessionStatus.PROPOSED,[sort:'title', order:'asc']), hasFilledPreferences: hasFilledPreferences, tokenId: "Dummy Token"]
    }
}
