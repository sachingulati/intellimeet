package com.ig.intellimeet

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(['ROLE_USER'])
import static org.springframework.http.HttpStatus.*

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
@Transactional(readOnly = true)
class TopicController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def topicService
    def springSecurityService

    def delete (){
        flash.error = message(code: "topic.not.deleted")
        redirect action: "index"
    }

    def plusOne() {
        Map mapToRender = ['status':'success']
        Integer currentInterestedUsersCount
        User currentUser  = springSecurityService?.currentUser
        mapToRender.username = currentUser?.username
        Topic topic = Topic.get(params.topicId)
        if(topic?.interestedUsers?.contains(currentUser?.id)) {
            mapToRender.status = 'error'
            mapToRender.message = message(code:'topic.interest.already.shown.message')
        } else if (topic) {
            topic = topicService.increaseInterestCount topic
            topicService.save topic
            currentInterestedUsersCount = topic?.interestedUsers?.size()
            mapToRender.count = currentInterestedUsersCount
        }
        render(mapToRender as JSON)
    }

    def index(Integer max) {
//        params.max = Math.min(max ?: 10, 100)
        respond Topic.list(), model: [topicInstanceCount: Topic.count()]
    }

    def create() {
        respond new Topic(params)
    }

    @Transactional
    def save(Topic topicInstance) {
        if (topicInstance == null) {
            notFound()
            return
        }

        if (topicInstance.hasErrors()) {
            respond topicInstance.errors, view: 'create'
            return
        }
        topicInstance.save flush: true
        redirect controller: 'topic', action:'index'
    }

    def edit(Topic topicInstance) {
        respond topicInstance
    }

    @Transactional
    def update(Topic topicInstance) {
        if (topicInstance == null) {
            notFound()
            return
        }

        if (topicInstance.hasErrors()) {
            respond topicInstance.errors, view: 'edit'
            return
        }

        topicInstance.save flush: true

        redirect controller: 'topic', action:'index'
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'topicInstance.label', default: 'Topic'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
