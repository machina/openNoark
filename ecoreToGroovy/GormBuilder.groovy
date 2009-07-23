import groovy.util.BuilderSupport  
   
class GormBuilder extends BuilderSupport {
		
		final int CLASS = 1
		final int ATTRS = 2

		int state = CLASS

		IndentPrinter out;
		
		def constaints = ""
		def hasMany = [:]	
	

		public GormBuilder(Writer writer) {
			this.out =	new IndentPrinter(new PrintWriter(writer))
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
						out.printIndent()
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
						break
				}
//				println "name: ${name}"
//				println "value ${value}"
        return attrs;
   }

	protected void nodeCompleted(Object parent, Object node) {
		if(!node || !node['multiplicity']) {
			out.println "static constraints = {\n${constaints}}"
			out.println "static hasMany = ${hasMany.toString()}"
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
