package com.amazon.automation.Amazon_Automation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_HomePage extends Excel_Data{
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement accountsandlist;
	
	@FindBy(partialLinkText="Start here.")
	WebElement starthere;
	
	@FindBy(partialLinkText="Sign in")
	WebElement signin_button;
	
	@FindBy(xpath="//button[.='Manage Profiles']")
	WebElement manage_profiles_button;

	@FindBy(partialLinkText="View")
	WebElement view_button;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search_field;
		
	@FindBy(id="nav-orders")
	WebElement orders_link;
///////	
	
	
	public void hoverover_accountandlists(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountsandlist).perform();	
	}
	public void click_starthere()
	{
		starthere.click();	
	}

	public void click_signin_button(WebDriver driver)
	{
		signin_button.click();
		Assert.assertTrue(driver.findElement(By.name("email")).isDisplayed(), "sorry, signin page not displayed");
		
	}
	
	
	public void click_manage_profiles_button()
	{
		manage_profiles_button.click();		

	}
	
	public void click_view_button(WebDriver driver)
	{
		view_button.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[.='Your Profile']")).isDisplayed(),"sorry, profile page is not displayed");
	   // Assert.assertEquals(driver.getTitle(),"Profile Hub", "profile page not displayed");
	}
	
	
	public void enter_mobiles_in_search_field(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		//search_field.sendKeys("mobiles"+Keys.ENTER);
		
		excel_sheet();
		search_field.sendKeys(search1+Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : mobiles", "sorry, mobiles searched page title not matched");
	}
	
	public void enter_pens_in_search_field(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		//search_field.sendKeys("pens"+Keys.ENTER);
		
		excel_sheet();
		search_field.sendKeys(search2+Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : pens", "sorry, pen searched page title not matched");
	}
	
	
	public void click_orders_link()
	{
		orders_link.click();	
	}
////	
	
	public Amazon_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
