package com.ig.intellimeet

class UserTagLib {

    static namespace = "user"

    def displayUsername = { attrs ->
        out << User.get(attrs.userId)?.username
    }
}
