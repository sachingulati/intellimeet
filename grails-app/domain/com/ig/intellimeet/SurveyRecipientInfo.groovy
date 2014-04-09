package com.ig.intellimeet

import enums.SurveyRecipientInfoEnum

class SurveyRecipientInfo {

    String email
    SurveyRecipientInfoEnum status

    static mapWith = "mongo"

    static constraints = {
    }
}
