package com.ig.intellimeet

import com.ig.intellimeet.dto.MailDTO
import com.ig.intellimeet.embedded.SurveyRecipientInfo
import com.ig.intellimeet.enums.SurveyStatus

class SurveyService {

    def imMailService
    def intelliMeetService
    def grailsLinkGenerator
    def tokenService

    def sendSurveyEmail(Survey survey) {
        survey?.recipients?.each {SurveyRecipientInfo surveyRecipientInfo->
            if(surveyRecipientInfo?.email && surveyRecipientInfo?.userId) {
                sendSurveyEmail(surveyRecipientInfo?.userId, surveyRecipientInfo?.email)
                surveyRecipientInfo?.status = SurveyStatus.SENT
            }
        }
    }

    def sendSurveyEmail(Long userId, String emailAddress) {
        if(emailAddress && userId) {
            MailDTO mailDTO = new MailDTO()
            mailDTO.to = emailAddress
            mailDTO.subject = subjectForPreferenceEmail
            mailDTO.body = getMessageForPreferenceEmail(userId)
            log.info("Sending preference email to ${mailDTO?.to}")
            imMailService.sendMail(mailDTO)
        }
    }


    String getSubjectForPreferenceEmail() {
        Survey.SAMPLE_SURVEY_SUBJECT_FOR_SESSION_PREFERENCE?.replace('[date]', intelliMeetService?.currentIntelliMeet?.dateOfEvent?.format("MMM dd, yyyy"))
    }

    String getMessageForPreferenceEmail(Long userId) {
        Token token = tokenService.generateToken(userId)
        tokenService.save(token)
        Survey.SAMPLE_SURVEY_MESSAGE_FOR_SESSION_PREFERENCE?.replace('[SurveyLink]',grailsLinkGenerator.link(controller: 'survey', action: 'session', params: [tokenId: token?.value],absolute: true))
    }
}
