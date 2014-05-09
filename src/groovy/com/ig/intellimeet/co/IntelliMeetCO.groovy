package com.ig.intellimeet.co

import com.ig.intellimeet.enums.IntelliMeetStatus
import grails.validation.Validateable
import org.grails.databinding.BindingFormat

@Validateable
class IntelliMeetCO {

    String title
    String description
    String place
    IntelliMeetStatus status

    Long firstOwnerId
    Long secondOwnerId

    Date dateCreated
    Date lastUpdated

    @BindingFormat('MM/dd/yyyy')
    Date dateOfEvent

    List<Long> organizers

    static constraints = {
        title blank: false
        description nullable: true
        place nullable: true

    }
}
