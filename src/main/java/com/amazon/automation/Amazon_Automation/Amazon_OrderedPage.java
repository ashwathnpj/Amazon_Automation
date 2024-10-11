package com.amazon.automation.Amazon_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_OrderedPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='a-row a-spacing-top-mini']//a[@id='a-autoid-3-announce']")
	WebElement view_your_item_button;
	
	@FindBy(partialLinkText="Write a product review")
	WebElement write_a_product_review_link;
	
	@FindBy(xpath="(//div[@class='ryp__card-layout-block__section']//button[@class='ryp__star__button'])[4]")
	WebElement four_star_rating;
	
	@FindBy(xpath="(//span[.='Submitted'])[2]")
	WebElement ratings_submitted_message;
		
//	
	
	
	public void click_view_your_item_button()
	{
		view_your_item_button.click();	
	}
	
	public void click_write_a_product_review_link()
	{
		write_a_product_review_link.click();	
	}
	
	public void click_four_star_rating()
	{
		four_star_rating.click();
		//Assert.assertTrue(ratings_submitted_message.isDisplayed(),"product star ratings not submitted");	
	}
//	
	public Amazon_OrderedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
