package com.ig.intellimeet

import com.ig.intellimeet.co.IMSessionCO

class IMSessionController {

    def scaffold = true

    def createNewSessionFromTopic(Long topicId) {
        Topic topic = Topic.get(topicId)
        IMSessionCO imSessionCO = topic ? new IMSessionCO(topic) : new IMSessionCO()
        render view: 'create', model: [imSessionCO: imSessionCO]
    }

}
