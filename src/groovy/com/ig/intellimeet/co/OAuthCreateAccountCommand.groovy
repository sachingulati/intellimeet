package com.ig.intellimeet.co

import com.ig.intellimeet.User
import grails.validation.Validateable

@Validateable
class OAuthCreateAccountCommand {

    String username
    String password1
    String password2

    static constraints = {
        username blank: false, validator: { String username, command ->
            User.withNewSession { session ->
                if (username && User.countByUsername(username)) {
                    return 'OAuthCreateAccountCommand.username.error.unique'
                }
            }
        }
        password1 blank: false, minSize: 8, maxSize: 64, validator: { password1, command ->
            if (command.username && command.username.equals(password1)) {
                return 'OAuthCreateAccountCommand.password.error.username'
            }

            if (password1 && password1.length() >= 8 && password1.length() <= 64 &&
                    (!password1.matches('^.*\\p{Alpha}.*$') ||
                            !password1.matches('^.*\\p{Digit}.*$') ||
                            !password1.matches('^.*[!@#$%^&].*$'))) {
                return 'OAuthCreateAccountCommand.password.error.strength'
            }
        }
        password2 nullable: true, blank: true, validator: { password2, command ->
            if (command.password1 != password2) {
                return 'OAuthCreateAccountCommand.password.error.mismatch'
            }
        }
    }
}
