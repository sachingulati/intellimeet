package com.ig.intellimeet

import com.ig.intellimeet.enums.TopicCategory

class ImTagLib {
//    static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']

    static namespace = "im"
    def springSecurityService
    def intelliMeetService

    def categories = { attrs ->
        Map<TopicCategory, Integer> categoryCountMap = [:]
        Topic.list().each { Topic topic ->
            TopicCategory topicCategory = topic.category
            if (!categoryCountMap.containsKey(topicCategory)) {
                categoryCountMap.put(topicCategory, 1)
            } else {
                categoryCountMap.put(topicCategory, categoryCountMap.get(topicCategory))
            }
        }
        out << render(template: '/templates/categories', model: [categoryCountMap: categoryCountMap])
    }

    def ifLoggedInUsername = { attrs, body ->
        String currentUsername = springSecurityService?.currentUser?.username
        if (attrs.username && currentUsername?.equalsIgnoreCase(attrs.username)) {
            out << body()
        }
    }

    def canEdit = {attrs, body->
        Long userId= springSecurityService?.currentUser?.id
        IMSession imSession = attrs.imSession
        if (userId in [imSession.ownerId, imSession.copresenterId]) {
            out << body()
        }
    }

    def displayCountdown = {
        Date date = intelliMeetService?.currentIntelliMeet?.dateOfEvent
        String dateString =  date?.format("yyyy/MM/dd")
        out << render(template: '/templates/countdown', model: [dateString: dateString])

    }
}
