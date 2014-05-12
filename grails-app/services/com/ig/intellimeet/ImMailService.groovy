package com.ig.intellimeet

import com.ig.intellimeet.dto.MailDTO

class ImMailService {

    def asynchronousMailService
    def grailsApplication

    def sendMail(MailDTO mailDto) {
        log.info("Sending email to ${mailDto?.to}")
        if (!mailDto?.hasErrors()) {
            asynchronousMailService.sendMail {
                to mailDto.to
                from fromAddress
                if (mailDto.ccList) {
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

    String getFromAddress() {
        grailsApplication?.config?.grails?.mail?.username
    }
}
