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
    Given User opens the edge browser
		When User opens the Website url "https://shop.lululemon.com"
		And User enters valid search item "Bag" in the search bar
		Then User should see search results for "Bag"
		And User enters a exact valid search item "ribbed midi dress" in the search bar
		Then User should see the products that contain the exact search word "ribbed midi dress"
		And User inputs case sensitive capital letter search term like "TOTE" in the search bar
		Then User should see search results for "TOTE"
		And User stores the number of products displayed upon using capital letters
		And User inputs case sensitive small letter search term like "tote" in the search bar
		Then User should see search results for "tote"
		And User stores the number of products displayed upon using small letters
		And User compares the count and should see equal number of products being listed
		And User enters search item including stop words like "the tote bag" in the search bar
		Then User should see search results for "tote bag" ignoring the stop words "the"
		And User enters a combination of words and special characters like "close-fit" in the search bar
		Then User should see search results for "close-fit"
		And User enters numeric value like "23" in the search bar
		Then User should see search results for "23"
		And User enters a first synonym search item 'cap' in the search bar
		Then User should see search results for "cap"
		And User stores the number of products displayed upon using first synonym
		And User enters a second synonym search item 'hat' in the search bar
		Then User should see search results for "hat"
		And User stores the number of products displayed upon using second synonym
		And User compares the count and should see equal number of products being listed
		And User should close the browser
    
  Scenario: Perform a invalid search on Lululemon
		Given User opens the edge browser
		When User opens the Website url "https://shop.lululemon.com"
		And User enters mutiple valid search items "top pant" in the search bar
		Then User should see the "No search results for " searched item
		And User enters invalid search item "Bgg" in the search bar
		Then User should see search results as "No search results for"
		And User enters only special characters like "#&#_&"
		Then User should see the "No search results for " searched item
		And User enters combination of valid and invalid search terms like "Tote #&#_&"
		Then User should see search results for "tote" ignoring the invalid words "#&#_&"
		And User enters whitespace " " in the search bar
		Then User should see search results as "No search results for"
		And User enters a search item with extensive length of characters like "qwertqwertqwertqwertqwertqwertqwertqwertqwertqwer" in the search bar
		Then search bar should let the user enter all the characters "qwertqwertqwertqwertqwertqwertqwertqwertqwertqwer" as it has no character limit.
		And User enters search item in different language "Casquette" in the search bar
		Then User should see the "No search results for" searched item
		And User should close the browser
    
   Scenario: Perform a search and select suggestion on Lululemon
    Given User opens the edge browser
    When User opens the Website url "https://shop.lululemon.com"
    And User enters item for search suggestion "Hat" in the search bar
    Then User should see search suggestions containing "Hat" in the search bar
    And User enters a different item for search suggestion "Tote" in the search bar
    Then User should see search suggestions containing "Tote" but not "Hat" in the search bar
    And User enters a search suggestion item "mirror" that is not present on the website
    Then User should not see any search suggestions
    And User enters partial search item "Bag" in the search bar
    Then User should see search suggestions containing "Bag"
    And User selects the product "Fanny Bag" from the search suggestions
    Then User should see search results for "Fanny Bag"
    And User clicks on the search bar to see past search suggestions
    Then User should see the past search suggestions
    And User should close the browser
    
   Scenario: Perform a search pagination on Lululemon
    Given User opens the edge browser
    When User opens the Website url "https://shop.lululemon.com"
    And User enters search item "Bag" in the search bar
    Then User should see all the search results for "Bag"
    And User stores the initial results of the webpage as Initial Results
    And User navigates to load the next page of search results
    Then User should see the next set of search results
    And User should navigate to the end of the product list
    Then User should not be able to see the view more products button
    And User should close the browser

 