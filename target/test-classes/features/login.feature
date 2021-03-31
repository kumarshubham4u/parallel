#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login QA Click Academy

  @tag1
  Scenario Outline: Positive Test Validating Login
    Given Initailize chrome browser
    And Navigate to "qaclickacademy" website
    And User clicks on Login Link to land on secure sign-in page
    When User enter <email> and <password> and logs in
    Then Verify that user is successfully logged in

    Examples: 
      | email             | password |
      | test99@gmail.com  |   123456 |
      | test101@gmail.com |  1245677 |
