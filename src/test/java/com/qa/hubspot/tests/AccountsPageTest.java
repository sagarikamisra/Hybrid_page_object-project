package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	
	@BeforeMethod
	public void accountsPageSetUp()
	{
		
		accountsPage = loginPage.doLogin(prop.getProperty("username"),"password");
	}
	
	@Test(priority = 1)
	public void accountsPageTitleTest()
	{
	  String title = accountsPage.getAccountsPageTitle();
	  System.out.println("Accounts page title ::"+ title);
	  Assert.assertEquals(title,Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	
	@Test (priority = 2)
	public void verifyAccountsPageHeaderTest()
	{
	  String header =accountsPage.getHeaderValue();
	  System.out.println("Accounts Page header is::"+ header);
	  Assert.assertEquals(header,Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyMyAccountSectionTest()
	{
		Assert.assertTrue(accountsPage.getAccountSectionsCount() == Constants.ACCOUNTS_SECTIONS);
	}

	@Test(priority = 4)
	public void verifyMyAccountSectionListTest()
	{
		Assert.assertEquals(accountsPage.getAccountSectionsList(),Constants.getAccountSectionsList());
	}
	
	@Test(priority = 5)
	public void searchTest()
	{
		Assert.assertTrue(accountsPage.doSearch("MacBook"));
	}
	
}
