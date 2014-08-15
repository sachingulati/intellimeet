package com.ig.intellimeet

import org.grails.databinding.BindingFormat

class Employee {

    Long userId
    String firstName
    String lastName
    String employeeId
    @BindingFormat("MM/dd/yyyy")
    String dateOfBirth
    String cellNumber
    String emailAddress
    Map cloudinaryImage

    static mapWith = "mongo"

    static embedded = ['cloudinaryImage']

    static constraints = {
        userId nullable: false
        emailAddress nullable: false
        firstName nullable: true
        lastName nullable: true
        employeeId nullable: true
        dateOfBirth nullable: true
        cloudinaryImage nullable: true
        cellNumber nullable: true
    }
}
