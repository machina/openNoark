class UrlMappings {
    static mappings = {
		
		"/remote/$controller/$id?"(parseRequest:true) {
			action = [GET: "show", POST: "save",DELETE: "delete", PUT: "update"]
		}
 
	  "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }

      "/"(view:"/index")
	  "500"(view:'/error')
	}
}
