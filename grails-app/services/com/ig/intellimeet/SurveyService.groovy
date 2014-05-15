package com.ig.intellimeet

import com.ig.intellimeet.dto.MailDTO
import com.ig.intellimeet.embedded.SurveyRecipientInfo
import com.ig.intellimeet.enums.SurveyStatus

class SurveyService {

    def imMailService
    def intelliMeetService
    def grailsLinkGenerator
    def tokenService

    Survey save(Survey survey) {
        if (!survey?.validate() || !survey?.save(failOnError: true, flush: true)) {
            log.error(survey?.errors?.allErrors?.join("\n"))
            survey = null
        }
        survey
    }

    def sendSurveyReminder(Survey survey) {
        survey?.recipients?.findAll { it.status != SurveyStatus.COMPLETED }?.each { SurveyRecipientInfo surveyRecipientInfo ->
            if (surveyRecipientInfo?.email && surveyRecipientInfo?.userId) {
                sendSurveyReminderEmail(surveyRecipientInfo?.userId, surveyRecipientInfo?.email, survey?.id)
                surveyRecipientInfo?.status = SurveyStatus.SENT
            }
        }
    }

    def sendSurveyEmail(Survey survey) {
        survey?.recipients?.each { SurveyRecipientInfo surveyRecipientInfo ->
            if (surveyRecipientInfo?.email && surveyRecipientInfo?.userId) {
                sendSurveyEmail(surveyRecipientInfo?.userId, surveyRecipientInfo?.email, survey?.id)
                surveyRecipientInfo?.status = SurveyStatus.SENT
            }
        }
        save(survey)
    }

    def sendSurveyEmail(Long userId, String emailAddress, Long surveyId = null) {
        if (emailAddress && userId) {
            MailDTO mailDTO = new MailDTO()
            mailDTO.to = emailAddress
            mailDTO.subject = subjectForPreferenceEmail
            mailDTO.body = getMessageForPreferenceEmail(userId, surveyId)
            log.info("Sending preference email to ${mailDTO?.to}")
            imMailService.sendMail(mailDTO)
        }
    }

    def sendSurveyReminderEmail(Long userId, String emailAddress, Long surveyId = null) {
        if (emailAddress && userId) {
            MailDTO mailDTO = new MailDTO()
            mailDTO.to = emailAddress
            mailDTO.subject ="Reminder: " + subjectForPreferenceEmail
            mailDTO.body = getMessageForPreferenceEmail(userId, surveyId)
            log.info("Sending preference reminder email to ${mailDTO?.to}")
            imMailService.sendMail(mailDTO)
        }
    }

    String getSubjectForPreferenceEmail() {
        Survey.SAMPLE_SURVEY_SUBJECT_FOR_SESSION_PREFERENCE?.replace('[date]', intelliMeetService?.currentIntelliMeet?.dateOfEvent?.format("MMM dd, yyyy"))
    }

    String getMessageForPreferenceEmail(Long userId, Long surveyId = null) {
        Long intelliMeetId = intelliMeetService.currentIntelliMeetId
        Token token = Token.findByIntelliMeetIdAndUserIdAndSurveyIdAndIsConsumed(intelliMeetId, userId, surveyId, false)
        if (!token) {
            token = tokenService.generateToken(userId, surveyId)
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
