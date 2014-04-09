package com.ig.intellimeet

class Topic {

    String name;
    String description;

    Date dateCreated;
    Date lastUpdated;

    // TopicStatusEnum statusInfoList;

    static hasMany = [interestedUsers : Long, interestedOwners : Long, expections : String];

    static constraints = {
    }
}
