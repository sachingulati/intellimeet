package com.ig.intellimeet

class ApplicationFilters {

    def springSecurityService
    def filters = {

        saveActions(controller:'*', action:'save') {
            before = {
                params.createdBy = springSecurityService.currentUser?.id
                println("AppFilter : Params: ${params}")
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }

        all(controller:'*', action:'*') {
            before = {
                log.info(params)
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
