
package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author sagarika
 *
 */
public class BasePage {
	
	
	public WebDriver driver;
	public static Properties prop;
	public static String highlight;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
/**
 * 	This method is used to initialize the browser on the basis of given browser
 * @param browser
 * @return This return webdrive driver
 */
	
	public WebDriver init_browser(String browser)
	{
		System.out.println("Browser value is"+ browser);
		
		highlight=prop.getProperty("hightlight");
		optionsManager= new OptionsManager(prop);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			
		}else if(browser.equalsIgnoreCase("safari")) {
			
			//driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
			
		}else {
			System.out.println("Please pass the correct browser value"+ browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, null);
		return getDriver();
	}

/**
 * This method is used to load the properties from config.properties
 * 	
 * @return This return Properties prop reference
 */
	public  Properties init_prop() {
		
		
			prop=new Properties();
				
		try {
			FileInputStream ip =new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	/**
	 * 
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}	
	
	
/**
 * This method is used to take screenshot
 * It will return path of the screenshot	
 * @return 
 */
	public String getScreenshot()
	{
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
		
		File src =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src,destination );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
		return path;
	}

}