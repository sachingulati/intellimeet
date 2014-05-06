package com.ig.intellimeet

import com.ig.intellimeet.embedded.TopicStatusInfo
import com.ig.intellimeet.enums.TopicCategory

class Topic {

    String name
    String description
    TopicCategory category
    Long createdBy

    List<String> expectations
    List<Long> interestedUsers
    List<TopicStatusInfo> statusInfoList
    List<String> tags

    Date dateCreated
    Date lastUpdated

    static mapWith = "mongo"

    static embedded = ['statusInfoList']

    static transients = ['createdByUsername']

    static constraints = {
        name blank: false
        description blank: false
    }

    static mapping = {
        description type: "text"
    }

    String getCreatedByUsername() {
        User.get(createdBy)?.username
    }
}
