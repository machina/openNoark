class UrlMappings {
    static mappings = {
        
      "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }        
     
      "/ws/$controller/$id?"{
            controller=$controller

            action="list"

            if( id ){
                action=[POST:"save",GET:"show",PUT:"update",DELETE:"delete"]
            }else{
                action=[POST:"save",GET:"list",PUT:"update",DELETE:"delete"]
            }

            parseRequest=true
        }
     

      "/"(view:"/index")
	  "500"(view:'/error')
    }
}
