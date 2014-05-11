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

    static final String SAMPLE_SURVEY_SUBJECT_FOR_SESSION_PREFERENCE ="Session Preference for IntelliMeet - [date]"
    static final String SAMPLE_SURVEY_MESSAGE_FOR_SESSION_PREFERENCE = """
We are conducting a survey, and your response would be appreciated.

Here is a link to the survey:
[SurveyLink]

This link is uniquely tied to this survey and your email address. Please do not forward this message.


Thanks for your participation!
"""
}
