package com.amazon.automation.Amazon_Automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_SearchedPage {
	WebDriver driver;

	@FindBy(xpath = "//span[.='Smartphones & Basic Mobiles']")
	WebElement smartphones_Basic_Mobiles_category;

	@FindBy(xpath = "//span[.='Smartphones']")
	WebElement smartphones_category;
	
	@FindBy(xpath = "//span[.='New']")
	WebElement new_items_condition;

	@FindBy(xpath = "(//div[@id='brandsRefinements']//i[@class='a-icon a-icon-checkbox'])[1]")
	WebElement first_checklist;

	
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")
	WebElement first_product;
	
	@FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[5]")
	WebElement first_pen_product;
	
	@FindBy(xpath = "//span[.='Featured']")
	WebElement featured_button;

	@FindBy(partialLinkText = "Price: Low to High")
	WebElement low_to_high_feature_option;

	@FindBy(partialLinkText = "Price: High to Low")
	WebElement high_to_low__feature_option;

	@FindBy(partialLinkText = "Avg. Customer Review")
	WebElement average_customer_rating_option;

	@FindBy(partialLinkText = "Newest Arrivals")
	WebElement newest_arrivals_option;

	@FindBy(partialLinkText = "Best Sellers")
	WebElement best_sellers_option;
//
	
	public void click_smartphones_Basic_Mobiles_category(WebDriver driver) {
		smartphones_Basic_Mobiles_category.click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[.='Smartphones']")).isDisplayed());
	}

	public void click_smartphones_category() {
		smartphones_category.click();
	}
	
	public void click_new_items_condition() {
		new_items_condition.click();

	}
	
	public void brands_checklist_first_checklist(WebDriver driver)  {
		first_checklist.click(); 
		Assert.assertTrue(driver.findElement(By.xpath("//span[.='Clear']")).isDisplayed());	
	}

	public void click_first_product() {
		first_product.click();
	}
	
	public void click_first_pen_product() {
		first_pen_product.click();
	}
	
	public void click_low_to_high_feature_option(WebDriver driver) {
		featured_button.click();
		low_to_high_feature_option.click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[.='Price: Low to High']")).isDisplayed(),"sorry, low_to_high_feature_option not selected");
	}

	public void click_high_to_low__feature_option(WebDriver driver) {
		driver.navigate().back();
		featured_button.click();
		high_to_low__feature_option.click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[.='Price: High to Low']")).isDisplayed(),"sorry, high_to_low__feature_option not selected");

	}

	public void click_average_customer_rating_option(WebDriver driver) {
		driver.navigate().back();
		featured_button.click();
		average_customer_rating_option.click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[.='Avg. Customer Review']")).isDisplayed(),"sorry, average_customer_rating_option not selected");

	}

	public void click_newest_arrivals_option(WebDriver driver) {
		driver.navigate().back();
		featured_button.click();
		newest_arrivals_option.click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[.='Newest Arrivals']")).isDisplayed(),"sorry, newest_arrivals_option not selected");

	}

	public void click_best_sellers_option(WebDriver driver) {
		driver.navigate().back();
		featured_button.click();
		best_sellers_option.click();
		//Assert.assertTrue(driver.findElement(By.xpath("//span[.='Best Sellers']")).isDisplayed());

	}

//			
	public Amazon_SearchedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
