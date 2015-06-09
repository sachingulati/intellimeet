package com.ig.intellimeet

import com.ig.intellimeet.embedded.Option
import com.ig.intellimeet.enums.QuestionType

class Question {
    int num
    String text
    List<Option> options
    QuestionType type
    static embedded = ['options']

    static mapWith = "mongo"

    static constraints = {
        text blank: false
    }
}
