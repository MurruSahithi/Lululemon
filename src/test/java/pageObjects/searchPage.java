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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



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
	
	//@FindBy(xpath = "//button[contains(text(), 'View More Products')]")
	@FindBy(xpath = "//div[@class='OneLinkTx pagination_pagination__vr5cn']/button")
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
	
	@FindBy(xpath = "//*[@id=\"app\"]/header/nav/div[3]/div[3]/ul")
	@CacheLookup
	WebElement sidespace;
	
	
	@FindBy(xpath = "//div[@class ='mega-nav_navWrapperDesktop__2bY3W']/div/ul/div/div/div/ul/li")
	@CacheLookup
	WebElement pastSuggestions;
	
	By viewMoreButtonLocator = By.xpath("//div[@class='OneLinkTx pagination_pagination__vr5cn']/button");
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//div/input[@class ='desktop-searchBar']")
	@CacheLookup
	WebElement txtMyntraSearchBar;
	
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
	static
	WebElement PrevProducts;
	
	public void clearSearchBarMyntra()
	{
		txtMyntraSearchBar.sendKeys(Keys.CONTROL + "a");
		txtMyntraSearchBar.sendKeys(Keys.DELETE);
	}
	
	public void searchItemMyntra(String itemName)
	{
		
		txtMyntraSearchBar.sendKeys(itemName);
		txtMyntraSearchBar.sendKeys(Keys.ENTER);
	}
	
	public String getSearchResults() {
		String SearchresultsText = showProducts.getText();
		return SearchresultsText;
    }
	
	public String getSearchResultsValue() {
		String SearchPageValueText = showPageValue.getText();
		return SearchPageValueText;
    }
	
	public void navigateNextPageMyntra()
	{
		NextProducts.sendKeys(Keys.ENTER);
	}
	public void navigatePrevPageMyntra()
	{
		PrevProducts.sendKeys(Keys.ENTER);
	}
	public boolean isPrevProductsVisible() {
        try {
            return searchPage.PrevProducts.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
	public boolean isPrevProductsNotVisible() {
        try {
            return !searchPage.PrevProducts.isDisplayed();
        } catch (Exception e) {
            return true; // If an exception is caught, it means the element is not visible
        }
    }
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
    
    public boolean areProductsContaining2(String Productkeyword1, String Productkeyword2) {
        List<String> productNames = getProductNamesText();
        for (String productName : productNames) {
            if (!productName.contains(Productkeyword2 + Productkeyword1)) {
                return true;
            }
        }
        return false;
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
    
    
    public void  sarchMultipleValidItem(String MultiItemName)
    {
    	txtSearchBar.clear();
		txtSearchBar.sendKeys(MultiItemName);
		txtSearchBar.sendKeys(Keys.ENTER);
    }
    
	public void searchItemInvalid(String InvaliditemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(InvaliditemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void searchItemSpecialChar(String SpecialCharitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(SpecialCharitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void searchItemCombo(String ComboitemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(ComboitemName);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	
	
	public void whiteSpaceItem(String WhiteItem)
	{
		
		txtSearchBar.clear();
		txtSearchBar.sendKeys(WhiteItem);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
	
	public void LongSearchItem(String LongItem)
	{
		
		txtSearchBar.clear();
		txtSearchBar.sendKeys(LongItem);
	}
	
    
    public void frenchsearchItem(String itemNameFrench)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemNameFrench);
		txtSearchBar.sendKeys(Keys.ENTER);
	}
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void searchsuggestionItem(String ssItem)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(ssItem);
	}
    
    public void searchsuggestionItemInvalid(String ssItemInvalid)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(ssItemInvalid);
	}
    
    public void EmptyItem()
    {
    	txtSearchBar.sendKeys(Keys.ENTER);
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	public boolean isSearchSuggestionsNotDisplayed() {
		return ldriver.findElements(By.xpath("//div[@class='search_suggestions__391m1']/ul/li")).size() < 1;
	}
	
	public boolean isPastSearchSuggestionsDisplayed()
	{
		return ldriver.findElements(By.xpath("//div[@class ='mega-nav_navWrapperDesktop__2bY3W']/div/ul/div/div/div/ul/li")).size() > 0;
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
    
    public void navigateToEndOfPage() throws InterruptedException
    {
    	while (true) {
            List<WebElement> viewMoreButtons = ldriver.findElements(viewMoreButtonLocator);
            if (viewMoreButtons.isEmpty()) {
                System.out.println("End of products. No 'View More' button found.");
                break;
            }

            WebElement viewMoreButton = viewMoreButtons.get(0);
            viewMoreButton.click();

            Thread.sleep(3000);  // Wait for 3 seconds to allow new products to load
        }
    }
	
    public boolean isViewMoreButtonNotPresent() {
        List<WebElement> viewMoreButtons = ldriver.findElements(viewMoreButtonLocator);
        return viewMoreButtons.isEmpty();
    }
	
	
}
