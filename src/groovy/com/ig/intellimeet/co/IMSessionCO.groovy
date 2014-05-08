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
    Integer minCapacity
    Integer maxCapacity

    List <Long> ownerIds

    Date dateCreated
    Date lastUpdated

    SessionStatus sessionStatus

    List<IMSession> sessionList
    Integer totalCount      //For pagination


    static constraints = {
        topicId nullable: true
        title blank: false
        description blank: false
        minCapacity nullable: true, min: 4
        maxCapacity nullable: true, min: 5, validator: {val, obj ->
            return (val >= obj.minCapacity)
        }
    }

    IMSessionCO() {}

    IMSessionCO(Topic topic) {
        topicId = topic?.id
        title = topic?.name
        description = topic?.description
    }

}
