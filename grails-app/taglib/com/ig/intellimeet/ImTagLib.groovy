package com.ig.intellimeet

import com.ig.intellimeet.enums.TopicCategory

class ImTagLib {
//    static defaultEncodeAs = 'html'
    //static encodeAsForTags = [tagName: 'raw']

    static namespace = "im"

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
}
