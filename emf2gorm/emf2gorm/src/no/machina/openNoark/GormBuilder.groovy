package no.machina.openNoark

import groovy.util.BuilderSupport  
import java.io.StringWriter

/**
 * A builder for Gorm classes
 * 
 * @author kent
 *
 */
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
	def afterLoad = ""
	def transients = []
	def toString = ""
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
			if(attrs && attrs['packageName']) out.println "package ${attrs['packageName']}"
			out.print "class ${name} "
			
			if(attrs && attrs['parent']) out.print "extends ${attrs['parent']}"
			out.println "{"
			out.incrementIndent()
			state = ATTRS
			break
			case ATTRS:
			if(name == "annotation"){
				if(attrs['annotation']){
					switch(attrs['annotation'].source){
						case "http://opennoark.machina.no/searchable":
						
							def searchable = "static searchable ="
							attrs['annotation'].details.keySet().each{ skey ->
								if(skey == "except")
									searchable += " [except: ['${attrs['annotation'].details.get(skey).split(',').join('\',\'')}']]"
							}
							if(searchable == "static searchable =") searchable += " true"
							extras = "${extras}${searchable}\n"
							break
					}
				} else {
					if(attrs['key'] == "documentation"){
						writer.buffer.insert(0,"/**\n${attrs['value']}\n*/\n")
					}else if(attrs['key'] == "mapping"){
						
						mappings = "${mappings}${attrs['value']}\n"
					}else if(attrs['key'] == "attribute"){
						extras = "${extras}${attrs['value']}\n"
					}else if(attrs['key'] == "transient"){
						extras = "${extras}${attrs['value']}\n"
						transients << "\"${attrs['value'].tokenize()[1]}\""
					}else if(attrs['key'] == "constraint"){
						constaints += "${attrs['value']}\n"
					}else if(attrs['key'] == "afterLoad"){
						afterLoad += "${attrs['value']}\n"
					}else if(attrs['key'] == "toString"){
						toString = "String toString(){${attrs['value']}}"
					}
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
				if(attrs['unique'] != null){
					constaints += "${name}(unique: ${attrs['unique']})\n"
				}
			}
			break
		}
		return attrs;
	}
	
	protected void nodeCompleted(Object parent, Object node) {
		if(!node || (!node['multiplicity']  && !node['key'] && !node['annotation'] )) {
			out.println "static constraints = {"
			out.incrementIndent()
			constaints.eachLine{
				out.println it
			}
			out.decrementIndent()
			out.println "}"
			
			out.println "static hasMany = ${hasMany.toString()}"
			
			out.println "static mapping = {"
			out.incrementIndent()
			
			mappings.eachLine{
				out.println it
			}
			out.decrementIndent()
			out.println "}"
			
			extras.eachLine { 
				out.println it
			}
			
			if(transients.size() > 0)
				out.println "static transients = ${transients}"
			
			if(afterLoad.length() > 0){
				out.println "def afterLoad = {"
				out.incrementIndent()
				afterLoad.eachLine { out.println it }
				out.decrementIndent()
				out.println "}"
			}
			
			if(toString.length() > 0) out.println toString
			
			out.decrementIndent()
			out.println "}"
		}
	}
}