package com.ig.intellimeet

class UserTagLib {

    static namespace = "user"
    def grailsApplication

    def displayUsername = { attrs ->
        out << User.get(attrs.userId)?.username
    }

    def displayUserImage = { attrs ->
        def cloudinaryConfig = grailsApplication.config.cloudinary
        String imageUrl = "${cloudinaryConfig.baseUrl}/${attrs.email}.${cloudinaryConfig.mimeType}"
        out << "<img src='${imageUrl}' width='150px' class='center-block img-circle img-responsive'/>"
    }
}
