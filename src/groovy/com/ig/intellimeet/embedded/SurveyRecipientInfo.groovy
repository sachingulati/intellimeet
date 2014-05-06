package com.ig.intellimeet.embedded

import com.ig.intellimeet.enums.SurveyStatus
import grails.validation.Validateable

@Validateable
class SurveyRecipientInfo {

    String email
    SurveyStatus status

    static constraints = {
        email email: true, blank: false
        status nullable: true
    }
}
