package com.ig.intellimeet

import com.ig.intellimeet.enums.IntelliMeetStatus
import org.grails.databinding.BindingFormat

class IntelliMeet {

    String title
    String description
    String place
    IntelliMeetStatus status

    Date dateCreated
    Date lastUpdated

    @BindingFormat('MM/dd/yyyy')
    Date dateOfEvent

    List<Long> organizers

    static mapWith = "mongo"

    static constraints = {
        title blank: false
        description nullable: true
        place nullable: true
        status validator: {val,obj->
            if(val == IntelliMeetStatus.ACTIVE && IntelliMeet.countByStatus(IntelliMeetStatus.ACTIVE)) {
                return ['intelliMeet.status.active.error']
            }
        }
    }

    static mapping = {
        description type: 'text'
    }
}
