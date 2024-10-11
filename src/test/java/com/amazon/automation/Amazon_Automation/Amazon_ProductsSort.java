package com.amazon.automation.Amazon_Automation;
//checking if products can be sorted by relevance, price, rating, newest arrivals 

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_ProductsSort extends LaunchQuit {
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void products_Sort() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);

		Amazon_SigninPage signin = new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);

		homepage.enter_mobiles_in_search_field(driver);

		Amazon_SearchedPage searched = new Amazon_SearchedPage(driver);
		searched.click_low_to_high_feature_option(driver);
		searched.click_high_to_low__feature_option(driver);
		searched.click_average_customer_rating_option(driver);
		searched.click_newest_arrivals_option(driver);
		searched.click_best_sellers_option(driver);
	}

}
