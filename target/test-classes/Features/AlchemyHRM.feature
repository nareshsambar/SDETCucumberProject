@activityHRM
Feature: Alchemy HRM.

Scenario: Creating a job vacancy for DevOPS Engineer
Given user login to the OrangeHRM Page
When user Navigate to vacancies menu from Recruitment page
Then user adds a Job Vacancy
And user verifies the added vacancy 
And user closes OrangeHRM page

Scenario: adding a candidate for recruitment
Given user login to the OrangeHRM Page
When user Navigate to Recruitment page
Then user adds a candidate
And user verifies added candidate
And user closes OrangeHRM page

Scenario Outline: Add multiple employees
Given user login to the OrangeHRM Page
When user navigates to PIM page
Then user adds a employee with details "<NewFName>", "<NewLName>"
And user enters further details "<NewUserName>", "<NewStatus>"
Then user verifies the created employee "<NewFName>", "<NewLName>"
And user closes OrangeHRM page
Examples: 
|NewFName|NewLName|NewStatus|NewUserName| 
|NewFN1|NewLN1|Enabled|NewUN1|
|NewFN2|NewLN2|Enabled|NewUN2|

Scenario Outline: Creating multiple vacancies
Given user login to the OrangeHRM Page
When user Navigate to vacancies menu from Recruitment page
Then user adds a candidate with details "<NewVName>", "<NewHManager>", "<NewJTitle>"
And user verifies added candidate with details "<NewVName>", "<NewHManager>", "<NewJTitle>"
And user closes OrangeHRM page

Examples: 
|NewVName|NewHManager|NewJTitle|
|newJobVacancyName77|FirstName1 LastName1|Automation Test Engineer|
|newJobVacancyName99|FirstName1 LastName1|Automation Test Engineer|