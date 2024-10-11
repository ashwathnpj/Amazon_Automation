package com.amazon.automation.Amazon_Automation;
//testing the updating item quantities and removing items from the cart

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_UpdateCartQuantities extends LaunchQuit{
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void UpdateCartQuantities() throws EncryptedDocumentException, IOException  {
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
		product_page.click_cart_page_button(driver);
		
		Amazon_CartPage carted_item=new Amazon_CartPage(driver);
		carted_item.update_cart_quantities();
		carted_item.delete_cart_items(driver);	
	}
}
