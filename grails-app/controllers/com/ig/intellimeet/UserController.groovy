package com.ig.intellimeet



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

  static scaffold = true
}
