package no.machina.openNoark

import java.io.File;



class Ecore2Gorm {

	def transform(def pack){
		String packageName = getPackageName(pack);
		def classes = pack.eContents()
		classes.each{ tklass ->
		def klass = tklass
		if(tklass.getClass().toString().contains("GenClass") ) {
			klass = tklass.getEcoreClass()
		}
		println klass.name
		println klass

		println klass.getClass().name
		println "packageName: ${packageName}"
		  StringWriter writer = new StringWriter()
		  def builder = new GormBuilder(writer)
		  def parent = klass.eSuperTypes.size() > 0 ? klass.eSuperTypes[0].name : null
	      def documentation = ""
		  builder."${klass.name}"(parent: parent, packageName: packageName){
		    //println klass.eReferences
		    //println klass.eAttributes
		    klass.eContents().each {
		      println it.getClass().name
		      switch(it.getClass().name){
		        case "org.eclipse.emf.ecore.impl.EAnnotationImpl":
		        	 println "key ${it.details.key[0]}"
		          	 //if(it.details.key[0] == "documentation") {
		        	 //	  println "setting doc to ${it.details.value[0]}"
		        	 //	  documentation = it.details.value[0]
		        	 // } else {
		        	 	if(it.source == "http://opennoark.machina.no/searchable"){
		        	 		println "searchable"
		        	 		builder.annotation(annotation: it)
		        	 	}else {
		        		  builder.annotation(key: it.details.key[0], value: it.details.value[0], details: it.details )
		        	 	}
		        	 // }
		        	   
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
		          "${it.name}"(type: translateType(it.eType.name) ,multiplicity: mul, unique: it.isUnique())
		          break
		      }//end switch
		    } //end klass.eContents

		  } //end builder

		  println "writing to file, package: ${packageName}"
		  try{
			  File f = new File("/home/kent/out/domain/${packageName.split('.').join('/')}")
			  boolean b = f.mkdirs()
			  println "mkdirs: ${b}"
			  f = new File("/home/kent/out/domain/${packageName.split('.').join('/')}/${klass.name}.groovy")
			  
			  f.write writer.toString()
			  println "write successfull"
		  }catch(Exception e){
			  e.printStackTrace()
		  }
		  
		  
		}//end classes
	}
	def translateType(type) {
	    if(type == "DateTime") return "Date"
		if(type == null || type == "null") return "String"
		return type
	}

	String getPackageName(def pack){
		def name = ""
		if(pack.getClass().name == "org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl") pack = pack.getEcorePackage()
		return pack.getEAnnotation("package") == null ? "" : pack.getEAnnotation("package").details.value[0].toString()
		
	}
	
}