package com.ig.intellimeet

class QuestionTemplate {

    static constraints = {
    }
    String title
    static mapWith = "mongo"
    static hasMany = [questions: Question]
    static embedded = ['questions']
}
