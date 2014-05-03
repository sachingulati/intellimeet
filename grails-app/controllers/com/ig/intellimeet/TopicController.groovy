package com.ig.intellimeet

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class TopicController {

    static scaffold = true

    def topicService
    def springSecurityService

    def plusOne() {
        Map mapToRender = ['status':'']
        Integer currentInterestedUsersCount
        User currentUser  = springSecurityService?.currentUser
        mapToRender.username = currentUser?.username
        Topic topic = Topic.get(params.topicId)
        if(topic?.interestedUsers?.contains(currentUser?.id)) {
            mapToRender.status = 'error'
            mapToRender.message = message(code:'topic.interest.already.shown.message')
        } else if (topic) {
            topic = topicService.increaseInterestCount topic
            topicService.save topic
            currentInterestedUsersCount = topic?.interestedUsers?.size()
            mapToRender.count = currentInterestedUsersCount
        }
        render(mapToRender as JSON)
    }
}
