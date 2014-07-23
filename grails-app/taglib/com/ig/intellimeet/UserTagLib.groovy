package com.ig.intellimeet

class UserTagLib {

    static namespace = "user"
    def grailsApplication

    def displayUsername = { attrs ->
        out << User.get(attrs.userId)?.username
    }

    def displayUserImage = { attrs ->
        def cloudinaryConfig = grailsApplication.config.cloudinary.config
        String imageUrl = "${cloudinaryConfig.baseUrl}/${attrs.email}.${cloudinaryConfig.mimeType}"
        out << "<img src='${imageUrl}' width='200px' height='200px' class='center-block img-thumbnail img-responsive'/>"
    }
}
