Feature: Series CRUD
	In order to du basic operations on Series
	As an authorized user
	I want to do CRUD operatoins on Series

	Scenario: Create a Series
		Given an empty database 
		And I am logged in as admin
		When I POST a new object to the Series Controller
		Then there should be 1 Series in the database

	Scenario: Update a Series
		Given an empty database
		And I am logged in as admin
		When I POST a new object to the Series Controller
		And I create a updated Series
		And I PUT the updated object to the Series Controller
		Then the updated Series should have the new title

Scenario: View a Series
    Given an empty database
    And I am logged in as admin
    When I POST a new object to the Series Controller
    And I GET the created Series
		Then the created Series should be returned


Scenario: Delete a Fonds
    Given an empty database
    And I am logged in as admin
    When I POST a new object to the Series Controller
		And I delete the Series
		Then there should be 0 Series in the database
