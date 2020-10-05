@activityJobs
Feature: Alchemy Jobs.
Scenario: Create a new user
Given user is on the Alchemy admin jobs website
When user added a new user
Then user should be able to view created user details
And user closes the page

Scenario: Searching for jobs using XPath
Given user is on the Alchemy jobs website
When user searched for a job
Then user changed the filter to show only FullTime Jobs
And user prints job list
Then user selects a job and apply for it
And user closes the page

Scenario: Posting a job using parameterization
Given user is on the Alchemy admin jobs website
When user go to Post a Job page
Then user enter details "NewJobName1", "Bangalore" and "IBM"
And user submit the job
Then user confirm "NewJobName1" listing is shown on page
And user closes the page


Scenario Outline: Using Examples table to post a job
Given user is on the Alchemy admin jobs website
When user go to Post a Job page
Then user enter details "<NewJob>", "<Location>" and "<NewCompany>"
And user submit the job
Then user confirm "<NewJob>" listing is shown on page
And user closes the page

Examples:
  |NewJob | NewLocation | NewCompany |
  |NewJobName2|Bangalore|IBM|