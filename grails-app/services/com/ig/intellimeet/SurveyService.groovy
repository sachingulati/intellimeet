package com.ig.intellimeet
import com.ig.intellimeet.dto.MailDTO
import com.ig.intellimeet.embedded.SurveyRecipientInfo
import com.ig.intellimeet.enums.SurveyStatus
import com.mongodb.DBCollection

class SurveyService {

    def imMailService
    def intelliMeetService
    def grailsLinkGenerator
    def tokenService

    void close(Long surveyId) {
        DBCollection surveyCollection  = Survey.collection
        surveyCollection.update(['_id': surveyId], ['$set': ['isClosed': true]])
    }

    Survey save(Survey survey) {
        if (!survey?.validate() || !survey?.save(failOnError: true, flush: true)) {
            log.error(survey?.errors?.allErrors?.join("\n"))
            survey = null
        }
        survey
    }

    Boolean hasFilledSurvey(long surveyId, String email){
        Survey survey = Survey.get(surveyId)
        if(survey){
            survey.recipients.find{
                it.email == email && it.status == SurveyStatus.COMPLETED
            }
        }
        else false
    }
    Boolean hasFilledSurvey(Token token){
        hasFilledSurvey(token?.surveyId, token?.email)
    }
    def sendSurveyReminder(Survey survey) {
        survey?.recipients?.findAll { it.status != SurveyStatus.COMPLETED }?.each { SurveyRecipientInfo surveyRecipientInfo ->
            if (surveyRecipientInfo?.email) {
                sendSurveyReminderEmail(surveyRecipientInfo?.email, survey?.id)
                surveyRecipientInfo?.status = SurveyStatus.SENT
            }
        }
    }

    def sendSurveyEmail(Survey survey) {
        survey?.recipients?.each { SurveyRecipientInfo surveyRecipientInfo ->
            if (surveyRecipientInfo?.email) {
                sendSurveyEmail(surveyRecipientInfo?.email, survey?.id)
                surveyRecipientInfo?.status = SurveyStatus.SENT
            }
        }
        save(survey)
    }

    def sendSurveyEmail(String emailAddress, Long surveyId = null) {
        if (emailAddress) {
            MailDTO mailDTO = new MailDTO()
            mailDTO.to = emailAddress
            mailDTO.subject = subjectForPreferenceEmail
            mailDTO.body = getMessageForPreferenceEmail(emailAddress, surveyId)
            log.info("Sending preference email to ${mailDTO?.to}")
            imMailService.sendMail(mailDTO)
        }
    }

    def sendSurveyReminderEmail(String emailAddress, Long surveyId = null) {
        if (emailAddress) {
            MailDTO mailDTO = new MailDTO()
            mailDTO.to = emailAddress
            mailDTO.subject ="Reminder: " + subjectForPreferenceEmail
            mailDTO.body = getMessageForPreferenceEmail(emailAddress, surveyId)
            log.info("Sending preference reminder email to ${mailDTO?.to}")
            imMailService.sendMail(mailDTO)
        }
    }

    String getSubjectForPreferenceEmail() {
        Survey.SAMPLE_SURVEY_SUBJECT_FOR_SESSION_PREFERENCE?.replace('[date]', intelliMeetService?.currentIntelliMeet?.dateOfEvent?.format("MMM dd, yyyy"))
    }

    String getMessageForPreferenceEmail(String email, Long surveyId = null) {
        Long intelliMeetId = intelliMeetService.currentIntelliMeetId
        Token token = Token.findByIntelliMeetIdAndEmailAndSurveyIdAndIsConsumed(intelliMeetId, email, surveyId, false)
        if (!token) {
            token = tokenService.generateToken(email, surveyId)
            tokenService.save(token)
        }
        Survey.SAMPLE_SURVEY_MESSAGE_FOR_SESSION_PREFERENCE?.replace('[SurveyLink]', grailsLinkGenerator.link(controller: 'survey', action: 'session', params: [tokenId: token?.value], absolute: true))
    }

    void updateSurveyStatusForEmail(Long surveyId, String email) {
        if (surveyId && email) {
            Survey.collection.update(['_id': surveyId, 'recipients.email': email], ['$set': ['recipients.$.status': SurveyStatus.COMPLETED.toString()]])
        }
    }
}
