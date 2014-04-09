package com.ig.intellimeet

class IntelliMeet {

    String title
    String description
    String place

    List<Long> organizers

    Date dateCreated
    Date lastUpdated
    Date dateOfEvent

    static mapWith = "mongo"

    static constraints = {
        title nullable: false
        description nullable: true
        place nullable: false
    }

}
