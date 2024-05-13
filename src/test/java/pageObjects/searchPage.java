package pageObjects;

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
	
	@FindBy(xpath = "//input[@data-testid='nav-mobile-search']")
	@CacheLookup
	WebElement txtSearchBar;
	
	@FindBy(xpath = "//input[@Title = 'Go']")
	@CacheLookup
	WebElement btnGo;
	
	public void searchItem(String itemName)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(itemName);
	}
	
	public void clickGo()
	{
		btnGo.click();
	}
	
	
}
