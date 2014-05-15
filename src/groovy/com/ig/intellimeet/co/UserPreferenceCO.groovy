package com.ig.intellimeet.co

import grails.validation.Validateable

@Validateable
class UserPreferenceCO {
    String tokenId
    Long firstPreferredSessionId
    Long secondPreferredSessionId
    Long thirdPreferredSessionId

    static constraints = {
        firstPreferredSessionId nullable: true, validator: { val, obj ->
            if (val && (val == obj?.secondPreferredSessionId || val == obj?.thirdPreferredSessionId || ((obj?.secondPreferredSessionId == obj?.thirdPreferredSessionId) && obj?.secondPreferredSessionId))) {
                return ['preference.unique.error']
            }
        }
        secondPreferredSessionId nullable: true
        thirdPreferredSessionId nullable: true
    }

}
