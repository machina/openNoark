Feature: Fonds CRUD
   In order to do basic operations on Fonds
   As an authorized user
   I want to do CRUD operations on FONDS

Scenario: Create a Fonds
   Given an empty database 
      And I am logged in as admin
   When I POST a new object to the Fonds Controller
   Then there should be 1 Fonds in the database

Scenario: Update a Fonds
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the Fonds Controller
      And I create a updated Fonds
      And I PUT the updated object to the Fonds Controller
   Then the updated Fonds should have the new title

Scenario: View a Fonds
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the Fonds Controller
      And I GET the created Fonds
   Then the created Fonds should be returned

Scenario: Delete a Fonds
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the Fonds Controller
      And I delete the Fonds
   Then there should be 0 Fonds in the database
