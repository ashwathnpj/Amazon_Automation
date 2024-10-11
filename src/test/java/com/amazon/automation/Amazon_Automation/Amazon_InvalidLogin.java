package com.amazon.automation.Amazon_Automation;
//verifying amazon login is failing with incorrect email id or wrong password 


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_InvalidLogin extends LaunchQuit {
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void Amazon_InvalidLoginEmail() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);

		Amazon_SigninPage signin = new Amazon_SigninPage(driver);
		//signin.enter_wrong_emailid();
		signin.enter_wrong_password(driver);
	}

}
