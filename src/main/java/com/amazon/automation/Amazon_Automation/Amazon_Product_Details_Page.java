package com.amazon.automation.Amazon_Automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_Product_Details_Page {
	WebDriver driver;
	
	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement product_title_text;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[6]")
	WebElement price_text;
	
	@FindBy(xpath = "//div[@class='a-fixed-left-grid-col aok-align-center a-col-right']")
	WebElement reviews_text;

	@FindBy(css = "#feature-bullets")
	WebElement description_box;
	
	@FindBy(xpath = "//span[.='Quantity:']")
	WebElement quantity_dropdown_check;
	
	@FindBy(css = "#add-to-wishlist-button-submit")
	WebElement wishlist_button;
	
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	WebElement add_to_cart_button;
	
	@FindBy(id = "buy-now-button")
	WebElement buy_now_button;
	
	@FindBy(xpath="//div[@class='a-box a-alert a-alert-success added-to-cart-message-box']/div/h4[.='Added to Cart']")
    WebElement added_to_cart_text_field;
	
	@FindBy(xpath = "(//span[.='    Cart   '])[1]")
	WebElement cart_button;
	
	@FindBy(id = "add-to-cart-button")
	WebElement add_pen_to_cart_button;
	
	@FindBy(xpath = "//div[@id='sw-atc-buy-box']//span[@class='a-button-inner']/a[@class='a-button-text']")
	WebElement go_to_Cart_button;
	
//	
	public void check_product_details(WebDriver driver) {
		// product name, price, reviews, description, quantity, add to wish list
		// add to cart, buy now

		Set<String> windowHandlesSet = driver.getWindowHandles();
		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
		String parentId = iterator_windowHandlesSet.next();
		String childId = iterator_windowHandlesSet.next();

		driver.switchTo().window(childId);
		Assert.assertFalse(product_title_text.getText().isEmpty(), "Product title is not empty.");
		Assert.assertFalse(price_text.getText().isEmpty(), "Price text is not empty.");
		Assert.assertFalse(reviews_text.getText().isEmpty(), "Reviews text is not empty.");
		Assert.assertFalse(description_box.getText().isEmpty(), "Description box is not empty.");
		Assert.assertTrue(quantity_dropdown_check.isDisplayed(),"quantity_dropdown_check is not displayed in product details page");
		Assert.assertTrue(wishlist_button.isDisplayed(),"wishlist_button is not displayed in product details page");
		Assert.assertTrue(add_to_cart_button.isDisplayed(),"add_to_cart_button is not displayed in product details page");
		Assert.assertTrue(buy_now_button.isDisplayed(),"buy_now_button is not displayed in product details page");
	}
	
        public void click_add_to_cart_button(WebDriver driver) {
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
		String parentId = iterator_windowHandlesSet.next();
		String childId = iterator_windowHandlesSet.next();

		driver.switchTo().window(childId);
		add_to_cart_button.click();
		Assert.assertTrue(added_to_cart_text_field.isDisplayed(), "added to cart text not displayed");

	}
        
        public void click_pen_add_to_cart_button(WebDriver driver) {
    		
    		Set<String> windowHandlesSet = driver.getWindowHandles();
    		Iterator<String> iterator_windowHandlesSet = windowHandlesSet.iterator();
    		String parentId = iterator_windowHandlesSet.next();
    		String childId = iterator_windowHandlesSet.next();

    		driver.switchTo().window(childId);
    		add_pen_to_cart_button.click();

    	}
        
        
        
       public void click_cart_page_button(WebDriver driver) {
    	   cart_button.click();
   		   Assert.assertEquals(driver.findElement(By.xpath("//div[@class='a-row sc-cart-header sc-compact-bottom']/div/h2")).getText(), "Shopping Cart", "sorry, cart page not displayed");

       }
       
       public void click_go_to_cart_page_button(WebDriver driver) {
    	   
    	   go_to_Cart_button.click();
   		   Assert.assertEquals(driver.findElement(By.xpath("//div[@class='a-row sc-cart-header sc-compact-bottom']/div/h2")).getText(), "Shopping Cart", "sorry, cart page not displayed");

       }
       

//	
	public Amazon_Product_Details_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
