package com.ig.intellimeet

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import org.codehaus.groovy.grails.plugins.testing.GrailsMockMultipartFile
import spock.lang.Specification

@TestFor(UserController)
@TestMixin(DomainClassUnitTestMixin)
class UserControllerSpec extends Specification {

    void setup() {
        User.metaClass.encodePassword = {->}
        mockDomain(User, [new User(username: 'johndoe@gmail.com', password: 'abc')])
        controller.springSecurityService = [currentUser: new User(username: 'johndoe@intellimeet.com')]
    }

    void "UserController: profile"() {
        setup:
        def model

        when:
        model = controller.profile()

        then:
        model.userInstance != null
    }

    void "UserController: uploadImage(), Check redirect"() {
        setup:
        def file

        when:
        file = new GrailsMockMultipartFile('userImage', 'abc.png', 'image/png', 'sample'.bytes)
        params.userImage = file
        controller.uploadImage()

        then:
        response.redirectUrl == '/user/profile'
    }

    void "UserController: save(User userInstance), Valid save"() {
        setup:
        User userInstance
        def userServiceMock = mockFor(UserService)
        userServiceMock.demand.save(1..1) { user ->
            return new User()
        }
        controller.userService = userServiceMock.createMock()

        when:
        userInstance = new User(username: 'johndoe+1@gmail.com', password: 'temp')
        controller.save(userInstance)

        then:
        response.redirectUrl == '/user/profile'
    }
}
