package com.ig.intellimeet.co

import grails.validation.Validateable

@Validateable
class OAuthLinkAccountCommand {

    String username
    String password

    static constraints = {
        username blank: false
        password blank: false
    }

}
