class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/preference/user/save" (controller:"userPreference", action: "save")

        "/"(view:"/index")
        "/about"(view:"/about")
        "500"(view:'/error')
	}
}
