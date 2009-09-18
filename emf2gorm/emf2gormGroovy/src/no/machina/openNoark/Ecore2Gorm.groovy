package no.machina.openNoark

class Ecore2Gorm {

	def transform(def pack){
		def classes = pack.eContents()
		classes.each{ tklass ->
		def klass = tklass
		if(tklass.getClass().toString().contains("GenClass") ) {
			klass = tklass.getEcoreClass()
		}
		println klass.name
		println klass

		println klass.getClass().name
		
		  StringWriter writer = new StringWriter()
		  def builder = new GormBuilder(writer)
		  def parent = klass.eSuperTypes.size() > 0 ? klass.eSuperTypes[0].name : null
		  builder."${klass.name}"(parent: parent){
		    println klass.eReferences
		    println klass.eAttributes
		    klass.eContents().each {
		      println it.getClass().name
		      switch(it.getClass().name){
		        case "org.eclipse.emf.ecore.impl.EAnnotationImpl":
		          break
		        case "org.eclipse.emf.ecore.impl.EGenericTypeImpl":
		          //TODO: these will have to be handled at some point
		          break
		        default:
		          def mul = "1"
		          if(it.isRequired()){
		            if(it.isMany()) {
		              mul = "1-M"
		            } else {
		              mul = "1"
		            }
		          } else {
		            if(it.isMany()) {
		              mul = "0-M"
		            } else {
		              mul = "0-1"
		            }

		          }
		          println "building for ${it.name}" 
		          "${it.name}"(type: translateType(it.eType.name) ,multiplicity: mul)
		          break
		      }//end switch
		    } //end klass.eContents

		  } //end builder
		  new File("/home/kent/out/domain/${klass.name}.groovy").write writer.toString()
		}//end classes
	}
		def translateType(type) {
		  if(type == "DateTime") return "Date"
		  if(type == null || type == "null") return "String"
		  return type
		}

	
	
}