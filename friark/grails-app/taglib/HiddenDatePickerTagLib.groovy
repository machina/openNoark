import org.codehaus.groovy.grails.plugins.web.taglib.FormTagLib


class HiddenDatePickerTagLib {
	static namespace = 'friark'

	def hiddenDateField = { attrs ->
		//def out 
		def name = attrs.name
		def date = attrs.date

		out << "<input type=\"hidden\" name=\"${name}\" value=\"struct\" />"

		out << "<input type=\"hidden\" name=\"${name}_year\" value=\"${date.format("yyyy")}\" />"

		out << "<input type=\"hidden\" name=\"${name}_month\" value=\"${date.format("MM")}\" />"

		out << "<input type=\"hidden\" name=\"${name}_day\" value=\"${date.format("dd")}\" />"

	}	

	def mselect = { attrs ->
		println "MSELECT"
		def type = attrs.type
		def ftl = new FormTagLib()
	
		if(type == "select"){
			mselect_select(ftl, attrs)
		} else if(type == "radio"){
			mselect_radio(ftl, attrs)
		} else {
			throw new Exception("Type ${type} not supported in mselect")
		}
		
		
	}

	private mselect_select = { ftl, attrs ->
		out.println "<select name=\"${attrs['name']}\" id=\"${attrs['id']}\" MULTIPLE>"
		attrs.from.each{
			out.println "<option value=\"${it.ident()}\">${it.toString()}</option>"
		}

		out.println "</select>"
	}

	private mselect_radio = { ftl, attrs ->
		ftl.radio(attrs)
    out << ftl.out.toString()
 }


	def controllerFor = {attrs ->
		def obj = attrs.obj
		def className = obj.getClass().getName()[obj.getClass().getName().lastIndexOf('.') +1..obj.getClass().getName().length() - 1]
		switch(className){
			case "SimplifiedRecord":
				out << "registrering"
				break
			case "Fonds":
				out << "arkiv"
				break
			case "ClassificationSystem":
				out << "classificationSystem"			
				break
			default:
				out << className.toLowerCase()
		}
	}
}
