package com.ig.intellimeet

import com.ig.intellimeet.embedded.SurveyRecipientInfo
import com.ig.intellimeet.enums.SurveyType
import org.grails.databinding.BindingFormat

class Survey {

    Long intelliMeetId

    String title
    @BindingFormat('MM/dd/yyyy')
    Date date
    SurveyType type

    List<SurveyRecipientInfo> recipients
    List<Question> questions
    String recipientsEmail

    static transients = ['recipientsEmail', 'intelliMeetTitle']

    static embedded = ['questions', 'recipients']

    static mapWith = "mongo"

    static constraints = {
        title blank: false
    }

    void setRecipientsEmail(String recipientsEmail) {
        this.recipientsEmail = recipientsEmail
        this.recipients  = recipientsEmail?.tokenize(",")?.collect {
            it=it?.trim()
            User.findByUsername(it)? new SurveyRecipientInfo(email: it) : null
        }?.findAll {it}
    }

    String getRecipientsEmail() {
        return recipients*.email?.join(", ")
    }

    String getIntelliMeetTitle() {
        IntelliMeet.get(intelliMeetId)?.title
    }
}
