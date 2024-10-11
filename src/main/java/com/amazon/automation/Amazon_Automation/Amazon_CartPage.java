package com.amazon.automation.Amazon_Automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_CartPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[.='Qty:']")
	WebElement quantity_dropdown;
	
	@FindBy(css = "[aria-labelledby='quantity_2']")
	WebElement quantity_two_option;
	
	@FindBy(xpath = "//div[@class='a-row sc-action-links']//input[@value='Delete']")
	WebElement items_delete_button;
	
	@FindBy(xpath="//div[@id='nav-cart-count-container']/span[.='2']")
	WebElement two_items_cart_count_container;
	
	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceed_to_buy_button;
//
	@FindBy(css = "[aria-labelledby='quantity_1']")
	WebElement quantity_one_option;

	@FindBy(id = "deselect-all")
	WebElement deselect_button;

	@FindBy(id = "select-all")
	WebElement select_all_button;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[1]")
	WebElement recent_product_checkbox;
	
	
	public void update_cart_quantities() {
		
		quantity_dropdown.click();
		quantity_two_option.click();
	}
	
	public void delete_cart_items(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(two_items_cart_count_container));
		Assert.assertEquals(driver.findElement(By.id("nav-cart-count")).getText(), "2");
		int attempts = 0;
		while (attempts < 2) {
			try {
				items_delete_button.click();
				break; // break the loop if successful
			} catch (StaleElementReferenceException e) {
				attempts++; // retry locating the element
			}
		}
		Assert.assertEquals(driver.findElement(By.id("nav-cart-count")).getText(), "0", "sorry, cart count is not zero");
		
	}
	
	public void click_proceed_to_buy_button(WebDriver driver) {
		proceed_to_buy_button.click();
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='submissionURL'])[2]")).isDisplayed(),"sorry, delivery address not displayed of checkout page");
		
	}
	
	public void click_without_login_proceed_to_buy_button(WebDriver driver) {
		proceed_to_buy_button.click();
		Assert.assertTrue(driver.findElement(By.name("email")).isDisplayed());
	}
	
//
	public void select_recent_product_only(WebDriver driver) {
		select_all_button.click();
		deselect_button.click();
		int attempts = 0;
		while (attempts < 2) {
			try {
				recent_product_checkbox.click();
				break; // break the loop if successful
			} catch (StaleElementReferenceException e) {
				attempts++; // retry locating the element
			}
		}

		int attemptss = 0;
		while (attempts < 2) {
			try {
				quantity_dropdown.click();
				break; // break the loop if successful
			} catch (StaleElementReferenceException e) {
				attemptss++; // retry locating the element
			}
		}
		quantity_one_option.click();

	}

	public Amazon_CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
