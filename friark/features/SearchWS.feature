Feature: Search
	In order to retrive information
	As an authorized user
	I want to be able to do searches

	Scenario: Search a Fonds
		Given an empty database 
		And I am logged in as admin
		When I POST a new object to the Fonds Controller
		And I search in all for "Test Fonds 1"
		Then 1 Fonds should be returned

	Scenario: Search a Fonds as Fonds
		Given an empty database 
		And I am logged in as admin
		When I POST a new object to the Series Controller
		And I search in Fonds for "Test"
		Then 1 Fonds should be returned
		And 0 Series should be returned
	
	Scenario: Search a Registration as OEP
		Given an empty database 
		And I am logged in as admin
		When I POST a new object to the SimplifiedRecord Controller
		And I search in all for "Test SimplifiedRecord" as OEP
		Then an OEP journal with 1 posts is returned


