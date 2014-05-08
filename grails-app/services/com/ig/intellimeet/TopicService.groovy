package com.ig.intellimeet

import com.ig.intellimeet.dto.CategoryTopicCount
import com.ig.intellimeet.enums.TopicCategory
import com.mongodb.AggregationOutput
import com.mongodb.DBCollection

class TopicService {
    def springSecurityService

    Topic save(Topic topic) {
        if (!topic?.validate() || !topic?.save(flush: true)) {
            log.error("Topic Validation Error: "+topic.errors.allErrors.join("\n"))
            topic = null
        }
        topic
    }

    Topic increaseInterestCount(Topic topic) {
        User user = springSecurityService.currentUser as User
        if (!topic?.interestedUsers?.contains(user?.id)) {
            topic?.interestedUsers = topic?.interestedUsers?.findAll {it} ?: []
            topic.interestedUsers << user?.id
        }
        topic
    }

    List<CategoryTopicCount> countTopicGroupedByCategory() {
        DBCollection topicCollection = Topic.collection
        AggregationOutput aggregationOutput = topicCollection?.aggregate(['$group': ['_id': '$category', 'count': ['$sum': 1]]])
        aggregationOutput?.results()?.collect { new CategoryTopicCount(category: TopicCategory.valueOf(it['_id']?.toString()), topicCount: it['count']) }
    }
}
