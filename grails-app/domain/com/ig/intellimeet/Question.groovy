package com.ig.intellimeet

import com.ig.intellimeet.embedded.Option

class Question {

    String text
    List<Option> options

    static embedded = ['options']

    static mapWith = "mongo"

    static constraints = {
        text blank: false
    }
}
