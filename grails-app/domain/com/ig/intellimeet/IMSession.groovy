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

    Long ownerId
    Long copresenterId
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
        maxCapacity nullable: true, min: 5, validator: {val, obj ->
            return (val >= obj.minCapacity)
        }
        minCapacity nullable: true, min: 4
        score nullable: true, range: 1..5
        topicId nullable:true
        score: nullable: true
        ownerId nullable: true, unique: ['topicId', 'intelliMeetId', 'copresenterId']
        copresenterId nullable: true
    }

    static mapping = {
        description type:"text"
    }

    List<String> getAttendeesEmails() {
        attendeeIds?.collect {User.get(it)?.username}
    }

    String getOwnersEmail() {
        User.get(ownerId)?.username + (copresenterId ? (' & '+User.get(copresenterId)?.username):'')
    }
}
