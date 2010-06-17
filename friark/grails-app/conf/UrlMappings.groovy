class UrlMappings {
    static mappings = {
        
      "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }        
     
//			"/ws/arkiv/$id?"(resource:"arkiv")

      "/ws/$controller"(parseRequest:true){
            controller=$controller
							 action=[POST:"save",GET:"list",PUT:"update",DELETE:"delete"]
           // parseRequest=true
        }
 
      "/ws/$controller/$id"(parseRequest:true){
            controller=$controller
	            action=[POST:"save",GET:"show",PUT:"update",DELETE:"delete"]
           // parseRequest=true
        }

			"/ws/search/$clazz/$query/"() {
				controller='search'
				action='search'
			}

			"/ws/search/$query/"() {
        controller='search'
        action='search'
     	}

      "/"(view:"/index")
	  "500"(view:'/error')
    }
}
