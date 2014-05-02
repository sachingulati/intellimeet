package com.ig.intellimeet

class ApplicationFilters {

    def springSecurityService
    def filters = {

        saveActions(controller:'*', action:'save') {
            before = {
                params.createdBy = springSecurityService.currentUser?.id
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

        all(controller:'*', action:'*') {
            before = {
                println("AppFilter : Params: ${params}")
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
