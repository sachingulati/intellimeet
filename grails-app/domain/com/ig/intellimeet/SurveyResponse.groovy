package com.ig.intellimeet

import com.ig.intellimeet.embedded.Answer

class SurveyResponse {
    List<Answer> answers
    static belongsTo = [survey: Survey]
    static mapWith = "mongo"
    static embedded = ['answers']
    static constraints = {
    }
}
