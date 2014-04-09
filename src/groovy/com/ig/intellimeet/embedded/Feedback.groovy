package com.ig.intellimeet.embedded

import grails.validation.Validateable

@Validateable
class Feedback {
    Long intelliMeetId
    String comment
    Integer score
    List<Answer> answers

    Date date

    static embedded = ['answers']

    static constraints = {
        score range: 1..5
        comment nullable: true
    }
}
