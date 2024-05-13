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

Feature: Lululemon Search Functionality Testing

  
  Scenario: Perform a valid search on Lululemon
    Given User opens the chrome browser
    When User opens the Website url "https://shop.lululemon.com"
    And User enters search item "Bag" in the search bar
    Then User should see search results for "Bag"
    And User should close the browser
    
  Scenario: Perform a invalid search on Lululemon
    Given User opens the chrome browser
    When User opens the Website url "https://shop.lululemon.com"
    And User enters invalid search item "Bgg" in the search bar
    Then User should see search results as "No search results found"
    And User should close the browser
    
   Scenario: Perform a search and select suggestion on Lululemon
    Given User opens the chrome browser
    When User opens the Website url "https://shop.lululemon.com"
    And User enters partial search item "Bag" in the search bar
    Then User should see search suggestions containing "Bag"
    And User selects the product "Fanny Bag" from the search suggestions
    Then User should see search results for "Fanny Bag"
    And User should close the browser
    
   Scenario: Perform a search pagination on Lululemon
    Given User opens the chrome browser
    When User opens the Website url "https://shop.lululemon.com"
    And User enters search item "Bag" in the search bar
    Then User should see search results for "Bag"
    And User stores the initial results of the webpage as "InitialResults"
    And User navigates to load the next page of search results
    Then User should see the next set of search results
    And User should close the browser

 