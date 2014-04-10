package com.ig.intellimeet

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class TopicController {
    static scaffold = true
}
