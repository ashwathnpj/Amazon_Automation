package com.amazon.automation.Amazon_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_RegistrationPage {
	WebDriver driver;

	@FindBy(id = "ap_customer_name")
	WebElement name;

	@FindBy(id = "ap_phone_number")
	WebElement mobile_number;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "continue")
	WebElement verify_mobile_number_button;

	public void enter_name() {
		name.sendKeys("joe");
	}

	public void enter_mobileNumber() {
		mobile_number.sendKeys("9856472598");
	}

	public void set_password() {
		password.sendKeys("joe@1234");
	}

	public void click_verify_mobile_number(WebDriver driver) {
		verify_mobile_number_button.click();
		Assert.assertEquals(driver.getTitle(), "Authentication required", "sorry, authentication title is not matched");
		// Assert.assertTrue(driver.findElement(By.id("auth-pv-enter-code")).isDisplayed(),"otp element is not displayed");
		// Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "sorry,title is not matched");
	}

	public Amazon_RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
