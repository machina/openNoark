Feature: ClassificationSystem CRUD
	 In order to do basic operations on ClassificationSystem
	 As an authorized user
	 I want to do CRUD operatoins on ClassificationSystems

Scenario: Create a ClassificationSystem
	  Given an empty database 
	     And I am logged in as admin
	  When I POST a new object to the ClassificationSystem Controller
	  Then there should be 1 ClassificationSystem in the database

Scenario: Update a ClassificationSystem
	  Given an empty database
	     And I am logged in as admin
	  When I POST a new object to the ClassificationSystem Controller
	     And I create a updated ClassificationSystem
 	     And I PUT the updated object to the ClassificationSystem Controller
	  Then the updated ClassificationSystem should have the new title

Scenario: View a ClassificationSystem
	  Given an empty database
	     And I am logged in as admin
	  When I POST a new object to the ClassificationSystem Controller
	     And I GET the created ClassificationSystem
	  Then the created ClassificationSystem should be returned

Scenario: Delete a ClassificationSystem
	  Given an empty database
	     And I am logged in as admin
	  When I POST a new object to the ClassificationSystem Controller
	     And I delete the ClassificationSystem
	  Then there should be 0 ClassificationSystem in the database
