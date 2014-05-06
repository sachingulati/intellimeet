package com.ig.intellimeet.embedded

import com.ig.intellimeet.User
import com.ig.intellimeet.enums.SurveyStatus
import grails.validation.Validateable

@Validateable
class SurveyRecipientInfo {

    Long userId
    String email
    SurveyStatus status =SurveyStatus.PENDING

    static constraints = {
        email email: true, blank: false
        status nullable: true
    }

    void setEmail(String email) {
        this.email = email
        this.userId = User.findByUsername(email)?.id
    }
}
