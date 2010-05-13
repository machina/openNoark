/*
 import org.eclipse.core.runtime.QualifiedName;
 This file is part of Friark.
 Friark is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 Friark is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with Friark.  If not, see <http://www.gnu.org/licenses/>.
 */

package no.machina.openNoark

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.File;
import java.io.StringReader;
import org.eclipse.core.resources.*

/**
 * This class transforms a GenModel Package to Gorm classes.
 * 
 * @author kent
 */
class Ecore2Gorm {
	/**
	 * Transforms a Genmodel package to Gorm classes and writes them to the src directory in the gemmodels project.
	 * 
	 * @param pack the Genmodel package
	 * @param the name of the Eclipse project where the genmodel recides.
	 * @return void
	 */
	def transform(def pack, def projectName){
		String packageName = getPackageName(pack);
		def classes = pack.eContents()
		
		//Iterate over each class in the model
		classes.each{ tklass ->
			//Get the EcoreClass
			def klass = tklass
			if(tklass.getClass().toString().contains("GenClass") ) {
				klass = tklass.getEcoreClass()
			}
			
			//Create the GormBuilder
			StringWriter writer = new StringWriter()
			def builder = new GormBuilder(writer)
			def parent = klass.eSuperTypes.size() > 0 ? klass.eSuperTypes[0].name : null
			def documentation = ""
			
			//Build the class
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
						def mul = findMultiplicity(it)
						//call the builder with the current attribute
						"${it.name}"(type: translateType(it.eType.name) ,multiplicity: mul, unique: it.isUnique())
						break
					}//end switch
				} //end klass.eContents
				
			} //end builder
			
			//Write the class to file			
			try{ 
				IProject project = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
				
				def src = getSrc(project)
				
				def pkg = src
				if(!pkg.exists()) pkg.create false, false, null
				packageName.tokenize('.').each{
					if(pkg instanceof File){
						pkg = new File(pkg.getAbsolutePath() + File.separator + it)
					} else {
						pkg = pkg.getFolder(it)
					}
					if(!pkg.exists()) pkg.create false, false, null
				}
								
				def f
				if( pkg instanceof File){
					f = new File( pkg.getAbsolutePath() + File.separator +  "${klass.name}.groovy")
					if(f.exists()) f.delete()
				} else {
					f = pkg.getFile("${klass.name}.groovy")
					if(f.exists()) f.delete true, null
				}
				
				
				//if(f.exists()) f.delete true, null
				ByteArrayInputStream is = new ByteArrayInputStream(writer.toString().getBytes());
				if(f instanceof File){
					f.append is
				} else {
					f.create(is, true, null)
				}
				//f.write writer.toString()
				
				
			}catch(Exception e){
				e.printStackTrace()
			}
			
			
		}//end classes
	}
	
	def getSrc(IProject project){
		String dir = "";
		try {
			dir = project.getPersistentProperty(
					new QualifiedName(Platform.getBundle("emf2gorm").getSymbolicName(), "generateToDir")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		def src
		if(dir != ""){
			src = new File(dir)
			def getFile = {String file -> 
				if(delegate.isDirectory()){
					return new File(delegate, file)
				}
				return null;
			} 
			def create = {boolean a, boolean b, Object o ->
				if(!delegate.exists()){
					delegate.mkdirs()
				}
			}
			getFile.setDelegate src
			create.setDelegate src
			src.metaClass.getFile = getFile
			src.metaClass.create = create
		} else {
			src = project.getFolder("src")
		}
		return src;
	}
	
	/**
	 * Find the attributes multiplicity
	 * @param obj The attribute
	 * @return A String deswcribing its multiplicity. One of "1", "1-M", "0-M", "0-1".
	 */
	String findMultiplicity(def obj){
		def mul = "1"
		if(obj.isRequired()){
			if(obj.isMany()) {
				mul = "1-M"
			} else {
				mul = "1"
			}
		} else {
			if(obj.isMany()) {
				mul = "0-M"
			} else {
				mul = "0-1"
			}
		}
		return mul
	}
	
	/**
	 * Translates types from Ecore to Grom
	 * @param type the type String to tranlate
	 * @return the translated type
	 */
	def translateType(type) {
		if(type == "DateTime") return "Date"
		if(type == null || type == "null") return "String"
		return type
	}
	
	/**
	 * Retrived the packagename from the Genmodel package
	 * @param pack the package
	 * @return the package name.
	 */
	String getPackageName(def pack){
		def name = ""
		if(pack.getClass().name == "org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl") pack = pack.getEcorePackage()
		return pack.getEAnnotation("package") == null ? "" : pack.getEAnnotation("package").details.value[0].toString()
		
	}
	
}