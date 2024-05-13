package stepDefinitions;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
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
	@Given("User opens the chrome browser")
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
	}

	@Then("User should close the browser")
	public void user_should_close_the_browser() 
	{
	    driver.quit();
	}
}
