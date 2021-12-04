package com.qa.hubspot.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.AccountsPage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductInfoPage;
import com.qa.hubspot.pages.Registerpage;

public class BaseTest  {
	
	public BasePage basePage;
	public Properties prop;
	public Registerpage registerPage;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage productInfoPage;
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
		 basePage = new BasePage();
		 prop =basePage.init_prop();
		 String browser = prop.getProperty("browser");
		 driver= basePage.init_browser(browser);
		 loginPage= new LoginPage(driver);
		 driver.get(prop.getProperty("url"));
		 	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}