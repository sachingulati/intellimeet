package com.ig.intellimeet

import com.ig.intellimeet.dto.CategoryTopicCount

class TopicTagLib {

    def topicService
    def springSecurityService

    static namespace = "topic"

    def sideBarCategoriesPanel = {
        List<CategoryTopicCount> categoryTopicCounts = topicService.countTopicGroupedByCategory()
        out << render(template: '/topic/sidebarCategoryPanel', model: [categoryTopicCounts: categoryTopicCounts])
    }

    def displayInterestedUsersCount= { attrs->
        Topic topic = attrs.topic
        if(topic) {
            Integer interestedUserCount = topic?.interestedUsers?.size()
            Long topicId = topic?.id
            User currentUser = springSecurityService.currentUser
            Boolean currentUserAlreadyOpted = topic?.interestedUsers?.contains(currentUser?.id)
            out << render(template: '/topic/interestedUserCount',model: [interestedUserCount: interestedUserCount, topicId: topicId, currentUserAlreadyOpted: currentUserAlreadyOpted])
        }
    }
}
