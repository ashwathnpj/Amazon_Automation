package com.amazon.automation.Amazon_Automation;
//verifying that items can be added to the shopping cart from product page

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_AddToCart extends LaunchQuit{
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void add_to_cart() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);

		Amazon_SigninPage signin = new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);
		
		Amazon_Previous_ShoppingCartPage previous_items=new Amazon_Previous_ShoppingCartPage(driver);
		previous_items.clear_cart(driver);

		homepage.enter_mobiles_in_search_field(driver);
		
		Amazon_SearchedPage search=new Amazon_SearchedPage(driver);
		search.click_first_product();
		
		Amazon_Product_Details_Page product_page=new Amazon_Product_Details_Page(driver);
		product_page.click_add_to_cart_button(driver);
	}

}
