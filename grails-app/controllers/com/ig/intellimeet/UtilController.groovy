package com.ig.intellimeet

import com.ig.intellimeet.utils.TestUtil
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class UtilController {

    def surveyService
    def springSecurityService

    def beforeInterceptor = {
        if(!['farid@intelligrape.com', 'puneet.behl@intelligrape.com']?.contains(springSecurityService?.currentUser?.username)) {
            return
        }
    }

    def checkHealth() {
        render("Success")
    }

    def sendTestEmail( ) {
        grailsApplication.config.grails.mail.disabled=false
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
}
