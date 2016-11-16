Feature: Test Automation
#Assupmption: Before running these scenarios, no content is present in the application.
#So before we run these scenarios please make sure that no data is present.

  Scenario: Create Entry
    Given I login to Hotel Management Platform
    When I create a entry with details as "TestHotelName" and "TestAddress" and "TestOwner" and "TestPhoneNumber" and "TestEmail"
    Then A row with entry created

  Scenario: Delete Entry
    Given I login to Hotel Management Platform
    And a entry already existed
    When I click on delete entry
    Then entry is deleted

  Scenario Outline: Creation of Multiple Entries
    Given I login to Hotel Management Platform
    When I create with <HotelName> and <Address> and <Owner> and <PhoneNumber> and <Email>
     Then A row with entry created

    Examples: 
      | HotelName         | Address        | Owner        | PhoneNumber | Email        |
      | Test HN1 		  | TestAddress1   | TestOwner1   | 7777777     | abc1@xyz.com |
      | Test HN2 		  | TestAddress2   | TestOwner2   | 8888888     | abc2@xyz.com|
      | Test HN3 		  | TestAddress3   | TestOwner3   | 9999999     | abc3@xyz.com |
      | Test HN4 		  | TestAddress4   | TestOwner4   | 1111111     | abc4@xyz.com |
      | Test HN5 		  | TestAddress5   | TestOwner5   | 2222222     | abc5@xyz.com |
   
      
