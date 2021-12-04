package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;




@Epic("Epic_100: Define loginPage features....")
@Story("US_101:Define page class features with title, forgot pwd link, login fuctionality")
public class LoginPageTest extends BaseTest {
	
	@Description("Verify Login Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is ::"+ title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Description("Verify Login password link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void verifyForgorPasswordLinkTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Verify Login with username and password")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=3)
	public void loginTest()
	{
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	

}
