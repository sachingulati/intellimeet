class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/preference/user/save" (controller:"userPreference", action: "save")


        "/api/v1.0/$controller/$id"(parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete"]
            constraints {
                id(matches: /\d+/)
            }
        }

        "/api/v1.0/$controller"(parseRequest: true) {
            action = [GET: "list", POST: "save"]
        }

        "/api/v1.0/$controller/$action"(parseRequest: true)
        "/api/v1.0/$controller/$action/$id"(parseRequest: true)

        "/"(view:"index")
//        "/"(view:"/intelliMeet/report")
        "/about"(view:"/about")
        "500"(view:'/error')
	}
}
