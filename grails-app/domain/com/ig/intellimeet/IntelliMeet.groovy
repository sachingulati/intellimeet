package com.ig.intellimeet

class IntelliMeet {

    String title
    String description
    String place

    Date dateCreated
    Date lastUpdated
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
