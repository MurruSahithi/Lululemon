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

Feature: Myntra pagination testing

    
   Scenario: Perform a search pagination from one page to another page on myntra
    Given User opens the firefox browser
    When User opens the Website url "http://www.myntra.com"
    And User enters search item "Shrug" in the myntra search bar
    Then User should see all the search results for "Shrug" in myntra
    And User stores the initial page value of the webpage in myntra
    And User navigates to load the next page of search results in myntra
    Then User should see the next set of search results in myntra
    And User navigates to load the previous page of search results in myntra
    Then User should see the prev set of search results in myntra
    And User should close the browser
