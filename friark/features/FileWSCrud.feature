Feature: File CRUD
   In order to do basic operations on File
   As an authorized user
   I want to do CRUD operations on File

Scenario: Create a File
   Given an empty database 
      And I am logged in as admin
   When I POST a new object to the File Controller
   Then there should be 1 File in the database

Scenario: Update a File
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the File Controller
      And I create a updated File
      And I PUT the updated object to the File Controller
   Then the updated File should have the new title

Scenario: View a File
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the File Controller
      And I GET the created File
   Then the created File should be returned

Scenario: Delete a File
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the File Controller
      And I delete the File
   Then there should be 0 File in the database
