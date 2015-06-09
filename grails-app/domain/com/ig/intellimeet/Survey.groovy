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
    QuestionTemplate questionTemplate

    Boolean isClosed = false

    static hasMany = [responses: SurveyResponse]
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
            new SurveyRecipientInfo(email: it)
        }?.findAll {it}
    }

    String getRecipientsEmail() {
        return recipients*.email?.join(", ")
    }

    String getIntelliMeetTitle() {
        IntelliMeet.get(intelliMeetId)?.title
    }

    static final String SAMPLE_SURVEY_SUBJECT_FOR_SESSION_PREFERENCE ="Session Preference for IntelliMeet - [date]"
    static final String SAMPLE_SURVEY_MESSAGE_FOR_SESSION_PREFERENCE = """<p>We are conducting a survey, and your response would be appreciated.</p>

<p>Here is a link to the survey:<br/>
[SurveyLink]
</p>
<p>
This link is uniquely tied to this survey and your email address. Please do not forward this message.
</p>
Thanks for your participation!
"""
}
