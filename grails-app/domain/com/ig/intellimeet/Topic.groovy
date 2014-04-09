package com.ig.intellimeet

class Topic {

    String name
    String description

    Date dateCreated
    Date lastUpdated

    List<Long> interestedUsers
    List<Long> interestedOwners
    List<String> expectations

    static mapWith = "mongo"

    // TopicStatusEnum statusInfoList

    static constraints = {
    }
}
