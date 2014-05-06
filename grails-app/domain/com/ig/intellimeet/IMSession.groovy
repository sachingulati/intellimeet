package com.ig.intellimeet

import com.ig.intellimeet.embedded.Feedback
import com.ig.intellimeet.enums.SessionStatus

class IMSession {

    Long intelliMeetId
    Long topicId

    String title
    String description
    Integer maxCapacity
    Integer minCapacity
    Integer score

    List <Long> ownerIds
    List <Long> attendeeIds
    List <Feedback> feedbackList

    Date dateCreated
    Date lastUpdated

    SessionStatus sessionStatus

    static mapWith = "mongo"

    static transients = ['attendeesEmails', 'ownersEmail']

    static embedded = ['feedbackList']

    static constraints = {
        title blank: false
        maxCapacity nullable: true
        minCapacity nullable: true
        score nullable: true, range: 1..5
        topicId nullable:true
        score: nullable: true
    }

    static mapping = {
        description type:"text"
    }

    List<String> getAttendeesEmails() {
        attendeeIds?.collect {User.get(it)?.username}
    }

    List<String> getOwnersEmail() {
        ownerIds?.collect{User.get(it)?.username}
    }
}