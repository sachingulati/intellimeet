package com.ig.intellimeet

import com.ig.intellimeet.embedded.TopicStatusInfo

class Topic {

    String name;
    String description;

    List<String> expectations
    List<Long> interestedUsers
    List<TopicStatusInfo> statusInfoList

    Date dateCreated;
    Date lastUpdated;

    static mapWith = "mongo"

    static constraints = {
        name blank: false
        description blank: false
    }

    static mapping = {
        description type: "text"
    }
}
