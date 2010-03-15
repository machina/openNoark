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
		//save out
		def old_out = out
		//reset out into something we can controll
    out = new StringWriter()
		ftl.out = out
		//get the original select and trick it to use this out
		def select = ftl.select
		select.setDelegate(this)
		select(attrs)

		//add "multiple" to the select tag
		def result = out.toString()
		def matcher = (result =~ />/)
		result = matcher.replaceFirst("MULTIPLE>")

		//put out back and wirte the tag
		out = old_out
		out << result
	}

	private mselect_radio = { ftl, attrs ->
		ftl.radio(attrs)
    out << ftl.out.toString()
  }

}
