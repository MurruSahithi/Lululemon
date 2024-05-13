package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;

import pageObjects.searchPage;

public class searchSteps 
{
	public WebDriver driver;
	public searchPage sp;
	@Given("User opens the chrome browser")
	public void user_opens_the_chrome_browser() 
	{
		
		driver = new EdgeDriver();
		sp = new searchPage(driver);
	}

	@When("User opens the Amazon url {string}")
	public void user_opens_the_amazon_url(String url)
	{
	    driver.get(url);
	}

	@When("User enters search item {string} in the search bar")
	public void user_enters_search_item_in_the_search_bar(String item) 
	{
	    sp.searchItem(item);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() 
	{
	    sp.clickGo();
	}

	@Then("User should see search results for {string}")
	public void user_should_see_search_results_for(String searchTerm) 
	{
		boolean isSearchTermPresent = driver.getPageSource().contains("results for " + searchTerm);
        if (!isSearchTermPresent) {
            Assert.fail("Search results do not contain the search term: " + searchTerm);
        }

	}

	@Then("User should close the browser")
	public void user_should_close_the_browser() 
	{
	    driver.quit();
	}
}
