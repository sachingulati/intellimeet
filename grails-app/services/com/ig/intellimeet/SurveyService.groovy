package com.ig.intellimeet

import com.ig.intellimeet.embedded.SurveyRecipientInfo

class SurveyService {

    def tokenService
    def imMailService

    def sendSurveyEmail(Survey survey) {
        survey?.recipients?.each {SurveyRecipientInfo surveyRecipientInfo->
            Token token = tokenService.generateToken(surveyRecipientInfo?.userId)
            if(token && tokenService.save(token)) {
            }
        }
    }

}
