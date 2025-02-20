package com.amazon.automation.Amazon_Automation;
//testing, searching for products using its name like mobiles 


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_SearchProduct extends LaunchQuit{
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void search_product() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage=new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);
		
		Amazon_SigninPage signin=new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);
		
		homepage.enter_mobiles_in_search_field(driver);	
		
	}

}
