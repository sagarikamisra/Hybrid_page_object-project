package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



@Epic("Epic_200: Design  AccountsPage features....")
@Story("US_201:Designing the Accounts page with title,header,accounts sections and product result..")
public class AccountsPageTest extends BaseTest {
	
	
	@BeforeMethod
	public void accountsPageSetUp()
	{
		
		accountsPage = loginPage.doLogin(prop.getProperty("username"),"password");
	}
	
	@Description("Verify Accounts page title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void accountsPageTitleTest()
	{
	  String title = accountsPage.getAccountsPageTitle();
	  System.out.println("Accounts page title ::"+ title);
	  Assert.assertEquals(title,Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	
	@Description("Verify Accounts page header Test")
	@Severity(SeverityLevel.NORMAL)
	@Test (priority = 2)
	public void verifyAccountsPageHeaderTest()
	{
	  String header =accountsPage.getHeaderValue();
	  System.out.println("Accounts Page header is::"+ header);
	  Assert.assertEquals(header,Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	
	@Description("Verify Accounts page section count Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void verifyMyAccountSectionTest()
	{
		Assert.assertTrue(accountsPage.getAccountSectionsCount() == Constants.ACCOUNTS_SECTIONS);
	}

	
	@Description("Verify Accounts page Accountlist count Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyMyAccountSectionListTest()
	{
		Assert.assertEquals(accountsPage.getAccountSectionsList(),Constants.getAccountSectionsList());
	}
	
	
	@Description("Verify Accounts page search Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void searchTest()
	{
		Assert.assertTrue(accountsPage.doSearch("MacBook"));
	}
	
}
