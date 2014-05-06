package com.ig.intellimeet



import grails.test.mixin.*
import spock.lang.*

@TestFor(IntelliMeetController)
@Mock(IntelliMeet)
class IntelliMeetControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.intelliMeetInstanceList
        model.intelliMeetInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.intelliMeetInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        def intelliMeet = new IntelliMeet()
        intelliMeet.validate()
        controller.save(intelliMeet)

        then: "The create view is rendered again with the correct model"
        model.intelliMeetInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        intelliMeet = new IntelliMeet(params)

        controller.save(intelliMeet)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/intelliMeet/show/1'
        controller.flash.message != null
        IntelliMeet.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def intelliMeet = new IntelliMeet(params)
        controller.show(intelliMeet)

        then: "A model is populated containing the domain instance"
        model.intelliMeetInstance == intelliMeet
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def intelliMeet = new IntelliMeet(params)
        controller.edit(intelliMeet)

        then: "A model is populated containing the domain instance"
        model.intelliMeetInstance == intelliMeet
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/intelliMeet/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def intelliMeet = new IntelliMeet()
        intelliMeet.validate()
        controller.update(intelliMeet)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.intelliMeetInstance == intelliMeet

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        intelliMeet = new IntelliMeet(params).save(flush: true)
        controller.update(intelliMeet)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/intelliMeet/show/$intelliMeet.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/intelliMeet/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def intelliMeet = new IntelliMeet(params).save(flush: true)

        then: "It exists"
        IntelliMeet.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(intelliMeet)

        then: "The instance is deleted"
        IntelliMeet.count() == 0
        response.redirectedUrl == '/intelliMeet/index'
        flash.message != null
    }
}
