package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class Registerpage  extends BasePage{
	
	ElementUtil elementUtil;
	
	private By firstname=By.id("input-firstname");
	private By lastname=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	
	private By subscribeYes=By.xpath("//label[@class='radio-inline'][position()=1]");
	private By subscribeNo=By.xpath("//label[@class='radio-inline'][position()=2]");
	
	private By agreeCheckBox= By.xpath("//input[@type='checkbox']");
	private By continueButton= By.xpath("//input[@type='submit' ]");
	
	private By accountSuccessMessage = By.cssSelector("#content h1");
	
	private By logOutLink = By.linkText("Logout");
	private By registerLink= By.xpath("//a[@class='list-group-item'][2]");
	
	public Registerpage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}
	
	
	public boolean accountRegistration(String firstname, String lastname,String email,
							String telephone,String password,String subscribe)
	{
		
		
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone,telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);	
		
		if(subscribe.equals(subscribeYes))
		{
			elementUtil.doClick(subscribeYes);
		}
		else
		{
			elementUtil.doClick(subscribeNo);
		}
		
		
		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(continueButton);
		
		String text = elementUtil.doGetText(accountSuccessMessage);
		if(text.contains(Constants.ACCOUNTS_SUCCESS_MESSAGE))
		{
			elementUtil.doClick(logOutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
