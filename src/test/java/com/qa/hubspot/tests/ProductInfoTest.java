package com.qa.hubspot.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ProductInfoPage;
import com.qa.hubspot.utils.ElementUtil;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void productInfoSetUp()
	{
		accountsPage = loginPage.doLogin(prop.getProperty("username"),"password");
	}

	@Test(priority = 2)
	public void productInfoPageTitleTest_iMac()
	{
		accountsPage.doSearch("iMac");
		productInfoPage = accountsPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductPageTitle("iMac"),"iMac");
		
	}
	
	
	@Test(enabled = false)
	public void verifyProductInfoTest_MacBook()
	{
		String productname ="MacBook Pro";
		
		Assert.assertTrue(accountsPage.doSearch(productname));
		
		productInfoPage=accountsPage.selectProductFromResults("MacBook Pro");
		
		Assert.assertTrue(productInfoPage.getProductImage()==4);
		
		Map<String,String> productInfoMap= productInfoPage.getProductInformation();
			
		System.out.println(productInfoMap);
		//Brand=Apple, Availability=Out Of Stock, ExTaxprice=$2,000.00, 
		//price=$2,000.00, name=MacBook Pro, Product Code=Product 18, Reward Points=800
		
		Assert.assertEquals(productInfoMap.get("name"),productname);
		Assert.assertEquals(productInfoMap.get("Brand"),"Apple");
		Assert.assertEquals(productInfoMap.get("Availability"),"Out Of Stock");
		Assert.assertEquals(productInfoMap.get("Product Code"),"Product 18");
		Assert.assertEquals(productInfoMap.get("price"),"$2,000.00");
		Assert.assertEquals(productInfoMap.get("Reward Points"),"800");
		
	}
	
	@Test(priority = 1)
	public void verifyProductInfoTest_iMac()
	{
		
		String productname ="iMac";
		
		Assert.assertTrue(accountsPage.doSearch(productname));
		
		productInfoPage=accountsPage.selectProductFromResults("iMac");
		
		Assert.assertTrue(productInfoPage.getProductImage()==3);
		
		Map<String,String> productInfoMap= productInfoPage.getProductInformation();
			
		System.out.println(productInfoMap);
		//Brand=Apple, Availability=Out Of Stock, ExTaxprice=$100.00, price=$122.00, name=iMac, Product Code=Product 14
		
		Assert.assertEquals(productInfoMap.get("name"),productname);
		Assert.assertEquals(productInfoMap.get("Brand"),"Apple");
		Assert.assertEquals(productInfoMap.get("Availability"),"Out Of Stock");
		Assert.assertEquals(productInfoMap.get("Product Code"),"Product 14");
		Assert.assertEquals(productInfoMap.get("price"),"$122.00");
		
		
	}
}
