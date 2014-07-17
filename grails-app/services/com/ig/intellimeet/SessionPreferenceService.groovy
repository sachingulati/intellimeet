package com.ig.intellimeet

class SessionPreferenceService {

    SessionPreference save(SessionPreference sessionPreference) {
        if (!(sessionPreference?.validate() && sessionPreference?.save(flush: true))) {
            log.error(sessionPreference?.errors?.allErrors?.join("\n"))
            sessionPreference = null
        }
        sessionPreference
    }
}
