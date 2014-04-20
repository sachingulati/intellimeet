package com.ig.intellimeet

class BasicFormTagLib {

    static namespace = "basicForm"

    def inputField = { attrs ->
        out << render(template: '/basicForm/inputField', model: [name: attrs.name, value: attrs.value, type: attrs.type ?: 'text', label: attrs.label, bean: attrs.bean, required: attrs.required])
    }
}
