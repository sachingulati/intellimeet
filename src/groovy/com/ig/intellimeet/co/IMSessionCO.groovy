package com.ig.intellimeet.co
import com.ig.intellimeet.IMSession
import com.ig.intellimeet.Topic
import grails.validation.Validateable

@Validateable
class IMSessionCO {

    Long topicId
    Long intelliMeetId

    String title
    String description
    Integer minCapacity
    Integer maxCapacity

    Long ownerId
    Long copresenterId

    List<Integer> attendeeIds

    Date dateCreated
    Date lastUpdated

    List<IMSession> sessionList
    Integer totalCount      //For pagination


    static constraints = {
        topicId nullable: true
        ownerId validator: {val, obj->
            if(obj?.topicId && IMSession.findByTopicIdAndIntelliMeetIdAndOwnerId(obj?.topicId, obj?.intelliMeetId, val)) {
                return ['ownerId.unique.error']
            }
        }
        title blank: false
        description blank: false
        copresenterId nullable: true
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
