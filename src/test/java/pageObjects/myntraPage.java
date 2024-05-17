package pageObjects;





import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myntraPage {
public WebDriver ldriver;
	
	public myntraPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div/input[@class ='desktop-searchBar']")
	@CacheLookup
	WebElement txtSearchBar;
	
	@FindBy(xpath = "//div/h1[@class ='title-title']")
	@CacheLookup
	WebElement showProducts;
	
	@FindBy(xpath = "//div/ul[@class='pagination-container']/li[@class='pagination-paginationMeta']")
	@CacheLookup
	WebElement showPageValue;
	
	@FindBy(xpath = "//div/ul[@class='pagination-container']/li[@class='pagination-next']/a")
	@CacheLookup
	WebElement NextProducts;
	
	@FindBy(xpath = "//div/ul[@class='pagination-container']/li[@class='pagination-prev']/a")
	@CacheLookup
	WebElement PreviousProducts;
	
	
	public void clearSearchBar()
	{
		txtSearchBar.sendKeys(Keys.CONTROL + "a");
		txtSearchBar.sendKeys(Keys.DELETE);
	}
	
	public void searchItem(String itemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public String getSearchResults() {
		String SearchresultsText = showProducts.getText();
		return SearchresultsText;
    }
	
	public String getSearchResultsCount() {
		String SearchPageValueText = showPageValue.getText();
		return SearchPageValueText;
    }
}
