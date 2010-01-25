class HiddenDatePickerTagLib {
	static namespace = 'friark'

	def hiddenDateField = { attrs ->
		
		def name = attrs.name
		def date = attrs.date

		out << "<input type=\"hidden\" name=\"${name}\" value=\"struct\" />"

		out << "<input type=\"hidden\" name=\"${name}_year\" value=\"${date.format("yyyy")}\" />"

		out << "<input type=\"hidden\" name=\"${name}_month\" value=\"${date.format("MM")}\" />"

		out << "<input type=\"hidden\" name=\"${name}_day\" value=\"${date.format("dd")}\" />"

	}	
}
