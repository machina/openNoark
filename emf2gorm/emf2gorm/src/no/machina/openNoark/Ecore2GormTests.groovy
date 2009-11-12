package no.machina.openNoark;

public class Ecore2GormTests {

	def transform(def pack){
		def name
	}


	def getPackageName(def pack){
		def name = ""
		pack.eContents().each{
			if(it.getClass().name == "org.eclipse.emf.ecore.impl.EAnnotationImpl" && it.name == "package"){
				return it.details.value[0] //TODO: make safer
			}
		}
	}
}