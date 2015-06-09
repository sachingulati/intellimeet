package com.ig.intellimeet

class SurveyResponse {
    List<String> answers
    static belongsTo = [survey: Survey]
    static mapWith = "mongo"
    static constraints = {
    }
}
