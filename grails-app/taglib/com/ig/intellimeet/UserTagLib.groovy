package com.ig.intellimeet

class UserTagLib {

    static namespace = "user"
    def grailsApplication

    def displayUsername = { attrs ->
        out << User.get(attrs.userId)?.username
    }

    def displayUserImage = { attrs ->
        Employee employee = Employee.findByEmailAddress(attrs.email)
        String imageUrl = employee?.cloudinaryImage?.url ?: 'http://res.cloudinary.com/intellimeet/image/upload/v1408134423/placeholder_user.png'
        out << "<img src='${imageUrl}' width='200px' height='200px' class='center-block img-thumbnail img-responsive'/>"
    }

    def displayUserImageInMainNav = { attrs ->
        Employee employee = Employee.findByEmailAddress(attrs.email)
        String imageUrl = employee?.cloudinaryImage?.url ?: 'http://res.cloudinary.com/intellimeet/image/upload/v1408134423/placeholder_user.png'
        out << "<img src='${imageUrl}' width=40px height='40px' class='img-circle'/>"
    }
}
