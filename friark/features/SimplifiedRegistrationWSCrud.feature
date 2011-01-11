Feature: SimplifiedRecord CRUD
   In order to do basic operations on SimplifiedRecord
   As an authorized user
   I want to do CRUD operatoins on SimplifiedRecord

Scenario: Create a SimplifiedRecord
   Given an empty database 
      And I am logged in as admin
   When I POST a new object to the SimplifiedRecord Controller
   Then there should be 1 SimplifiedRecord in the database

Scenario: Update a SimplifiedRecord
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the SimplifiedRecord Controller
      And I create a updated SimplifiedRecord
      And I PUT the updated object to the SimplifiedRecord Controller
   Then the updated SimplifiedRecord should have the new title

Scenario: View a SimplifiedRecord
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the SimplifiedRecord Controller
      And I GET the created SimplifiedRecord
   Then the created SimplifiedRecord should be returned

Scenario: Delete a SimplifiedRecord
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the SimplifiedRecord Controller
      And I delete the SimplifiedRecord
   Then there should be 0 SimplifiedRecord in the database
