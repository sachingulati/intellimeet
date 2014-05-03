package com.ig.intellimeet

import com.ig.intellimeet.dto.CategoryTopicCount
import com.mongodb.AggregationOutput
import com.mongodb.DBCollection

class TopicService {
    def springSecurityService

    Topic save(Topic topic) {
        if(!topic?.validate() || !topic?.save(flush: true)) {
            topic = null
        }
        topic
    }

    Topic increaseInterestCount(Topic topic) {
        User user = springSecurityService.currentUser as User
        if(!topic?.interestedUsers?.contains(user?.id)) {
            topic.interestedUsers << user?.id
        }
        topic
    }

    List<CategoryTopicCount> countTopicGroupedByCategory() {
        DBCollection topicCollection = Topic.collection
        AggregationOutput aggregationOutput = topicCollection?.aggregate(['$group': ['_id': '$category', 'count': ['$sum': 1]]])
        aggregationOutput?.results()?.collect {new CategoryTopicCount(category: it['_id'], topicCount: it['count'])}
    }
}
