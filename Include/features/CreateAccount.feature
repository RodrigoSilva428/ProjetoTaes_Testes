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

@account
Feature: Account creation
  To ensure users can register and prevent duplicates

  Background:
    Given the app is opened
    And the user taps the sign up button	

  Scenario: Create a new account successfully
    When the user enters a new unique username
    And the user enters password "pass123"
    And the user taps the create account button
    Then the account is successfully created

  Scenario: Attempt to create the same account again
    Given the same username was already created
    When the user enters that username
    And the user enters password "pass123"
    And the user taps the create account button
    Then I see an error "Account already exists"
