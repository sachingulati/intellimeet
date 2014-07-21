package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class UserController {

    def cloudinaryService
    def springSecurityService


    @Secured(['ROLE_USER'])
    def profile() {
    }

    @Secured(['ROLE_USER'])
    def uploadImage() {
        CommonsMultipartFile userImage = params.userImage
        User currentUser = (User) springSecurityService?.currentUser
        try {
            cloudinaryService.uploadImage(userImage.bytes, currentUser?.username, ['user', 'image'])
        } catch (Exception e) {
            log.info("Exception occurred while saving image")
        }
        redirect controller: 'user', action: 'profile'
    }
}
