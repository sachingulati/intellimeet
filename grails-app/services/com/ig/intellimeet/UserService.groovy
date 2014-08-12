package com.ig.intellimeet

import grails.transaction.Transactional

@Transactional(readOnly = false)
class UserService {

    def cloudinaryService

    def save(User userInstance) {
        if(!(userInstance?.validate() && userInstance?.save(flush: true))) {
            log.error(userInstance?.errors?.allErrors?.join('\n'))
            userInstance = null
        }
        userInstance
    }

    void uploadUserImage(byte[] bytes, User user) {
        cloudinaryService.deleteByUserName(user?.username)
        cloudinaryService.uploadImage(bytes, user?.username, ['user', 'image'])
    }

}
