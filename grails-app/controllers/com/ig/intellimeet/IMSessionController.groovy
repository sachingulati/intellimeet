package com.ig.intellimeet

import com.ig.intellimeet.co.IMSessionCO
import com.ig.intellimeet.enums.SessionStatus
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

    def index(Integer max) {
        //params.max = Math.min(max ?: 10, 100)
        //TODO - Fetch session list based on preference survey completed(Live) or not (prposed).
        IMSessionCO imSessionCO = intelliMeetService.getIMSessionList(null)
        respond imSessionCO.sessionList, model:[IMSessionInstanceCount: imSessionCO.totalCount]
    }

    def show(IMSession IMSessionInstance) {
        respond IMSessionInstance
    }

    def create() {
        respond new IMSession(params)
    }

    @Transactional
    def save(IMSessionCO imSessionCO) {
        if (imSessionCO == null) {
            notFound()
            return
        }

        if (!imSessionCO.validate()) {
            render  view:'create', model: [imSessionCO: imSessionCO]
            return
        }
        IMSession imSession = new IMSession()
        bindData(imSession, imSessionCO)
        imSession.intelliMeetId = intelliMeetService.getCurrentIntelliMeetId()
        imSession.sessionStatus = SessionStatus.PROPOSED
        imSession.save( flush:true, failOnError: true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'IMSessionInstance.label', default: 'IMSession'), imSession.id])
                redirect imSession
            }
            '*' { respond imSession, [status: CREATED] }
        }
    }

    def edit(IMSession IMSessionInstance) {
        IMSessionInstance = IMSession.get(IMSessionInstance.id)
        if (IMSessionInstance?.ownerId == springSecurityService.currentUser?.id || IMSessionInstance?.copresenterId == springSecurityService.currentUser?.id) {
            redirect(controller: 'login', action: 'denied')
            return
        }
        render view: 'edit', model: [IMSessionInstance: IMSessionInstance]
    }

    @Transactional
    def update(IMSession IMSessionInstance) {
        if (IMSessionInstance == null) {
            notFound()
            return
        }

        if (IMSessionInstance.hasErrors()) {
            respond IMSessionInstance.errors, view:'edit'
            return
        }

        IMSessionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IMSession.label', default: 'IMSession'), IMSessionInstance.id])
                redirect IMSessionInstance
            }
            '*'{ respond IMSessionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(IMSession IMSessionInstance) {

        flash.error = message(code: "session.not.deleted")
        redirect action:"index", method:"GET"

        /*if (IMSessionInstance == null) {
            notFound()
            return
        }

        IMSessionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'IMSession.label', default: 'IMSession'), IMSessionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'IMSessionInstance.label', default: 'IMSession'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
