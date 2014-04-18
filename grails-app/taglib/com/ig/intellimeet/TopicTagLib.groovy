package com.ig.intellimeet

import com.ig.intellimeet.dto.CategoryTopicCount

class TopicTagLib {

    def topicService

    static namespace = "topic"

    def sideBarCategoriesPanel = {
        List<CategoryTopicCount> categoryTopicCounts = topicService.countTopicGroupedByCategory()
        out << render(template: '/topic/sidebarCategoryPanel', model: [categoryTopicCounts: categoryTopicCounts])
    }
}
