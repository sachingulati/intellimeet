package com.ig.intellimeet

import com.ig.intellimeet.co.UserPreferenceCO

class UserPreferenceService {

    def intelliMeetService

    UserPreference save(UserPreference userPreference) {
        if(!userPreference?.validate() || userPreference?.save(failOnError: true, flush: true)) {
            userPreference = null
        }
        userPreference
    }

    UserPreference extractUserPreference(UserPreferenceCO userPreferenceCO) {
        UserPreference userPreference = new UserPreference()
        userPreference.firstPreferredSessionId = userPreferenceCO?.firstPreferredSessionId
        userPreference.secondPreferredSessionId = userPreferenceCO?.secondPreferredSessionId
        userPreference.thirdPreferredSessionId = userPreferenceCO?.thirdPreferredSessionId
        userPreference
    }
}
