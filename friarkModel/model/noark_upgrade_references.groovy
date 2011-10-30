import groovy.xml.StreamingMarkupBuilder
//println new File(args[0]).text
def slurper = new XmlSlurper()
def root = slurper.parseText(new File(args[0]).text)
//println root
root.children().each{ println it.name() }
def refs = root.'**'.findAll{it.name() == 'eStructuralFeatures' && it.@type == 'ecore:EReference'} 
//println refs

refs.each{ it.replaceNode{node -> 
def targetName = node.@eType.toString()
targetName = targetName.substring(targetName.lastIndexOf('/')+1)
def low = node.@lowerBound
if(low == null || low == '') low = '0'
def up = node.@upperBound
if(up == null || up == '') up = '1'
def unique = node.@unique == null || node.@unique == '' ? 'true' : node.@unique
references(name:node.@name, unique:unique, upperBound:up, lowerBound:low, target:"//@members[name='${targetName}']")  } }

println root.dump()
def file = new File(args[0])
def str = new StreamingMarkupBuilder().bind{
            out << root
        }.toString()
file.write(str)
//new File(args[0]).write(root.toString())
