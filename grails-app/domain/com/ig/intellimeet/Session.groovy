package com.ig.intellimeet

import embedded.Feedback
import enums.SessionStatusEnum

class Session {

    String title;
    String description;
    Integer maxCapacity;
    Integer minCapacity;
    Integer score;
    Integer topicId;

    List <Long> ownerIds;
    List <Long> attendeeIds;
    List <Feedback> feedbackList;

    Date dateCreated;
    Date lastUpdated;

    SessionStatusEnum sessionStatus;

    static embedded = ['feedbackList']

    static belongsTo = [intelliMeet : IntelliMeet]

    static constraints = {
        maxCapacity(nullable: true);
        minCapacity (nullable: true);
        score (nullable: true, range: 1..5);
    }
}
