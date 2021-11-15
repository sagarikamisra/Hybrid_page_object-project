package com.qa.hubspot.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE= "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE= "Account Login";
	public static final String ACCOUNTS_PAGE_HEADER="Your Store";
	public static final int ACCOUNTS_SECTIONS=4;
	public static final String ACCOUNTS_REGISTER_SHEET_NAME="registration";
	public static final String ACCOUNTS_SUCCESS_MESSAGE="Your Account Has Been Created!";
	
	
	public static List<String> getAccountSectionsList()
	{
		List <String> accountList= new ArrayList<String>();
			
			accountList.add("My Account");
			accountList.add("My Orders");
			accountList.add("My Affiliate Account");
			accountList.add("Newsletter");
			return accountList;
		
		
	}
	
}
