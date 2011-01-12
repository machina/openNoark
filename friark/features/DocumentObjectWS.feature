Feature: DocumentObject CRUD
   In order to do basic operations on DocumentObject
   As an authorized user
   I want to do CRUD operatoins on DocumentObject

Scenario: Create a DocumentObject
   Given an empty database 
      And I am logged in as admin
   When I POST a new object to the DocumentObject Controller
   Then there should be 1 DocumentObject in the database

Scenario: Update a DocumentObject
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the DocumentObject Controller
      And I create a updated DocumentObject
      And I PUT the updated object to the DocumentObject Controller
   Then the updated DocumentObject should have the new title

Scenario: View a DocumentObject
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the DocumentObject Controller
      And I GET the created DocumentObject
   Then the created DocumentObject should be returned

Scenario: Delete a DocumentObject
   Given an empty database
      And I am logged in as admin
   When I POST a new object to the DocumentObject Controller
      And I delete the DocumentObject
   Then there should be 0 DocumentObject in the database
