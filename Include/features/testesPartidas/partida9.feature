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
@Partidas
Feature: Start a game of bisca 3

Scenario: The user starts a game of Bisca
    Given the user is logged in with username "correctUser" and password "correctPassword"
    And the user taps the Iniciar Bisca 9 button
    And the user taps the Start Next Round button
    Then the user verifies that a game started