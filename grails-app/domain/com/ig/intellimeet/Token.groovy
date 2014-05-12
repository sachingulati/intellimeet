package com.ig.intellimeet

class Token {
    Long userId
    Long intelliMeetId
    String value
    Date expiryDate
    Date dateCreated
    Date lastUpdated

    static final Integer TOKEN_VALIDITY_IN_DAYS=15
    static mapWith = "mongo"
    static constraints = {}
}
