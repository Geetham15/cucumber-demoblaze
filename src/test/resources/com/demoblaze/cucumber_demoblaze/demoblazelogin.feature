#Author: Geetham15@gmail.com
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
@regression @login
Feature: Login feature
  I want to use this template for testing login functionality

  @positive
  Scenario: valid username and valid password scenario
    Given I am on the login page
    When I enter "geetha1" and "geetha1"
    Then I should be successfully logged in

  @negative
  Scenario Outline: invalid username and invalid password testing
    Given I am on the login page
    When I enter "<username>" and "<password>"
    Then I should get login error message

    Examples: 
      | username | password |
      | geetha1  | geetha   |
      | vanathi1 | vanathi  |
