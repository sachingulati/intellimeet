package com.ig.intellimeet

import com.ig.intellimeet.co.IMSessionCO
import com.ig.intellimeet.enums.SessionStatus
import com.ig.intellimeet.utils.TestUtil
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)

@Secured(['ROLE_USER'])
class IMSessionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def intelliMeetService
    def springSecurityService

    def createNewSessionFromTopic(Long topicId) {
        Topic topic = Topic.get(topicId)
        IMSessionCO imSessionCO = topic ? new IMSessionCO(topic) : new IMSessionCO()
        render view: 'create', model: [imSessionCO: imSessionCO]
    }

    def index() {
        Long intelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        params.sort = params.sort ?: 'id'
        params.order = params.order ?: 'desc'
        List<IMSession> imSesssionList = IMSession.findAllByIntelliMeetIdAndSessionStatus intelliMeetId, SessionStatus.PROPOSED, params
        respond imSesssionList
    }

    def show(IMSession imSessionInstance) {
        springSecurityService.currentUser.id in [imSessionInstance.ownerId, imSessionInstance.copresenterId]
        respond imSessionInstance
    }

    def create() {
        params.description = params.description ?: TestUtil.SESSION_DUMMY_DESCRIPTION
        respond new IMSession(params)
    }

    @Transactional
    def save(IMSessionCO imSessionCO) {
        if (imSessionCO == null) {
            notFound()
            return
        }

        if (!imSessionCO.validate()) {
            render view: 'create', model: [imSessionCO: imSessionCO]
            return
        }
        IMSession imSession = new IMSession()
        bindData(imSession, imSessionCO)
        imSession.intelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        imSession.sessionStatus = SessionStatus.PROPOSED
        imSession.save(flush: true, failOnError: true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'imSessionInstance.label', default: 'IMSession'), imSession.id])
                redirect imSession
            }
            '*' { respond imSession, [status: CREATED] }
        }
    }

    def edit(Long id) {
        IMSession imSessionInstance = IMSession.get(id)
        User currentUser = springSecurityService.currentUser
        if (currentUser?.id in [imSessionInstance?.ownerId, imSessionInstance?.copresenterId] || currentUser?.isAdminOrImOwner()) {
            respond imSessionInstance
            return
        }
        redirect(controller: 'login', action: 'denied')
    }

    @Transactional
    def update(IMSession imSessionInstance) {
        if (imSessionInstance == null) {
            notFound()
            return
        }

        if (imSessionInstance.hasErrors()) {
            respond imSessionInstance.errors, view: 'edit'
            return
        }

        imSessionInstance.save flush: true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IMSession.label', default: 'IMSession'), imSessionInstance.id])
                redirect imSessionInstance
            }

            '*' { respond imSessionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(IMSession imSessionInstance) {

        flash.error = message(code: "session.not.deleted")
        redirect action: "index", method: "GET"

        /*if (imSessionInstance == null) {
            notFound()
            return
        }

        imSessionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'IMSession.label', default: 'IMSession'), imSessionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'imSessionInstance.label', default: 'IMSession'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
