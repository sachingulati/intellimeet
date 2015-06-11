package com.ig.intellimeet

import com.ig.intellimeet.embedded.Answer
import com.ig.intellimeet.enums.SessionStatus
import com.ig.intellimeet.enums.SurveyStatus
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

@Secured(['ROLE_IM_OWNER'])
class SurveyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def intelliMeetService
    def userPreferenceService
    def surveyService
    def tokenService

    def close(Long id) {
        if (Survey.countById(id)) {
            surveyService.close(id)
        }
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def session() {
        Token token = tokenService.extractToken(params.tokenId)
        Boolean hasFilledPreferences = surveyService.hasFilledSurvey(token)
        Survey survey = Survey.get(token?.surveyId)
        if (survey?.isClosed) {
            flash.error = message(code: 'survey.closed.error.message')
            render view: '/error'
            return
        }
        if (!token?.isValid() || hasFilledPreferences) {
            render view: '/survey/thankyou'
            return
        }
        [type: survey.type, questionTemplate: survey.questionTemplate, tokenId: token?.value]
//        [sessions: IMSession.findAllByIntelliMeetIdAndSessionStatus(intelliMeetService?.currentIntelliMeetId, SessionStatus.PROPOSED, [sort: 'title', order: 'asc']), hasFilledPreferences: hasFilledPreferences, tokenId: token?.value]
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def surveyResponse(){
        Token token = tokenService.extractToken(params.tokenId)
        Boolean hasFilledPreferences = surveyService.hasFilledSurvey(token)
        Survey survey = Survey.get(token?.surveyId)
        if (survey?.isClosed) {
            flash.error = message(code: 'survey.closed.error.message')
            render view: '/error'
            return
        }
        if (!token?.isValid() || hasFilledPreferences) {
            render view: '/survey/thankyou'
            return
        }
        SurveyResponse surveyResponse = new SurveyResponse(survey: survey, answers: [])
        survey.questionTemplate.questions.each {
            surveyResponse.answers.push(new Answer(questionId: it.id, answer: params["answer"+it.id], comment: params["comment"+it.id]))
        }
        surveyResponse.save()
        survey.recipients.find{
            it.email == token.email
        }.status = SurveyStatus.COMPLETED
        survey.save()
        render view: '/survey/thankyou'
        return
    }
    @Secured('ROLE_ADMIN')
    def template() {
    }

    def send(Long id) {
        Survey survey = Survey.findByIntelliMeetIdAndId(intelliMeetService.currentIntelliMeetId, id)
        if(survey?.isClosed) {
            log.info("Cannot send reminder email as survey already closed.")
        } else if (survey?.recipients*.status?.contains(SurveyStatus.PENDING)) {
            surveyService.sendSurveyEmail(survey)
        } else {
            log.info("All survey emails already being sent...")
        }
        redirect controller: 'survey', action: 'show', id: id
    }

    def sendReminder(Long id) {
        Survey survey = Survey.findByIntelliMeetIdAndId(intelliMeetService.currentIntelliMeetId, id)
        if(survey?.isClosed) {
            log.info("Cannot send reminder email as survey already closed.")
        } else if (survey?.recipients*.status?.count { it!=SurveyStatus.COMPLETED }) {
            surveyService.sendSurveyReminder(survey)
        } else {
            log.info("All survey filled already...")
        }
        redirect controller: 'survey', action: 'show', id: id
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Survey.list(params), model: [surveyInstanceCount: Survey.count()]
    }

    def show(Survey surveyInstance) {
        respond surveyInstance
    }

    def create() {
        Survey survey = new Survey(params)
        survey.recipientsEmail = User.findAllByEnabled(true)*.username?.join(", ")
        respond survey
    }

    @Transactional
    def save(Survey surveyInstance) {
        if (surveyInstance == null) {
            notFound()
            return
        }

        if (surveyInstance.hasErrors()) {
            respond surveyInstance.errors, view: 'create'
            return
        }

        surveyInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), surveyInstance.id])
                redirect surveyInstance
            }
            '*' { respond surveyInstance, [status: CREATED] }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
