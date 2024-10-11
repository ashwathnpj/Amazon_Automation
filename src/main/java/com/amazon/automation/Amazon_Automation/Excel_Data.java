package com.amazon.automation.Amazon_Automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Data {
	static String un;
	static String pwd;
	static String wrong_un;
	static String wrong_pwd;
	static String search1;
	static String search2;
	public void excel_sheet() throws EncryptedDocumentException, IOException {
		FileInputStream location=new FileInputStream("C:\\\\Users\\\\ashwathnpj\\\\javaprograms\\\\Amazon_Automation\\\\src\\\\excel\\\\data.xlsx");
		Workbook w1=WorkbookFactory.create(location);
		un=w1.getSheet("credentials").getRow(1).getCell(0).getStringCellValue();
		pwd=w1.getSheet("credentials").getRow(1).getCell(1).getStringCellValue();
		wrong_un=w1.getSheet("credentials").getRow(1).getCell(2).getStringCellValue();
		wrong_pwd=w1.getSheet("credentials").getRow(1).getCell(3).getStringCellValue();
		search1=w1.getSheet("search").getRow(1).getCell(0).getStringCellValue();
		search2=w1.getSheet("search").getRow(2).getCell(0).getStringCellValue();
		
	}
}
