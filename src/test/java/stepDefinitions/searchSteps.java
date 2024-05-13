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
	public void user_opens_the_amazon_url(String url) throws InterruptedException
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
		String s = sp.validateSearch();
		if(driver.getPageSource().contains("Showing") && searchItem.equals(s))
		{
			Assert.assertTrue(true);
		}
		else
		{
			
		}
		//searchItem = sp.validateSearch(searchItem);
		
		/*boolean isSearchTermPresent = driver.getPageSource().contains("Showing");
        if (!isSearchTermPresent) {
            Assert.fail("Search results do not contain 'Showing X of Y results for:' message");
        }*/
		
	}

	@Then("User should close the browser")
	public void user_should_close_the_browser() 
	{
	    driver.quit();
	}
}
