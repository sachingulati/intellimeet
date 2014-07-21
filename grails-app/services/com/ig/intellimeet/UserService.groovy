package com.ig.intellimeet

class UserService {

    def save(User userInstance) {
        if(!(userInstance?.validate() && userInstance?.save(flush: true))) {
            log.error(userInstance?.errors?.allErrors?.join('\n'))
            userInstance = null
        }
        userInstance
    }
}
