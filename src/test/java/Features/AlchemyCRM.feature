@activityCRM
Feature: Alchemy CRM.

Scenario: Counting Dashlets
Given user is on the Alchemy CRM website
When user count the dashlets
Then user prints all dashlet titles
And user closes the CRM page

Scenario: Create leads using parameterization
Given user is on the Alchemy CRM website
When user navigate to the lead
Then user creates new lead with the following details "Mr.", "newFirstName", "newLastName", "1111"
And user navigates to view leads
And user closes the CRM page

Scenario: Schedule a meeting and invite members
Given user is on the Alchemy CRM website
When user navigates to schedule meeting
Then user enter details for meeting "zzzz", "10/20/2020", "Max", "allen", "abc"
And user verifies the created meeting with "zzzz"
And user closes the CRM page

Scenario Outline: Create a Product
Given user is on the Alchemy CRM website
When user navigates to products
Then user enter details for new product "<NewPName>" and "<NewPrice>"
And user verifies created record "<NewPName>"
And user closes the CRM page

Examples:
  |NewPName |NewPrice|
  |NewPName1|99.99|