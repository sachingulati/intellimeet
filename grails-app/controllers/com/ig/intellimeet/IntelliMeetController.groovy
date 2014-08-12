package com.ig.intellimeet

import com.ig.intellimeet.co.IntelliMeetCO
import com.ig.intellimeet.enums.IntelliMeetStatus
import com.ig.intellimeet.enums.UserRoles
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class IntelliMeetController {

    IntelliMeetService intelliMeetService

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
    def save(IntelliMeetCO intelliMeetCO) {
        if (intelliMeetCO == null) {
            notFound()
            return
        }

        if (!intelliMeetCO.validate()) {
            render view: 'create', model: [intelliMeetCO: intelliMeetCO]
            return
        }

        IntelliMeet currentIntelliMeet = intelliMeetService.getCurrentIntelliMeet()
        IntelliMeet newIntelliMeet = new IntelliMeet(intelliMeetCO)
        intelliMeetService.updateStatus currentIntelliMeet, IntelliMeetStatus.IN_ACTIVE

        if (!newIntelliMeet.validate()) {
            respond newIntelliMeet.errors, view: 'edit'
            return
        }

        intelliMeetService.removeLikesFromAllTopics()
        Role roleImOwner = Role.findByAuthority(UserRoles.ROLE_IM_OWNER.displayName);
        intelliMeetService.revokeRoleFromAllUsers roleImOwner
        intelliMeetService.assignOrgranizerRoles newIntelliMeet
        intelliMeetService.save(newIntelliMeet)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'intelliMeetInstance.label', default: 'IntelliMeet'), newIntelliMeet.id])
                redirect newIntelliMeet
            }
            '*' { respond newIntelliMeet, [status: CREATED] }
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
