class ArchiveFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testSomeWebsiteFeature() {
        // Here call get(uri) or post(uri) to start the session
        // and then use the custom assertXXXX calls etc to check the response
        //
        // get('/something')
        // assertStatus 200
        // assertContentContains 'the expected text'
    }

	void testNew(){	
		get("/arkiv/create")
		assertStatus 200
		assertNotNull page.forms['archive']
		assertNotNull  page.forms['archive'].getInputsByName("tittel")
		assertEquals 1,  page.forms['archive'].getInputsByName("tittel").size()
	}
}
