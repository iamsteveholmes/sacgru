class UrlMappings {

	static mappings = {
		/*"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}*/

        "/page"(controller:"page")

        "/page/save"(controller: 'page', action: 'save')

        "/page/$title/edit"(controller: 'page', action: 'edit')

        "/page/update"(controller: 'page', action: 'update')

        "/page/$title?"(controller:"page")

		"/"{
            controller = 'page'
            action = 'index'
            title = 'home'
        }
		"500"(view:'/error')
	}
}
