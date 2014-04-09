package com.ig.intellimeet

class IntelliMeet {

    String title;
    String description;
    String place;

    Date dateCreated;
    Date lastUpdated;
    Date dateOfEvent;

    static hasMany = [organisers : Long]

    static constraints = {
        place (nullable: true);

    }
}
