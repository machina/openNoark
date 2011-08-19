Feature: DocumentDescription CRUD
   In order to do basic operations on DocumentDescription
   As an authorized user
   I want to do CRUD operations on DocumentDescription

Scenario: Create a DocumentDescription
   Given an empty database 
      And I am logged in as admin
   When I POST a new object to the DocumentDescription Controller
   Then there should be 1 DocumentDescription in the database

Scenario: Update a DocumentDescription
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the DocumentDescription Controller
      And I create a updated DocumentDescription
      And I PUT the updated object to the DocumentDescription Controller
   Then the updated DocumentDescription should have the new title

Scenario: View a DocumentDescription
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the DocumentDescription Controller
      And I GET the created DocumentDescription
   Then the created DocumentDescription should be returned

Scenario: Delete a DocumentDescription
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the DocumentDescription Controller
      And I delete the DocumentDescription
   Then there should be 0 DocumentDescription in the database
