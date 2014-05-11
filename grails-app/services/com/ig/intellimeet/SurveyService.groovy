package com.ig.intellimeet

import com.ig.intellimeet.dto.MailDTO
import com.ig.intellimeet.embedded.SurveyRecipientInfo
import com.ig.intellimeet.enums.SurveyStatus

class SurveyService {

    def imMailService
    def intelliMeetService

    def sendSurveyEmail(Survey survey) {
        survey?.recipients?.each {SurveyRecipientInfo surveyRecipientInfo->
            sendSurveyEmail(surveyRecipientInfo?.email)
            surveyRecipientInfo?.status = SurveyStatus.SENT
        }
    }

    def sendSurveyEmail(String emailAddress) {
        if(emailAddress) {
            MailDTO mailDTO = new MailDTO()
            mailDTO.to = emailAddress
            mailDTO.subject = subjectForPreferenceEmail
            mailDTO.body = messageForPreferenceEmail
            log.info("Sending preference email to ${mailDTO?.to}")
            imMailService.sendMail(mailDTO)
        }
    }


    String getSubjectForPreferenceEmail() {
        Survey.SAMPLE_SURVEY_SUBJECT_FOR_SESSION_PREFERENCE
    }

    String getMessageForPreferenceEmail() {
        Survey.SAMPLE_SURVEY_MESSAGE_FOR_SESSION_PREFERENCE
    }
}
