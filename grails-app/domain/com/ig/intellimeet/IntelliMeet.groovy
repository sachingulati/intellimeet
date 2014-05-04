package com.ig.intellimeet

import org.grails.databinding.BindingFormat

class IntelliMeet {

    String title
    String description
    String place

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
    }

    static mapping = {
        description type: 'text'
    }
}
