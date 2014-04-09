package com.ig.intellimeet

import embedded.Option

class Question {

    String text
    List<Option> options

    static embedded = ['options']

    static mapWith = "mongo"

    static constraints = {
    }
}
