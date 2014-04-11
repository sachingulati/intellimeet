package applicationFilter

class AppFilterFilters {

    def filters = {
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
