package com.ig.intellimeet

import grails.transaction.Transactional

@Transactional(readOnly = true)
class IntelliMeetController {

    static scaffold = true

    def delete(IntelliMeet intelliMeet) {
        flash.error = message(code: "intellimeet.deletion.restricted")
        redirect( view: "index")
    }
}
