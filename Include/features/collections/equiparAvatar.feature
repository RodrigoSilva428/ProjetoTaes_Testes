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
@Collection
Feature: Equip avatar

Scenario Outline: Edit the password in the profile and equip avatar
    Given the user is logged in with username "correctUser" and password "correctPassword"
    When the user navigates to the collection page
    And the user selects avatar "<AvatarName>"
    And the user taps the save collection button
    And the user navigates to the profile page
    Then the user confirms he has the right avatar equipped

Examples:
  | AvatarName       |
  | Mage Avatar      |
  | Archer Avatar    |
  | Rogue Avatar     |
  | Default Avatar   |