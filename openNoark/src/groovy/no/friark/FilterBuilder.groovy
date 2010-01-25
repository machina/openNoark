package no.friark

class FilterBuilder extends BuilderSupport {

		Filter filter = new Filter()

	  void setParent(Object parent, Object child){

		}
    
		Object createNode(Object name){
			
		}
    Object createNode(Object name, Object value){

		}
    Object createNode(Object name, Map attributes){
			switch(name){
				case "mappe":
					attributes.keySet().toArray().each{	key ->
						filter.mappe[key] = attributes[key]
					}
					break
				case "klasse":
					attributes.keySet().toArray().each{ key ->
   	        filter.klasse[key] = attributes[key]
          }
					break
				case "arkivdel":
          attributes.keySet().toArray().each{ key ->
   	        filter.arkivdel[key] = attributes[key]
          }
					break
			}
		}
    Object createNode(Object name, Map attributes, Object value){

		}
    Object getName(String methodName){
			return methodName
		}
}
