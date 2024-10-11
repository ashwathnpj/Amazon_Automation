package com.amazon.automation.Amazon_Automation;
//verifying amazon login is successful with correct email and password 

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)
public class Amazon_ValidLogin extends LaunchQuit{
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void login_amazon() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage=new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);
		
		Amazon_SigninPage signin=new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);
		
	}

}
