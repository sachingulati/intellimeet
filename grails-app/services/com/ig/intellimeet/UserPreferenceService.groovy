package com.ig.intellimeet

import com.ig.intellimeet.co.UserPreferenceCO

class UserPreferenceService {

    def intelliMeetService
    def springSecurityService

    UserPreference save(UserPreference userPreference) {
        if(!userPreference?.validate() || !userPreference?.save(failOnError: true, flush: true)) {
            log.error(userPreference?.errors?.allErrors?.join("\n"))
            userPreference = null
        }
        userPreference
    }

    UserPreference extractUserPreference(UserPreferenceCO userPreferenceCO, Token token) {
        UserPreference userPreference = new UserPreference()
        userPreference.intelliMeetId = token?.intelliMeetId
        userPreference.userId = token?.userId
        userPreference.firstPreferredSessionId = userPreferenceCO?.firstPreferredSessionId
        userPreference.secondPreferredSessionId = userPreferenceCO?.secondPreferredSessionId
        userPreference.thirdPreferredSessionId = userPreferenceCO?.thirdPreferredSessionId
        userPreference
    }

    Boolean hasFilledPreferences() {
        UserPreference.countByIntelliMeetIdAndUserId(intelliMeetService?.currentIntelliMeetId, springSecurityService?.currentUser?.id)
    }

    Boolean hasFilledPreferences(Long userId) {
        UserPreference.countByIntelliMeetIdAndUserId(intelliMeetService?.currentIntelliMeetId, userId)
    }
}
