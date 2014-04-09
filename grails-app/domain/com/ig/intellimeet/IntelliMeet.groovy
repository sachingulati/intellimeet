package com.ig.intellimeet

class IntelliMeet {

    String title
    String description
    String place

    Date dateCreated
    Date lastUpdated
    Date dateOfEvent

    List<Long> organisers

    static mapWith = "mongo"

    static constraints = {
        place (nullable: true)

    }
}
