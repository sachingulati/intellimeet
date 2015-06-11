package com.ig.intellimeet.embedded

import com.ig.intellimeet.Question
import grails.validation.Validateable

@Validateable
class Answer {

    Long questionId
    String answer
    String questionText

    String comment
//    static embedded = ['question']

    static constraints = {
        questionText blank: false
    }

    void setQuestionId(Long questionId) {
        this.questionId = questionId
        this.questionText = Question.get(questionId)?.text
    }
}
