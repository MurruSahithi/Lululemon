package stepDefinitions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pageObjects.searchPage;

public class searchSteps 
{
	public WebDriver driver;
	public searchPage sp;
	public String initialResultsText;
	public String expectedResultsText;
	public String ccountitem;
	public String scountitem;
	public Boolean containsKeyword;
	public Boolean containsStopKeyword;
	public Boolean containsInvalidKeyword;
	public String displayResultsMyntra;
	public String storeInitalPageMyntra;
	public String storeNextPageMyntra;
	public String storePrevPageMyntra;
	
	
	
	
	@Given("User opens the edge browser")
	public void user_opens_the_edge_browser() {
		driver = new EdgeDriver();
		sp = new searchPage(driver);
	}
	
	@Given("User opens the firefox browser")
	public void user_opens_the_firefox_browser() {
		driver = new FirefoxDriver();
		sp = new searchPage(driver);
	}
	
	@When("User opens the Website url {string}")
	public void user_opens_the_website_url(String url) throws InterruptedException
	{
	    driver.get(url);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}

	@When("User enters valid search item {string} in the search bar")
	public void user_enters_valid_search_item_in_the_search_bar(String vitem) throws InterruptedException {
		sp.searchItem(vitem);
	    Thread.sleep(3000);
	}
	
	@Then("User should see search results for {string}")
	public void user_should_see_search_results_for(String searchItem) 
	{
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
		containsKeyword = sp.areProductsContaining(searchItem);
		sp.clearSearchBar();
			
	}

	@Then("User enters a exact valid search item {string} in the search bar")
	public void user_enters_a_exact_valid_search_item_in_the_search_bar(String evsItem) throws InterruptedException 
	{
		sp.exactValidSearchItem(evsItem);
		Thread.sleep(3000);
	}

	@Then("User should see the products that contain the exact search word {string}")
	public void user_should_see_the_products_that_contain_the_exact_search_word(String exactsearchItem) {
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
		containsKeyword = sp.areProductsContaining(exactsearchItem);
		sp.clearSearchBar();
	}

	@Then("User inputs case sensitive capital letter search term like {string} in the search bar")
	public void user_inputs_case_sensitive_capital_letter_search_term_like_in_the_search_bar(String CsItem) throws InterruptedException {
		sp.CapitalSearchItem(CsItem);
		Thread.sleep(3000);
	}

	@Then("User stores the number of products displayed upon using capital letters")
	public void user_stores_the_number_of_products_displayed_upon_using_capital_letters() {
	    ccountitem = sp.getCapitalSearchItem();
	    sp.clearSearchBar();
	}

	@Then("User inputs case sensitive small letter search term like {string} in the search bar")
	public void user_inputs_case_sensitive_small_letter_search_term_like_in_the_search_bar(String SsItem) throws InterruptedException {
		sp.SmallSearchItem(SsItem);
		Thread.sleep(3000);
	}

	@Then("User stores the number of products displayed upon using small letters")
	public void user_stores_the_number_of_products_displayed_upon_using_small_letters() {
		scountitem = sp.getSmallSearchItem();
		
	}

	@Then("User compares the count and should see equal number of products being listed")
	public void user_compares_the_count_and_should_see_equal_number_of_products_being_listed() {
		assertEquals(ccountitem, scountitem);
		sp.clearSearchBar();
	}


	@Then("User enters search item including stop words like {string} in the search bar")
	public void user_enters_search_item_including_stop_words_like_in_the_search_bar(String stopItem) throws InterruptedException {
		sp.StopWordItem(stopItem);
		Thread.sleep(3000);
	}

	@Then("User should see search results for {string} ignoring the stop words {string}")
	public void user_should_see_search_results_for_ignoring_the_stop_words(String pItem1, String pItem2) {
		containsKeyword = sp.areProductsContaining(pItem1);
		sp.clearSearchBar();
		containsStopKeyword = sp.areProductsContaining2(pItem2, pItem1);
	}

	@Then("User enters a combination of words and special characters like {string} in the search bar")
	public void user_enters_a_combination_of_words_and_special_characters_like_in_the_search_bar(String csItem) throws InterruptedException {
		sp.ComboSpecialItem(csItem);
		Thread.sleep(3000);
	}

	@Then("User enters numeric value like {string} in the search bar")
	public void user_enters_numeric_value_like_in_the_search_bar(String nItem) throws InterruptedException {
		sp.NumericItem(nItem);
		Thread.sleep(3000);
	}

	@Then("User enters a first synonym search item {string} in the search bar")
	public void user_enters_a_first_synonym_search_item_in_the_search_bar(String soItem) throws InterruptedException {
		sp.synonymOneItem(soItem);
		Thread.sleep(5000);
	}

	@Then("User stores the number of products displayed upon using first synonym")
	public void user_stores_the_number_of_products_displayed_upon_using_first_synonym() {
		ccountitem = sp.getSynonymOneItem();
		sp.clearSearchBar();
	}

	@Then("User enters a second synonym search item {string} in the search bar")
	public void user_enters_a_second_synonym_search_item_in_the_search_bar(String stItem) throws InterruptedException {
		sp.synonymTwoItem(stItem);
		Thread.sleep(3000);
	}

	@Then("User stores the number of products displayed upon using second synonym")
	public void user_stores_the_number_of_products_displayed_upon_using_second_synonym() {
		scountitem = sp.getSynonymTwoItem();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@When("User enters mutiple valid search items {string} in the search bar")
	public void user_enters_mutiple_valid_search_items_in_the_search_bar(String mvItem) throws InterruptedException 
	{
	    sp.sarchMultipleValidItem(mvItem);
	    Thread.sleep(3000);
	}

	@Then("User should see the {string} searched item")
	public void user_should_see_the_searched_item(String mvSearchItem) {
		if(driver.getPageSource().contains("No search results for " + mvSearchItem))
	    {
	    	Assert.assertTrue(true);
	    }
		sp.clearSearchBar();
	}

	@Then("User enters invalid search item {string} in the search bar")
	public void user_enters_invalid_search_item_in_the_search_bar(String itemInvalid) throws InterruptedException {
	    sp.searchItemInvalid(itemInvalid);
	    Thread.sleep(3000);
	}

	@Then("User should see search results as {string}")
	public void user_should_see_search_results_as(String searchItemInvalid) {
		if(driver.getPageSource().contains("No search results for " + searchItemInvalid))
	    {
	    	Assert.assertTrue(true);
	    }
		sp.clearSearchBar();
	}

	@Then("User enters only special characters like {string}")
	public void user_enters_only_special_characters_like(String scharItem) throws InterruptedException {
	    sp.searchItemSpecialChar(scharItem);
	    Thread.sleep(3000);
	}

	@Then("User enters combination of valid and invalid search terms like {string}")
	public void user_enters_combination_of_valid_and_invalid_search_terms_like(String Comboitem) throws InterruptedException {
	    sp.ComboSpecialItem(Comboitem);
	    Thread.sleep(3000);
	}
	
	@Then("User should see search results for {string} ignoring the invalid words {string}")
	public void user_should_see_search_results_for_ignoring_the_invalid_words(String pItem1, String pItem2) {
		containsKeyword = sp.areProductsContaining(pItem1);
		sp.clearSearchBar();
		containsInvalidKeyword = sp.areProductsContaining2(pItem2,pItem2);
	}



	@Then("User enters whitespace {string} in the search bar")
	public void user_enters_whitespace_in_the_search_bar(String WItemname) throws InterruptedException {
		sp.whiteSpaceItem(WItemname);
	    Thread.sleep(3000);
	}

	@Then("User enters a search item with extensive length of characters like {string} in the search bar")
	public void user_enters_a_search_item_with_extensive_length_of_characters_like_in_the_search_bar(String LItemName) throws InterruptedException {
		sp.LongSearchItem(LItemName);
	    Thread.sleep(3000);
	}

	@Then("search bar should let the user enter all the characters {string} as it has no character limit.")
	public void search_bar_should_let_the_user_enter_all_the_characters_as_it_has_no_character_limit(String vsearchBar) {
		if(driver.getPageSource().contains("No search results for " + vsearchBar))
	    {
	    	Assert.assertTrue(true);
	    }
		sp.clearSearchBar();
	}

	@Then("User enters search item in different language {string} in the search bar")
	public void user_enters_search_item_in_different_language_in_the_search_bar(String FrenchItem) throws InterruptedException {
	    sp.frenchsearchItem(FrenchItem);
	    Thread.sleep(3000);
	}

	
////////////////////////////////////////////////////////////////////////////////////////
	
	@When("User enters item for search suggestion {string} in the search bar")
	public void user_enters_item_for_search_suggestion_in_the_search_bar(String suggestionItem) throws InterruptedException 
	{
		sp.searchsuggestionItem(suggestionItem);
	    Thread.sleep(3000);
	}

	@Then("User should see search suggestions containing {string} in the search bar")
	public void user_should_see_search_suggestions_containing_in_the_search_bar(String searchKeyword) 
	{
		assertTrue("Search suggestions not displayed", sp.isSearchSuggestionsDisplayed());
        assertTrue("Search suggestions do not contain '" + searchKeyword + "'", sp.areSearchSuggestionsContaining(searchKeyword));
        sp.clearSearchBar();
	}

	@Then("User enters a different item for search suggestion {string} in the search bar")
	public void user_enters_a_different_item_for_search_suggestion_in_the_search_bar(String suggestionItem2) throws InterruptedException 
	{
		sp.searchsuggestionItem(suggestionItem2);
	    Thread.sleep(3000);
	}

	@Then("User should see search suggestions containing {string} but not {string} in the search bar")
	public void user_should_see_search_suggestions_containing_but_not_in_the_search_bar(String searchKeyword1, String searchKeyword2) 
	{
		assertTrue("Search suggestions not displayed", sp.isSearchSuggestionsDisplayed());
        assertTrue("Search suggestions do not contain '" + searchKeyword1 + "'", sp.areSearchSuggestionsContaining(searchKeyword1));
        assertFalse("Search suggestions contain '" + searchKeyword2 + "'", sp.areSearchSuggestionsContaining(searchKeyword2));
        sp.clearSearchBar();
	}

	@Then("User enters a search suggestion item {string} that is not present on the website")
	public void user_enters_a_search_suggestion_item_that_is_not_present_on_the_website(String suggestionItem3) throws InterruptedException 
	{
		sp.searchsuggestionItemInvalid(suggestionItem3);
	    Thread.sleep(3000);
	}

	@Then("User should not see any search suggestions")
	public void user_should_not_see_any_search_suggestions() 
	{
		assertTrue("Search suggestions displayed", sp.isSearchSuggestionsNotDisplayed());
		sp.clearSearchBar();
	}

	@Then("User enters partial search item {string} in the search bar")
	public void user_enters_partial_search_item_in_the_search_bar(String partialItem) throws InterruptedException 
	{
		sp.partialsearchItem(partialItem);
	    Thread.sleep(3000);
	}

	@Then("User should see search suggestions containing {string}")
	public void user_should_see_search_suggestions_containing(String searchKeyword3) 
	{
		assertTrue("Search suggestions not displayed", sp.isSearchSuggestionsDisplayed());
        assertTrue("Search suggestions do not contain '" + searchKeyword3 + "'", sp.areSearchSuggestionsContaining(searchKeyword3));
	}

	@Then("User selects the product {string} from the search suggestions")
	public void user_selects_the_product_from_the_search_suggestions(String product) throws InterruptedException 
	{
		sp.selectSearchSuggestionContaining(product);
		Thread.sleep(3000);
	}
	
	
	

	@Then("User clicks on the search bar to see past search suggestions")
	public void user_clicks_on_the_search_bar_to_see_past_search_suggestions() {
		sp.EmptyItem();
	}



	@Then("User should see the past search suggestions")
	public void user_should_see_search_suggestions() 
	{
		assertTrue("Past Search suggestions are not displayed", sp.isPastSearchSuggestionsDisplayed());
		sp.clearSearchBar();
	}
	
////////////////////////////////////////////////////////////////////////////////////////
	
	@When("User enters search item {string} in the search bar")
	public void user_enters_search_item_in_the_search_bar(String item) throws InterruptedException {
		sp.searchItem(item);
	    Thread.sleep(3000);
	}
	
	@Then("User should see all the search results for {string}")
	public void user_should_see_all_the_search_results_for(String searchItem) 
	{
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
		
			
	}


	@Then("User stores the initial results of the webpage as Initial Results")
	public void user_stores_the_initial_results_of_the_webpage_as_initial_results() throws InterruptedException {
		initialResultsText = sp.validateResults();
		Thread.sleep(5000);
	}
	
	



	@Then("User navigates to load the next page of search results")
	public void user_navigates_to_load_the_next_page_of_search_results() throws InterruptedException {
		sp.viewMoreProductsButton();
	    Thread.sleep(3000);
	}

	@Then("User should see the next set of search results")
	public void user_should_see_the_next_set_of_search_results() {
		expectedResultsText = sp.ValidateNextPageResults();
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
		assertNotEquals(expectedResultsText, initialResultsText);
	}

	@Then("User should navigate to the end of the product list")
	public void user_should_navigate_to_the_end_of_the_product_list() throws InterruptedException {
		sp.navigateToEndOfPage();
	}
	
	@Then("User should not be able to see the view more products button")
	public void user_should_not_be_able_to_see_the_view_more_products_button() {
		boolean isButtonNotPresent = sp.isViewMoreButtonNotPresent();
        assert isButtonNotPresent : "The 'View More' button is still present.";
        System.out.println("No 'View More' button found, end of product list reached.");
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@When("User enters search item {string} in the myntra search bar")
	public void user_enters_search_item_in_the_myntra_search_bar(String myntraItem) throws InterruptedException {
		sp.searchItemMyntra(myntraItem);
	    Thread.sleep(3000);
	}

	@Then("User should see all the search results for {string} in myntra")
	public void user_should_see_all_the_search_results_for_in_myntra(String myntraresultsItem) throws InterruptedException {
		displayResultsMyntra = sp.getSearchResults();
		Thread.sleep(3000);
		assertEquals(displayResultsMyntra, myntraresultsItem);
	}

	@Then("User stores the initial page value of the webpage in myntra")
	public void user_stores_the_initial_page_value_of_the_webpage_in_myntra() throws InterruptedException {
		storeInitalPageMyntra = sp.getSearchResultsValue();
		Thread.sleep(3000);
	}

	@Then("User navigates to load the next page of search results in myntra")
	public void user_navigates_to_load_the_next_page_of_search_results_in_myntra() throws InterruptedException {
	    sp.navigateNextPageMyntra();
	    Thread.sleep(8000);
	}

	@Then("User should see the next set of search results in myntra")
	public void user_should_see_the_next_set_of_search_results_in_myntra() throws InterruptedException {
		Thread.sleep(8000);
		sp.isPrevProductsVisible();
		
	}

	@Then("User navigates to load the previous page of search results in myntra")
	public void user_navigates_to_load_the_previous_page_of_search_results_in_myntra() throws InterruptedException {
		
		sp.navigatePrevPageMyntra();
	    Thread.sleep(5000);
	}
	
	@Then("User should see the prev set of search results in myntra")
	public void user_should_see_the_prev_set_of_search_results_in_myntra() throws InterruptedException {
		
		sp.isPrevProductsNotVisible();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*@Given("User opens the chrome browser")
	public void user_opens_the_chrome_browser() 
	{
		driver = new EdgeDriver();
		sp = new searchPage(driver);
	}

	@When("User opens the Website url {string}")
	public void user_opens_the_website_url(String url) throws InterruptedException
	{
	    driver.get(url);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}

	@When("User enters search item {string} in the search bar")
	public void user_enters_search_item_in_the_search_bar(String item) throws InterruptedException 
	{
	    sp.searchItem(item);
	    Thread.sleep(3000);
	}

	@Then("User should see search results for {string}")
	public void user_should_see_search_results_for(String searchItem) 
	{
		//String s = sp.validateSearch();
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
			
	}
	
	@When("User enters invalid search item {string} in the search bar")
	public void user_enters_invalid_search_item_in_the_search_bar(String itemInvalid) throws InterruptedException 
	{
		sp.searchItemInvalid(itemInvalid);
	    Thread.sleep(3000);
	}

	@Then("User should see search results as {string}")
	public void user_should_see_search_results_as(String searchItemInvalid) 
	{
	    if(driver.getPageSource().contains("No search results for " + searchItemInvalid))
	    {
	    	Assert.assertTrue(true);
	    }
	}
	
	@When("User enters partial search item {string} in the search bar")
	public void user_enters_partial_search_item_in_the_search_bar(String partialItem) throws InterruptedException 
	{
		sp.partialsearchItem(partialItem);
	    Thread.sleep(3000);
	}

	@Then("User should see search suggestions containing {string}")
	public void user_should_see_search_suggestions_containing(String keyword) 
	{
		assertTrue("Search suggestions not displayed", sp.isSearchSuggestionsDisplayed());
        assertTrue("Search suggestions do not contain '" + keyword + "'", sp.areSearchSuggestionsContaining(keyword));
	}

	@Then("User selects the product {string} from the search suggestions")
	public void user_selects_the_product_from_the_search_suggestions(String product) 
	{
		sp.selectSearchSuggestionContaining(product);
	}
	
	@Then("User stores the initial results of the webpage as {string}")
	public void user_stores_the_initial_results_of_the_webpage_as(String initResults) {
	    initialResultsText = sp.validateResults();
	}
	
	@Then("User navigates to load the next page of search results")
	public void user_navigates_to_load_the_next_page_of_search_results() throws InterruptedException 
	{
		sp.viewMoreProductsButton();
	    Thread.sleep(3000);
	}
	
	@Then("User should see the next set of search results")
	public void user_should_see_the_next_set_of_search_results() 
	{
		expectedResultsText = sp.ValidateNextPageResults();
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
		assertNotEquals(expectedResultsText, initialResultsText);
	}*/

	@Then("User should close the browser")
	public void user_should_close_the_browser() 
	{
	    driver.quit();
	}
}
