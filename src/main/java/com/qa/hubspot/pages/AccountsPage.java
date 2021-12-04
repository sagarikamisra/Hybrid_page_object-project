package com.qa.hubspot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;
/**
 * 
 * @author sagar
 *
 */
public class AccountsPage extends BasePage {

		
	private WebDriver driver;	
	private ElementUtil elementUtil;
	
//1. By locators
	
	private By header= By.cssSelector("div#logo a ");
	private By accountSectionHeader =By.cssSelector("#content > h2:nth-child(1)");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchText =By.cssSelector("#search > input");
	private By searchItemResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");
	
//2.Constructor of Account Page	
	
	public AccountsPage(WebDriver driver) {
	
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}

	
//3.Page Actions:Features or behaviour of the page in forms of methods
	
	
	@Step("Getting Accounts page title......")
	public String getAccountsPageTitle()
	{
		return elementUtil.getPageTitle(Constants.ACCOUNTS_PAGE_TITLE,10);
	}
	
	
	@Step("Getting Acoounts  page header value.....")
	public String getHeaderValue()
	{
		if(  elementUtil.doIsDisplay(header))
		{
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	
	@Step("Getting total number of Acoounts section.........")
	public int getAccountSectionsCount()
	{
	  //return driver.findElements(accountSectionHeader).size();
		return elementUtil.getElements(accountSectionHeader).size();
	}
	
	
	@Step("Getting Accounts page  account list......")
	public List<String> getAccountSectionsList()
	{
		List <String> accountList =new ArrayList<>();
		List<WebElement> accountSectionList = elementUtil.getElements(accountSectionHeader);
		
		for(WebElement e: accountSectionList) 
		{
			
			accountList.add(e.getText());
			System.out.println(e.getText());
			accountList.add(e.getText());
		}
		return accountList;
	}
	
	
	@Step("Searching a product name:{0}")
	public boolean doSearch( String productName)
	{
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
					
		
		if(elementUtil.getElements(searchItemResult).size()>0)
		{
			return true;
		}
		
		return false;
	}	
	
	@Step("Selecting a product with namefrom the result section :{0}")
	public ProductInfoPage selectProductFromResults(String productname)
	{
		List<WebElement> productList = elementUtil.getElements(resultItems);
		System.out.println("Total number of items:"+productList.size());
		
		for (WebElement e : productList) {
			
			if(e.getText().equals(productname))
			{
				e.click();
				break;
			}
			
		}
		
		return new ProductInfoPage(driver);
	}
}	