package com.ig.intellimeet

class UserTagLib {

    static namespace = "user"
    def grailsApplication

    def displayUsername = { attrs ->
        out << User.get(attrs.userId)?.username
    }

    def displayUserImage = { attrs ->
        String imageUrl = grailsApplication.config.cloudinary.baseUrl + attrs.email + grailsApplication.config.cloudinary.mimeType
        out << "<img src='${imageUrl}' height='100px' width='100px'/>"
    }
}
