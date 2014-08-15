package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class UserController {

    def springSecurityService
    def userService


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
        if(employeeInstance.hasErrors()) {
           flash.error = 'Validation failed! Please fill all the required fields.'
        }
        userService.save employeeInstance
        flash.message = "User profile information has been saved successfully."
        redirect controller: 'user', action: 'profile'
    }
}
