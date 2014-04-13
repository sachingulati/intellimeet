package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class TopicController {

    static scaffold = true

    def topicService

    def plusOne(Long topicId) {
        Integer currentInterestedUsersCount
        Topic topic = Topic.get(topicId)
        if (topic) {
            currentInterestedUsersCount = topicService.increaseInterestCount(topic)
        }
    }
}
