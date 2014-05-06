package com.ig.intellimeet

import com.ig.intellimeet.embedded.SurveyRecipientInfo

class Survey {

    Long intelliMeetId

    String title
    Date date

    List<SurveyRecipientInfo> recipients
    List<Question> questions

    static embedded = ['questions', 'recipients']

    static mapWith = "mongo"

    static constraints = {
        title blank: false
    }
}
