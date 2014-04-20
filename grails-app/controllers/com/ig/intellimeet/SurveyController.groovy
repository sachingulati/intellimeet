package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class SurveyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Survey.list(params), model:[surveyInstanceCount: Survey.count()]
    }

    def show(Survey surveyInstance) {
        respond surveyInstance
    }

    def create() {
        respond new Survey(params)
    }

    @Transactional
    def save(Survey surveyInstance) {
        if (surveyInstance == null) {
            notFound()
            return
        }

        if (surveyInstance.hasErrors()) {
            respond surveyInstance.errors, view:'create'
            return
        }

        surveyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), surveyInstance.id])
                redirect surveyInstance
            }
            '*' { respond surveyInstance, [status: CREATED] }
        }
    }

    def edit(Survey surveyInstance) {
        respond surveyInstance
    }

    @Transactional
    def update(Survey surveyInstance) {
        if (surveyInstance == null) {
            notFound()
            return
        }

        if (surveyInstance.hasErrors()) {
            respond surveyInstance.errors, view:'edit'
            return
        }

        surveyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Survey.label', default: 'Survey'), surveyInstance.id])
                redirect surveyInstance
            }
            '*'{ respond surveyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Survey surveyInstance) {

        if (surveyInstance == null) {
            notFound()
            return
        }

        surveyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Survey.label', default: 'Survey'), surveyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
