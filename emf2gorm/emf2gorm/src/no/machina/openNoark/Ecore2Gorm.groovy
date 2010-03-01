package no.machina.openNoark

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.File;
import java.io.StringReader;
import org.eclipse.core.resources.*


class Ecore2Gorm {
	
	def transform(def pack, def projectName){
		String packageName = getPackageName(pack);
		def classes = pack.eContents()
		classes.each{ tklass ->
			def klass = tklass
			if(tklass.getClass().toString().contains("GenClass") ) {
				klass = tklass.getEcoreClass()
			}
			
			StringWriter writer = new StringWriter()
			def builder = new GormBuilder(writer)
			def parent = klass.eSuperTypes.size() > 0 ? klass.eSuperTypes[0].name : null
			def documentation = ""
			builder."${klass.name}"(parent: parent, packageName: packageName){
				klass.eContents().each {
					
					switch(it.getClass().name){
						case "org.eclipse.emf.ecore.impl.EAnnotationImpl":
						
						if(it.source == "http://opennoark.machina.no/searchable"){
							
							builder.annotation(annotation: it)
						}else {
							builder.annotation(key: it.details.key[0], value: it.details.value[0], details: it.details )
						}
						
						
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
						"${it.name}"(type: translateType(it.eType.name) ,multiplicity: mul, unique: it.isUnique())
						break
					}//end switch
				} //end klass.eContents
				
			} //end builder
			
			
			
			try{ 
				IProject project = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
				IFolder src = project.getFolder("src")
				
				IFolder pkg = src
				packageName.tokenize('.').each{
					pkg = pkg.getFolder(it)
					if(!pkg.exists()) pkg.create false, false, null
				}
				IFile f = pkg.getFile("${klass.name}.groovy")//new File("src/${packageName.split('.').join('/')}")
				if(f.exists()) f.delete true, null
				ByteArrayInputStream is = new ByteArrayInputStream(writer.toString().getBytes());
				f.create(is, true, null)
				//f.write writer.toString()
				
				
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