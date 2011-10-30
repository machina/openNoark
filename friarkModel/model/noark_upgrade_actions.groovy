import groovy.xml.StreamingMarkupBuilder
//println new File(args[0]).text
def slurper = new XmlSlurper()
def root = slurper.parseText(new File(args[0]).text)
println root
root.children().each{ println it.name() }
def refs = root.'**'.findAll{it.name() == 'eOperations' && it.@type == 'MVCore:EAction'} 

refs.each{ it.replaceNode{node -> 

def targetName= node.@eType.toString()
if(targetName == null || targetName == ''){
actions(name: node.@name)
} else {
targetName = targetName.substring(targetName.lastIndexOf('/')+1)

actions(name: node.@name, operatesOn: "//\\subPackages.0/@members[name='${targetName}']")
}
}}
def file = new File(args[0])
def str = new StreamingMarkupBuilder().bind{
            out << root
        }.toString()
file.write(str)
//new File(args[0]).write(root.toString())
