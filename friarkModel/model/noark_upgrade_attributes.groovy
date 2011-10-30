import groovy.xml.StreamingMarkupBuilder
//println new File(args[0]).text
def slurper = new XmlSlurper()
def root = slurper.parseText(new File(args[0]).text)
println root
root.children().each{ println it.name() }
def refs = root.'**'.findAll{it.name() == 'eStructuralFeatures' && it.@type == 'ecore:EAttribute'} 
println refs

refs.each{ it.replaceNode{node -> 
def targetName = node.@name.toString()
def unique = node.@unique == null || node.@unique == '' ? 'true' : node.@unique
def required = node.@lowerBound== null || node.@lowerBound== '' ? 'false' : node.@lowerBound.toInteger() > 0
def many = node.@upperBound == null || node.@unique == '' ?'false' : node.@upperBound =="-1"
def href = node.eType.@href
//def sup = node.@eSuperTypes
//if( sup != null && sup != '') sup = sup.substring(sup.lastIndexOf('/')+1)
attributes(name:targetName, unique: unique, required: required, many: many){
	type(href: href)
}

}}

println root.dump()
def file = new File(args[0])
def str = new StreamingMarkupBuilder().bind{
            out << root
        }.toString()
file.write(str)
//new File(args[0]).write(root.toString())
