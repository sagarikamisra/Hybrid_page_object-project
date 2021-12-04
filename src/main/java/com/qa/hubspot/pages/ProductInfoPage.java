package com.qa.hubspot.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class ProductInfoPage extends BasePage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By productQuantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By productimages = By.cssSelector(".thumbnails li img");
	
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getProductPageTitle(String ProductName)
	{
		
		String productPageTitle = elementUtil.getPageTitle(ProductName,5);
		return productPageTitle;
		
	}
	
	public Map<String, String> getProductInformation()
	{
		Map<String,String> productInfoMap = new HashMap<>();
		
		 productInfoMap.put("name",elementUtil.doGetText(productNameHeader).trim());
			
		 List<WebElement>  productMetaDataList = elementUtil.getElements(productMetaData);
		 
		 for (WebElement e : productMetaDataList)
		 {
			 //Product Code: Product 18
			 productInfoMap.put(e.getText().split(":")[0].trim(),e.getText().split(":")[1].trim());
		}
		
		 
		  List<WebElement> productPriceList =  elementUtil.getElements(productPrice);
		  productInfoMap.put("price",productPriceList.get(0).getText().trim());
		  productInfoMap.put("ExTaxprice",productPriceList.get(1).getText().split(":")[1].trim()); 
		  
		  System.out.println("Product List::"+productInfoMap);
		  return productInfoMap;  
		    
		  
	}
	
	public void selectQuantity(String qty)
	{
		elementUtil.doSendKeys(productQuantity, qty);
	}
	
	public void addToCart()
	{
		elementUtil.doClick(addToCartButton);
	}
	
	public int getProductImage()
	{
		int imagesCount = elementUtil.getElements(productimages).size();
		System.out.println("Number of Images::"+imagesCount);
		return imagesCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
}