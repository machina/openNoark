Feature: Fonds
   In order to satisfy requirements on Fonds
   As an authorized user
   I want to do operatoins on Fonds and recive the correct result

Scenario: Create a Fonds with systemID
   Given an empty database 
      And I am logged in as admin
   When I POST a new object to the Fonds Controller
   Then systemID should be set
