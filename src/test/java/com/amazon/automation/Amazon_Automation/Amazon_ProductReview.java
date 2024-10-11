package com.amazon.automation.Amazon_Automation;
//Going to orders page and click on last ordered product and give 4 star ratings

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_ProductReview extends LaunchQuit {
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void product_review() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);

		Amazon_SigninPage signin = new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);
		
		homepage.click_orders_link();
		
		Amazon_OrderedPage order=new Amazon_OrderedPage(driver);
		order.click_view_your_item_button();
		order.click_write_a_product_review_link();
		order.click_four_star_rating();
	}

}
