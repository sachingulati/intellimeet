package com.ig.intellimeet.embedded

import com.ig.intellimeet.User
import com.ig.intellimeet.enums.SurveyStatus
import grails.validation.Validateable

@Validateable
class SurveyRecipientInfo {

    Long userId
    String email
    SurveyStatus status

    static constraints = {
        email email: true, blank: false
        status nullable: true
    }

    void setUserId(Long userId) {
        this.userId = userId
        this.email = User.get(userId)?.username
    }
}
