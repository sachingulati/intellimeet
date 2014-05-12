package com.ig.intellimeet.dto

import grails.validation.Validateable

@Validateable
class MailDTO {

    String to
    List<String> toList
    List<String> ccList
    List<String> bccList
    String subject
    String body

}
