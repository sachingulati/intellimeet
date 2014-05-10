package com.ig.intellimeet.co

import grails.validation.Validateable

@Validateable
class UserPreferenceCO {
    Long firstPreferredSessionId
    Long secondPreferredSessionId
    Long thirdPreferredSessionId

}
