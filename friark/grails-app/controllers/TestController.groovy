import no.friark.ds.*
class TestController {

    def index = { }

		def clearAll = {
			def delete = { it.delete() }
			BevaringOgKassasjon.list().collect delete
			Dokumentlink.list().collect delete
			Dokumentobjekt.list().collect delete
			Dokumentbeskrivelse.list().collect delete
			ForenkletRegistrering.list().collect delete
			Basismappe.list().collect delete
			Arkivdel.list().collect delete
			Arkiv.list().collect delete
			Klasse.list().collect delete

      Klassifikasjonssystem.list().collect delete
			render "<html><body>done</body></html>"
		}
}
