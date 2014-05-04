package com.ig.intellimeet

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IntelliMeetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond IntelliMeet.list(params), model: [intelliMeetInstanceCount: IntelliMeet.count()]
    }

    def show(IntelliMeet intelliMeetInstance) {
        respond intelliMeetInstance
    }

    def create() {
        respond new IntelliMeet(params)
    }

    @Transactional
    def save(IntelliMeet intelliMeetInstance) {
        if (intelliMeetInstance == null) {
            notFound()
            return
        }

        if (intelliMeetInstance.hasErrors()) {
            respond intelliMeetInstance.errors, view: 'create'
            return
        }

        intelliMeetInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'intelliMeetInstance.label', default: 'IntelliMeet'), intelliMeetInstance.id])
                redirect intelliMeetInstance
            }
            '*' { respond intelliMeetInstance, [status: CREATED] }
        }
    }

    def edit(IntelliMeet intelliMeetInstance) {
        respond intelliMeetInstance
    }

    @Transactional
    def update(IntelliMeet intelliMeetInstance) {
        if (intelliMeetInstance == null) {
            notFound()
            return
        }

        if (intelliMeetInstance.hasErrors()) {
            respond intelliMeetInstance.errors, view: 'edit'
            return
        }

        intelliMeetInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IntelliMeet.label', default: 'IntelliMeet'), intelliMeetInstance.id])
                redirect intelliMeetInstance
            }
            '*' { respond intelliMeetInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(IntelliMeet intelliMeet) {
        flash.error = message(code: "intellimeet.deletion.restricted")
        redirect( view: "index")
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'intelliMeetInstance.label', default: 'IntelliMeet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
