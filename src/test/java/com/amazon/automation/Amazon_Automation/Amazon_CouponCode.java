package com.amazon.automation.Amazon_Automation;
//checking if user is able to apply for coupon code while ordering the product 


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_CouponCode extends LaunchQuit {
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void coupon_code() throws EncryptedDocumentException, IOException {
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

		Amazon_SearchedPage search = new Amazon_SearchedPage(driver);
		search.click_first_product();
		
		Amazon_Product_Details_Page product_page=new Amazon_Product_Details_Page(driver);
		product_page.click_add_to_cart_button(driver);
		product_page.click_cart_page_button(driver);
		
		Amazon_CartPage carted_item=new Amazon_CartPage(driver);
		carted_item.click_proceed_to_buy_button(driver);
		
		Amazon_Checkout_Page checkout=new Amazon_Checkout_Page(driver);
		checkout.click_change_address_button();
		checkout.enter_and_apply_claim_code(driver);
		
		

	}

}
