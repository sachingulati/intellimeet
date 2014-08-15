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

    def save(Employee employee) {
        if(!(employee?.validate() && employee?.save(flush: true))) {
            log.error(employee?.errors?.allErrors?.join('\n'))
            employee = null
        }
        employee
    }

    void uploadUserImage(byte[] bytes, User user) {
        cloudinaryService.deleteByUserName(user?.username)
        Employee employee = Employee.findByUserId(user?.id) ?: new Employee(emailAddress: user?.username, userId: user?.id)
        employee.cloudinaryImage = cloudinaryService.uploadImage(bytes, user?.username, ['user', 'image'])
        save employee
    }

}
