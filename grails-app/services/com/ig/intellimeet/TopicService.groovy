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

    List<Topic> listTopics(String sortBy, String order){
        List<Topic> topics = Topic.list()
        println("Before sorting id: ${topics*.id}")
        switch (sortBy) {
            case 'likes':
                topics = topics.sort{it.interestedUsers.size()}
                println "Sorted by likes: ${topics*.interestedUsers*.size()}"
                break;
            case 'created':
                topics = topics.sort{it.dateCreated.time}
                println "sortby is ${sortBy} .. ${topics*.dateCreated*.format('MM/dd/yyyy HH:mm')}"
                break;
            case 'updated':
                topics = topics.sort{it.lastUpdated.time}
                println "sortby is ${sortBy} .. ${topics*.lastUpdated*.format('MM/dd/yyyy HH:mm')}"
                break;
        }

        println("After sorting id: ${topics*.id}")
        if(order == 'desc'){
            topics = topics.reverse()
        }
        topics
    }
}
