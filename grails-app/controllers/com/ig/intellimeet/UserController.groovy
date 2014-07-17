package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class UserController {

    def cloudinaryService
    def springSecurityService
    def grailsApplication
    static scaffold = true

    def uploadImage() {
    }

    def saveImage() {
        CommonsMultipartFile userImage = params.userImage
        log.info("Image name ${userImage.originalFilename}")
        User currentUser = springSecurityService?.currentUser
        try {
            cloudinaryService.uploadImage(userImage.bytes, grailsApplication.config.cloudinary.dir as String, currentUser?.username, ['user', 'image'])
        } catch (Exception e) {
            log.info("Exception occurred while saving image")
        }
        redirect controller: 'user', action: 'uploadImage'
    }
}
