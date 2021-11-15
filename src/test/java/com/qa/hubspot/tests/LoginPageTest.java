package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is ::"+ title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifyForgorPasswordLinkTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	

}
