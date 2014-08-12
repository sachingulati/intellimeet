package com.ig.intellimeet

import com.ig.intellimeet.co.IntelliMeetCO
import com.ig.intellimeet.enums.IntelliMeetStatus
import com.ig.intellimeet.utils.TestUtil
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.web.ControllerUnitTestMixin
import spock.lang.Specification

@TestFor(IntelliMeetController)
@Mock([Role, UserRole])
@TestMixin([ControllerUnitTestMixin, DomainClassUnitTestMixin])
class IntelliMeetControllerSpec extends Specification {

    void setup() {
        mockDomain(IntelliMeet, [[title: "IM", status: IntelliMeetStatus.IN_ACTIVE, dateOfEvent: TestUtil.stringToDate("03/12/1990")]])
        mockForConstraintsTests(IntelliMeetCO)
        def intelliMeetServiceMock = mockFor(IntelliMeetService)
        intelliMeetServiceMock.demand.getCurrentIntelliMeet(1..1) {->
            IntelliMeet.findByTitle('IM')
        }
        intelliMeetServiceMock.demand.updateStatus(1..1) { IntelliMeet currentIntelliMeet, IntelliMeetStatus status ->

        }
        intelliMeetServiceMock.demand.removeLikesFromAllTopics(1..1) {->

        }
        intelliMeetServiceMock.demand.revokeRoleFromAllUsers(1..1) { Role roleIMOwner ->

        }
        intelliMeetServiceMock.demand.assignOrgranizerRoles(1..1) { IntelliMeet intellimeet ->

        }
        intelliMeetServiceMock.demand.save(1..1) { IntelliMeet intelliMeet ->

        }
        controller.intelliMeetService = intelliMeetServiceMock.createMock()
    }

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        params['title'] = 'IntelliMeet - Date'
        params['status'] = IntelliMeetStatus.ACTIVE
        params['dateOfEvent'] = "01/15/2014"
        params['firstOwnerId'] = 1l
        params['secondOwnerId'] = 2l
    }

    void "Test the index action returns the correct model"() {

        when:
        "The" +
                " index action is executed"
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

        setup:
        IntelliMeetCO intelliMeetCO

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        intelliMeetCO = new IntelliMeetCO()
        intelliMeetCO.validate()
        controller.save(intelliMeetCO)

        then: "The create view is rendered again with the correct model"
        model.intelliMeetCO != null
        view == '/intelliMeet/create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        intelliMeetCO = new IntelliMeetCO(params)
        intelliMeetCO.validate()
        controller.save(intelliMeetCO)

        then: "A redirect is issued to index action"
        response.redirectedUrl == '/index'
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

        then: "A redirect is issues to the index action"
        response.redirectedUrl == "/intelliMeet/show/$intelliMeet.id"
        flash.message != null
    }
}
