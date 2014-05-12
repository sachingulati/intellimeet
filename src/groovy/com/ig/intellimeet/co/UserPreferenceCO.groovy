package com.ig.intellimeet.co

import grails.validation.Validateable

@Validateable
class UserPreferenceCO {
    String tokenId
    Long firstPreferredSessionId
    Long secondPreferredSessionId
    Long thirdPreferredSessionId

}
