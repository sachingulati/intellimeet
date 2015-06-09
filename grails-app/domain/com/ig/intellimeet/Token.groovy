package com.ig.intellimeet

class Token {
//    Long userId
    String email
    Long intelliMeetId
    Long surveyId
    String value
    Boolean isConsumed = false
    Date expiryDate
    Date effectiveDate
    Date dateCreated
    Date lastUpdated

    static final Integer TOKEN_VALIDITY_IN_DAYS=15
    static mapWith = "mongo"
    static constraints = {
        surveyId nullable: true
    }

    Boolean isValid() {
        !isConsumed && expiryDate?.after(new Date()) && effectiveDate?.before(new Date())
    }
}
