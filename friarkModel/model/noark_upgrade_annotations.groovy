import groovy.xml.StreamingMarkupBuilder
//println new File(args[0]).text
def slurper = new XmlSlurper()
def root = slurper.parseText(new File(args[0]).text)
println root
root.children().each{ println it.name() }
def refs = root.'**'.findAll{it.name() == 'eAnnotations'} 
println refs

refs.each{ 
if(it.@source == "http://www.eclipse.org/emf/2002/GenModel"){
	def doc = ""
	it.children().each{ node ->
		if(node.@key == "documentation") doc += node.@value
	}
	println "'$doc'"
	if(doc != ""){
		it.replaceNode{ node ->
			documentation(value: doc)
		}
	}
} else if(it.@source == "http://opennoark.machina.no"){
	def conts = []
	def attrs = []
	it.children().each{ node ->
                if(node.@key == "constraint") conts << node.@value
		if(node.@key == "attribute") attrs << node.@value

        }
	it.replaceNode{node -> 
		conts.each{ constratint ->
			println constratint.text()
			def constr = "$constratint".replaceAll("amp;#xA;", "--NEWLINE--")
			println constr
			constraints(type:"CustomConstraint", value:"$constr")
		}
		attrs.each{ attr ->
			if(!attr.text().contains('static loggable') && !attr.text().contains('static searchable')){
			def attr_ = "$attr".replaceAll("amp;#xA;", "--NEWLINE--")			
			constraints(type:"ClassAttribute", value:"$attr_")
			}

		}
	}

	
} else {
	it.replaceNode{node -> 
	}
}

}
def file = new File(args[0])
def str = new StreamingMarkupBuilder().bind{
            out << root
        }.toString()
file.write(str)
//new File(args[0]).write(root.toString())
