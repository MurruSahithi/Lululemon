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

Feature: Amazon Search Functionality Testing

  
  Scenario: Perform a valid search on Amazon
    Given User opens the chrome browser
    When User opens the Amazon url "https://shop.lululemon.com"
    And User enters search item "Bag" in the search bar
    And User clicks on search button
    Then User should see search results for "Bag"
    And User should close the browser

 