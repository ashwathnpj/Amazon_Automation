package com.amazon.automation.Amazon_Automation;

import org.testng.annotations.Listeners;

//Testing an amazon, a new user can successfully register or not


import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_Registration extends LaunchQuit{
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void register_amazon() {
		Amazon_HomePage homepage=new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_starthere();
		
		Amazon_RegistrationPage registration=new Amazon_RegistrationPage(driver);
		registration.enter_name();
		registration.enter_mobileNumber();
		registration.set_password();
		registration.click_verify_mobile_number(driver);
	}

}
