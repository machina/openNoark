Feature: Klass CRUD
	In order to du basic operations on Klass
	As an authorized user
	I want to do CRUD operatoins on Klasss

	Scenario: Create a Klass
		Given an empty database 
		And I am logged in as admin
		When I POST a new object to the Klass Controller
		Then there should be 1 Klass in the database

	Scenario: Update a Klass
		Given an empty database
		And I am logged in as admin
		When I POST a new object to the Klass Controller
		And I create a updated Klass
		And I PUT the updated object to the Klass Controller
		Then the updated Klass should have the new title

Scenario: View a Klass
    Given an empty database
    And I am logged in as admin
    When I POST a new object to the Klass Controller
    And I GET the created Klass
		Then the created Klass should be returned


Scenario: Delete a Klass
    Given an empty database
    And I am logged in as admin
    When I POST a new object to the Klass Controller
		And I delete the Klass
		Then there should be 0 Klass in the database
