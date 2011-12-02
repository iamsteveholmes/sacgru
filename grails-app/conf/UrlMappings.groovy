class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/page"(controller:"page")


        "/page/$title?"(controller:"page")
        
        "/page/create"(controller:"page", action: 'create')

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
