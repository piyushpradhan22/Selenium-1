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
Feature: Login to Newtours
Keywords Summary : This test will verify login related scenario.
	I want to use this template for my feature file

@tag1
Scenario: login with valid credentials
Given User navigated to Newtours
When User enter username as "User" and Password as "password"
	And User click on login button
Then Login should be successful

@tag2
Scenario: login with invalid credentials
Given User navigated to Newtours
When User enter username as "User" and Password as "password"
	And User click on login button
Then Login should not be successful


