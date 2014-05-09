package com.ig.intellimeet

import com.ig.intellimeet.dto.Mail
/**
 * Created by behl on 5/8/14.
 */
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
