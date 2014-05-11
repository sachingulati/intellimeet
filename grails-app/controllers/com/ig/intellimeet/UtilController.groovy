package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class UtilController {

    def surveyService
    def springSecurityService

    def beforeInterceptor = {
        if(!['farid@intelligrape.com', 'puneet.behl@intelligrape.com', 'mohit@intelligrape.com']?.contains(springSecurityService?.currentUser?.username)) {
            return
        }
    }

    def checkHealth() {
        render("Success")
    }

    def getUserList() {
        List<Long> userIds = Topic.list()*.interestedUsers?.unique()?.flatten()
        render(User.getAll(userIds)*.username)
    }

    def sendTestEmail( ) {
        grailsApplication.config.grails.mail.disabled=false
        surveyService.sendSurveyEmail(params.email)
    }
}
