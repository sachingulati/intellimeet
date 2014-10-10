package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional(readOnly = false)
@Secured(['ROLE_ADMIN'])
class UserController {

    def springSecurityService
    def userService
    def topicService
    def imSessionService

    @Secured(['ROLE_ADMIN'])
    def index() {
        params.max = Math.min(params.int('max') ?: 10, 100)
        respond User.list(params), model: [userInstanceCount: User.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def toggleAccount(Long id) {
        User user = User.get(id)
        user?.enabled = !user?.enabled
        userService.save(user)
        render "SUCCESS"
    }

    @Secured(['ROLE_ADMIN'])
    def search() {
        params.max = Math.min(params.int('max') ?: 10, 100)
        render view: 'index', model: [
                userInstanceList : User.findAllByUsernameIlike("%${params?.q ?: ''}%", params),
                userInstanceCount: User.findAllByUsernameIlike("%${params?.q ?: ''}%")?.size()]

    }


    @Secured(['ROLE_USER'])
    def profile() {
        User currentUser = (User) springSecurityService.currentUser
        Employee employeeInstance = Employee?.findByUserId(currentUser?.id) ?: new Employee(userId: currentUser?.id, emailAddress: currentUser?.username)
        [employeeInstance: employeeInstance]
    }

    @Secured(['ROLE_USER'])
    def uploadImage() {
        MultipartFile userImage = params.userImage
        User currentUser = (User) springSecurityService?.currentUser
        try {
            userService.uploadUserImage(userImage.bytes, currentUser)
        } catch (Exception e) {
            log.info("Exception occurred while saving image")
        }
        redirect controller: 'user', action: 'profile'
    }

    @Secured(['ROLE_USER'])
    def save(Employee employeeInstance) {
        if (employeeInstance.hasErrors()) {
            flash.error = 'Validation failed! Please fill all the required fields.'
        }
        userService.save employeeInstance
        flash.message = "User profile information has been saved successfully."
        redirect controller: 'user', action: 'profile'
    }

    @Secured(['IS_AUTHENTICATED_FULLY'])
    def dashboard() {
        List<Topic> recentTopics = topicService.listRecentlyCreatedTopics(10)
        List<IMSession> recentProposedSessions = imSessionService.listRecentlyCreatedSessions(10)
        render(view: "dashboard", model:[recentTopics: recentTopics, recentProposedSessions: recentProposedSessions])
    }
}
