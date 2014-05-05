package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class UserPreferenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserPreference.list(params), model: [userPreferenceInstanceCount: UserPreference.count()]
    }

    def show(UserPreference userPreferenceInstance) {
        respond userPreferenceInstance
    }

    def create() {
        respond new UserPreference(params)
    }

    @Transactional
    def save(UserPreference userPreferenceInstance) {
        if (userPreferenceInstance == null) {
            notFound()
            return
        }

        if (userPreferenceInstance.hasErrors()) {
            respond userPreferenceInstance.errors, view: 'create'
            return
        }

        userPreferenceInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userPreferenceInstance.label', default: 'UserPreference'), userPreferenceInstance.id])
                redirect userPreferenceInstance
            }
            '*' { respond userPreferenceInstance, [status: CREATED] }
        }
    }

    def edit(UserPreference userPreferenceInstance) {
        respond userPreferenceInstance
    }

    @Transactional
    def update(UserPreference userPreferenceInstance) {
        if (userPreferenceInstance == null) {
            notFound()
            return
        }

        if (userPreferenceInstance.hasErrors()) {
            respond userPreferenceInstance.errors, view: 'edit'
            return
        }

        userPreferenceInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserPreference.label', default: 'UserPreference'), userPreferenceInstance.id])
                redirect userPreferenceInstance
            }
            '*' { respond userPreferenceInstance, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userPreferenceInstance.label', default: 'UserPreference'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
