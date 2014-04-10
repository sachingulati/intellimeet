package com.ig.intellimeet.embedded

import com.ig.intellimeet.enums.TopicStatus
import grails.validation.Validateable

@Validateable
class TopicStatusInfo {

    TopicStatus status
    Date date
}
