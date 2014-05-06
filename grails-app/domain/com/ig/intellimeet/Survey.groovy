package com.ig.intellimeet

import com.ig.intellimeet.embedded.SurveyRecipientInfo
import com.ig.intellimeet.enums.SurveyType

class Survey {

    Long intelliMeetId

    String title
    Date date
    SurveyType type

    List<SurveyRecipientInfo> recipients
    List<Question> questions

    static embedded = ['questions', 'recipients']

    static mapWith = "mongo"

    static constraints = {
        title blank: false
    }
}
