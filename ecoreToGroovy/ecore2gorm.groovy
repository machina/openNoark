//loosly after http://www.ibm.com/developerworks/library/os-eclipse-dynamicemf/


import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.*

ResourceSet load_resourceSet = new ResourceSetImpl();

load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
EPackage noarkEPackage = theCoreFactory.createEPackage();
noarkEPackage.name = "noark"
noarkEPackage.nsPrefix = "noark"
noarkEPackage.nsURI = "http://www.machina.no/noark"
load_resourceSet.getPackageRegistry().put( "http://www.machina.no/noark", noarkEPackage); 

Resource load_resource = load_resourceSet.getResource(URI.createURI("./noark.ecore"),true);

println load_resource

def pack  = load_resource.getContents()[0]

println pack.name

def classes = pack.eContents()

classes.each{ klass ->
//	println klass.name
//	println klass
	StringWriter writer = new StringWriter()
	def builder = new GormBuilder(writer)
	def parent = klass.eSuperTypes.size() > 0 ? klass.eSuperTypes[0].name : null
	builder."${klass.name}"(parent: parent){
		println klass.eReferences
		println klass.eAttributes
		klass.eContents().each {
			println it
			switch(it){
				case org.eclipse.emf.ecore.impl.EAnnotationImpl:
					break
				case org.eclipse.emf.ecore.impl.EGenericTypeImpl:
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
					"${it.name}"(type: translateType(it.eType.name) ,multiplicity: mul)
					break	
			}//end switch
		} //end klass.eContents
		
	} //end builder
	new File("domain/${klass.name}.groovy").write writer.toString()
}//end classes

def translateType(type) {
	if(type == "DateTime") return "Date"
	if(type == null || type == "null") return "String"
	return type
}


//println load_resource[0]

