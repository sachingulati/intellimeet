package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class UserController {

    def cloudinaryService
    def springSecurityService
    def userService


    @Secured(['ROLE_USER'])
    def profile() {
        User currentUser = (User) springSecurityService.currentUser
        [userInstance: currentUser]
    }

    @Secured(['ROLE_USER'])
    def uploadImage() {
        MultipartFile userImage = params.userImage
        User currentUser = (User) springSecurityService?.currentUser
        try {
            cloudinaryService.uploadImage(userImage.bytes, currentUser?.username, ['user', 'image'])
        } catch (Exception e) {
            log.info("Exception occurred while saving image")
        }
        redirect controller: 'user', action: 'profile'
    }

    @Secured(['ROLE_USER'])
    def save(User userInstance) {
        if(userInstance.hasErrors()) {
           flash.error = 'Validation failed! Please fill all the required fields.'
        }
        userService.save userInstance
        redirect controller: 'user', action: 'profile'
    }
}
