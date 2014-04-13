package com.ig.intellimeet

class TopicService {
    def springSecurityService

    Integer increaseInterestCount(Topic topic) {
        User user = springSecurityService.currentUser as User
        topic.interestedUsers << user?.id
        topic.interestedUsers?.size()
    }
}
