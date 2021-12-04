package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	public static String TEST_DATA_SHEET_PATH="./src/main/java/com/qa/hubspot/testData/registeAccountTestData.xlsx";
	
	public static Object[][] getTestData(String sheetName)
	{
		Object data[][]=null;
		
		try {
			
			FileInputStream ip= new FileInputStream(TEST_DATA_SHEET_PATH);
			workbook = new XSSFWorkbook(ip);
			sheet = workbook.getSheet(sheetName);
			
			 data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for(int j=0; j< sheet.getRow(0).getLastCellNum();j++)
				{
					
					data[i][j]= sheet.getRow(i+1).getCell(j).toString();
				}
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		return data	;
			
		
		
	}
	
}	
