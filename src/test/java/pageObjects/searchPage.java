package pageObjects;

import java.util.ArrayList;
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
	
	@FindBy(xpath = "//section[@class = 'results-description']/p[@class ='results-title lll-text-body-1']")
	@CacheLookup
	WebElement smallshowResults;
	
	@FindBy(xpath = "//section[@class = 'results-description']/p[@class ='results-title lll-text-body-1']")
	@CacheLookup
	WebElement synonymoneshowResults;
	
	@FindBy(xpath = "//section[@class = 'results-description']/p[@class ='results-title lll-text-body-1']")
	@CacheLookup
	WebElement synonymtwoshowResults;
	
	
	
	
	public void searchItem(String itemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void exactValidSearchItem(String evsitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(evsitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void CapitalSearchItem(String CitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(CitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	public String getCapitalSearchItem() {
		String CapitalresultsText = showResults.getText();
		return CapitalresultsText;
    }
	
	public void SmallSearchItem(String SitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(SitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	public String getSmallSearchItem() {
		String SmallresultsText = smallshowResults.getText();
		return SmallresultsText;
    }
	
	public void StopWordItem(String StopitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(StopitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public List<WebElement> getProductNames() {
        return ldriver.findElements(By.xpath("//*[@id='product-list']//h3/a"));
    }

    public List<String> getProductNamesText() {
        List<WebElement> products = getProductNames();
        List<String> productNames = new ArrayList<>();
        for (WebElement product : products) {
            productNames.add(product.getText());
        }
        return productNames;
    }

    public boolean areProductsContaining(String Productkeyword) {
        List<String> productNames = getProductNamesText();
        for (String productName : productNames) {
            if (!productName.contains(Productkeyword)) {
                return false;
            }
        }
        return true;
    }
    
    public void ComboSpecialItem(String CSitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(CSitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
    
    public void NumericItem(String NitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(NitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
    
    public void synonymOneItem(String SoitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(SoitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
    
    public String getSynonymOneItem() {
		String SynonymOneText = synonymoneshowResults.getText();
		return SynonymOneText;
    }
    
    public void synonymTwoItem(String StitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(StitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
    public String getSynonymTwoItem() {
		String SynonymTwoText = synonymtwoshowResults.getText();
		return SynonymTwoText;
    }
    
	public void searchItemInvalid(String InvaliditemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(InvaliditemName);
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
