class UrlMappings {
    static mappings = {
        
      "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }        
     
      "/ws/$controller/$id?"(parseRequest:true){
            controller=$controller
            action="list"

            if( $id ){
                action=[POST:"save",GET:"show",PUT:"edit",DELETE:"delete"]
            }else{
                action=[POST:"save",GET:"list",PUT:"edit",DELETE:"delete"]
            }
        }

      "/"(view:"/index")
	  "500"(view:'/error')
    }
}
