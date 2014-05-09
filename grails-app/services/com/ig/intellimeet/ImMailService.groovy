package com.ig.intellimeet

import com.ig.intellimeet.dto.MailDTO

class ImMailService {

    def asynchronousMailService

    def sendMail (MailDTO mailDto) {
        asynchronousMailService.sendMail {
            to mailDto.toList
            if(mailDto.ccList) {
                cc mailDto.ccList
            }
            if (mailDto.bccList) {
                bcc mailDto.bccList
            }
            subject mailDto.subject
            html mailDto.body
        }

    }
}
