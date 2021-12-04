package com.qa.hubspot.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	//By locator OR(Object Repository)
	
	private By emailID=By.id("input-email");
	private By passworrd =By.id("input-password");
	private By loginButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	private By registerLink= By.xpath("//a[@class='list-group-item'][2]");
	
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}
	// page actions:features (Beahaviour of the page) of in the forms of methods:
	
	
	@Step("Getting login page title......")
	public  String getLoginPageTitle()
	{
		
		return elementUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE,10);
	}
	
	
	@Step("Checking Forgot password link is present or not.......")
	public boolean isForgotPwdLinkExist()
	{
		return elementUtil.doIsDisplay(forgotPwdLink);
		
	}	
	
	
	@Step("Long in with username:{0} and password:{1}")
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Login with :"+un + "and" + pwd);
		//driver.findElement(emailID).sendKeys(un);
		//driver.findElement(passworrd).sendKeys(pwd);
		//driver.findElement(loginButton).click();
		
		elementUtil.doSendKeys(emailID, un);
		elementUtil.doSendKeys(passworrd, pwd);
		elementUtil.doClick(loginButton);
		
		
		return new AccountsPage(driver);
		
	}
	
	
	@Step("Navigating to register page........")
	public Registerpage navigateToRegisterPage()
	{
		elementUtil.doClick(registerLink);
		return new Registerpage(driver);
	}
	
	
}