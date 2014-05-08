package com.ig.intellimeet.co

import com.ig.intellimeet.IMSession
import com.ig.intellimeet.Topic
import com.ig.intellimeet.enums.SessionStatus
import grails.validation.Validateable

@Validateable
class IMSessionCO {

    Long topicId

    String title
    String description
    Integer maxCapacity
    Integer minCapacity

    List <Long> ownerIds

    List<Integer> attendeeIds

    Date dateCreated
    Date lastUpdated

    SessionStatus sessionStatus

    List<IMSession> sessionList
    Integer totalCount      //For pagination


    static constraints = {
        topicId nullable: true
        title blank: false
        description blank: false
    }

    IMSessionCO() {}

    IMSessionCO(Topic topic) {
        topicId = topic?.id
        title = topic?.name
        description = topic?.description
    }

}
