package com.ig.intellimeet

class SurveyTagLib {

    static namespace = "survey"

    def question = { attrs->
        out << render(template: '/survey/question', model: [name: attrs.name, text: attrs.text, options: attrs.options])
    }
}
