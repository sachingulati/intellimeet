package com.ig.intellimeet

import com.ig.intellimeet.co.UserPreferenceCO

class UserPreferenceService {

    def intelliMeetService
    def springSecurityService

    UserPreference save(UserPreference userPreference) {
        if(!userPreference?.validate() || userPreference?.save(failOnError: true, flush: true)) {
            log.error(userPreference?.errors?.allErrors?.join("\n"))
            userPreference = null
        }
        userPreference
    }

    UserPreference extractUserPreference(UserPreferenceCO userPreferenceCO) {
        UserPreference userPreference = new UserPreference()
        userPreference.intelliMeetId = intelliMeetService?.currentIntelliMeetId
        userPreference.userId = springSecurityService?.currentUser?.id
        userPreference.firstPreferredSessionId = userPreferenceCO?.firstPreferredSessionId
        userPreference.secondPreferredSessionId = userPreferenceCO?.secondPreferredSessionId
        userPreference.thirdPreferredSessionId = userPreferenceCO?.thirdPreferredSessionId
        userPreference
    }

    Boolean hasFilledPreferences() {
        UserPreference.countByIntelliMeetIdAndUserId(intelliMeetService?.currentIntelliMeetId, springSecurityService?.currentUser?.id)
    }
}
