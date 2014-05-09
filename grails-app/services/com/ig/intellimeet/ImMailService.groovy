package com.ig.intellimeet

import com.ig.intellimeet.dto.Mail

class ImMailService {

    def asynchronousMailService

    def sendMail (Mail mail) {
        asynchronousMailService.sendMail {
            to mail.toList
            if(mail.ccList) {
                cc mail.ccList
            }
            if (mail.bccList) {
                bcc mail.bccList
            }
            subject mail.subject
            html mail.body
        }

    }
}
