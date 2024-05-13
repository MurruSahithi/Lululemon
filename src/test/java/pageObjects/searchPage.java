package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage 
{
	public WebDriver ldriver;
	public searchPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@data-testid='nav-desktop-search']")
	@CacheLookup
	WebElement txtSearchBar;
	
	@FindBy(xpath = "//button[contains(text(), 'View More Products')]")
	@CacheLookup
	WebElement btnMoreProducts;
	
	@FindBy(xpath = "//section[@class = 'results-description']/p[@class ='results-title lll-text-body-1']")
	@CacheLookup
	WebElement showResults;
	
	
	
	public void searchItem(String itemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void searchItemInvalid(String itemNameInvalid)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemNameInvalid);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void partialsearchItem(String itemNamePartial)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemNamePartial);
	}
	
	public void viewMoreProductsButton()
	{
		btnMoreProducts.sendKeys(Keys.ENTER);
	}
	
	public String validateResults()
	{
		String resultsText = showResults.getText();
		return resultsText;
	}
	
	public String ValidateNextPageResults()
	{
		String resultsTextNext = showResults.getText();
		return resultsTextNext;
	}
	/*public String validateSearch()
	{
		String results = resultsValidate.getText();
		return results;
	}*/
	
	public boolean isSearchSuggestionsDisplayed() {
        return ldriver.findElements(By.xpath("//div[@class='search_suggestions__391m1']/ul/li")).size() > 0;
    }

    public List<WebElement> getSearchSuggestions() {
        return ldriver.findElements(By.xpath("//div[@class='search_suggestions__391m1']/ul/li/a[@class='anchor_anchor__1pPYT anchor_underline__3Sy04']"));
    }
    
    public boolean areSearchSuggestionsContaining(String keyword) {
        List<WebElement> suggestions = getSearchSuggestions();
        for (WebElement suggestion : suggestions) {
            if (!suggestion.getText().contains(keyword)) {
                return false;
            }
        }
        return true;
    }
    
    public void selectSearchSuggestionContaining(String keyword) {
        List<WebElement> suggestions = getSearchSuggestions();
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().contains(keyword)) {
                suggestion.click();
                return;
            }
        }
        throw new IllegalArgumentException("No suggestion containing '" + keyword + "' found");
    }
    
    
	
	
	
}
