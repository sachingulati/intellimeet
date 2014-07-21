package com.ig.intellimeet

class FormTagLib {

    static namespace = "form"

    def inputField = { attrs ->
        out << render(template: '/formTemplates/inputField', model: [name: attrs.name, value: attrs.value, type: attrs.type ?: 'text', label: attrs.label, errors: attrs.errors, required: attrs.required])
    }

    def checkbox = { attrs ->
        out << render(template: '/formTemplates/checkbox', model: [name: attrs.name, value: attrs.value, label: attrs.label, hasError: attrs.hasError, required: attrs.required])
    }

    def textField = {
        out << render(template: '/formTemplates/inputField', model: [name:attrs.name, value: attrs.value, type: 'text', label: attrs.label, errors: attrs.errors, required: attrs.required])
    }
}
