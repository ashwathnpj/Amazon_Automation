package com.amazon.automation.Amazon_Automation;
//testing that the product detail page displays all necessary information 
//Product title, Price text, Reviews text, Description box, 
//quantity_dropdown_check, wishlist_button,add_to_cart_button,buy_now_button  

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_ProductDetails extends LaunchQuit{
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void product_details() throws EncryptedDocumentException, IOException {
		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);

		Amazon_SigninPage signin = new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);

		homepage.enter_mobiles_in_search_field(driver);
		
		Amazon_SearchedPage search=new Amazon_SearchedPage(driver);
		search.click_first_product();
		
		Amazon_Product_Details_Page product_page=new Amazon_Product_Details_Page(driver);
		product_page.check_product_details(driver);
		
	}
}
