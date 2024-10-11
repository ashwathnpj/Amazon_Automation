package com.amazon.automation.Amazon_Automation;
//reaching till cart page without login in amazon application 

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_AddToCartWithoutLogin extends LaunchQuit {
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void addToCartWithoutLogin() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.enter_mobiles_in_search_field(driver);

		Amazon_SearchedPage search = new Amazon_SearchedPage(driver);
		search.click_first_product();
		
		Amazon_Product_Details_Page product_page=new Amazon_Product_Details_Page(driver);
		product_page.click_add_to_cart_button(driver);
		product_page.click_cart_page_button(driver);
		
		Amazon_CartPage carted_item=new Amazon_CartPage(driver);
		carted_item.click_without_login_proceed_to_buy_button(driver);
		
		
	}

}
