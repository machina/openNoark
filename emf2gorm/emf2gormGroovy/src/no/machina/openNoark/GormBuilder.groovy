package no.machina.openNoark

import groovy.util.BuilderSupport  
import java.io.StringWriter

class GormBuilder extends BuilderSupport {
		
		final int CLASS = 1
		final int ATTRS = 2

		int state = CLASS

		IndentPrinter out;
		StringWriter writer;
		def constaints = ""
		def hasMany = [:]	
		def mappings = ""
		def extras = ""
		def transients = []
			
		public GormBuilder(Writer writer) {
			this.writer = writer
			this.out =	new IndentPrinter(new PrintWriter(writer))
			def printlnMethod = this.out.&println
			this.out.metaClass.println = {String s ->
			    printIndent()
			    printlnMethod.call(s)
			}
		}

	protected void setParent(Object parent, Object child) {  
  	if(parent)  
    	parent[parent['name']] = child  
	}

		
   
   protected Object createNode(Object name) {  
     createNode name, null, null  
   }  
   
   protected Object createNode(Object name, Object value) {  
     createNode name, null, value  
   }  
   
   protected Object createNode(Object name, Map attrs) {  
     createNode name, attrs, null  
   }  
   
   protected Object createNode(Object name, Map attrs, Object value) {
			  switch(state){
					case CLASS:
							out.print "class ${name} "
							if(attrs && attrs['parent']) out.print "extends ${attrs['parent']}"
							out.println "{"
							out.incrementIndent()
							state = ATTRS
						break
					case ATTRS:
						//println "name: ${name}"
						//println "attrs: ${attrs}"
						//out.printIndent()
						if(name == "annotation"){
							if(attrs['key'] == "documentation"){
								writer.buffer.insert(0,"/**\n${attrs['value']}\n*/\n")
							}else if(attrs['key'] == "mapping"){
								println "adding mapping: ${attrs['value']}"	
								mappings = "${mappings}${attrs['value']}\n"
							}else if(attrs['key'] == "attribute"){
								extras = "${extras}${attrs['value']}\n"
							}else if(attrs['key'] == "transient"){
								extras = "${extras}${attrs['value']}\n"
								transients << "\"${attrs['value'].tokenize()[1]}\""
							}
							
						}else {
						
							if(attrs['multiplicity'] =~ /.*-M/){
								hasMany[name] = attrs['type']
							} else {
								out.println "${attrs['type']} ${name}"
							}
							switch(attrs['multiplicity']){
								case "1":
									constaints += "${name}(nullable: false)\n"
									break
								case "1-M":
									constaints += "${name}(minSize: 1)\n"
									break
								case "0-1":
								case "0-M":
									constaints += "${name}(nullable: true)\n"
									break
							}
						}
						break
				}
//				println "name: ${name}"
//				println "value ${value}"
        return attrs;
   }

	protected void nodeCompleted(Object parent, Object node) {
		if(!node || (!node['multiplicity']  && !node['key'])) {
			out.println "static constraints = {" //\n${constaints}}"
			out.incrementIndent()
			constaints.eachLine{
				out.println it
			}
			out.decrementIndent()
			out.println "}"
			
			out.println "static hasMany = ${hasMany.toString()}"

			out.println "static mapping = {"
			out.incrementIndent()
			println "MAPPINGS: ${mappings}"
			mappings.eachLine{
				out.println it
			}
			out.decrementIndent()
			out.println "}"
			
			extras.eachLine { 
				out.println it
			}
			
		    out.decrementIndent()
			out.println "}"
		}
	}
}  

/*

StringWriter sw = new StringWriter()
builder = new GormBuilder(sw);

builder.Arkiv {
	dill(type: "int", multiplicity: "1")
	dall(type: "String", multiplicity: "0-1")
	
	bla(type: "Custom", multiplicity: "0-M")
	snoft(type: "Custom", multiplicity: "1-M")
}


println sw;*/
