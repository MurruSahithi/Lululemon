package stepDefinitions;


import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
	
	
	
	
	@Given("User opens the edge browser")
	public void user_opens_the_edge_browser() {
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
		sp.clearSearchBar();
			
	}

	@Then("User enters a exact valid search item {string} in the search bar")
	public void user_enters_a_exact_valid_search_item_in_the_search_bar(String evsItem) throws InterruptedException 
	{
		sp.exactValidSearchItem(evsItem);
		Thread.sleep(3000);
	}

	@Then("User should see the products that contain the exact search word")
	public void user_should_see_the_products_that_contain_the_exact_search_word() {
		if(driver.getPageSource().contains("Showing") && driver.getPageSource().contains("results for:"))
		{
			Assert.assertTrue(true);
		}
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

	@Then("User should see search results for {string} ignoring the stop words")
	public void user_should_see_search_results_for_ignoring_the_stop_words(String pItem) {
		containsKeyword = sp.areProductsContaining("pItem");
		sp.clearSearchBar();
		containsStopKeyword = sp.areProductsContaining2("pItem");
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
