package com.amazon.automation.Amazon_Automation;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v126.console.Console;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Amazon_SigninPage extends Excel_Data{
	WebDriver driver;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(id = "continue")
	WebElement continue_button;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signin_button;
	

	public void enter_email_or_mobileNumber() throws EncryptedDocumentException, IOException {
		//email.sendKeys("anpjoshi6@gmail.com");
		
		excel_sheet();
		email.sendKeys(un);
	}

	public void click_continue_button() {
		continue_button.click();
	}

	public void enter_password() throws EncryptedDocumentException, IOException {
		//password.sendKeys("");
		
		excel_sheet();
		password.sendKeys(pwd);
	}

	public void click_signin_button(WebDriver driver) {
		signin_button.click();
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(), "sorry, homepage not displayed");
		// Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "sorry,title is not matched");

	}

	public void enter_wrong_emailid() throws EncryptedDocumentException, IOException {
		//email.sendKeys("azasderg12@gmail.com");
		
		excel_sheet();
		email.sendKeys(wrong_un);
		
		continue_button.click();
		Assert.assertFalse(password.isDisplayed());
		Reporter.log("test case is passed because, it is not accepting the invalid email id");

	}

	public void enter_wrong_password(WebDriver driver) throws EncryptedDocumentException, IOException {
		//email.sendKeys("anpjoshi6@gmail.com");
		
		excel_sheet();
		email.sendKeys(un);
		
		continue_button.click();
		//password.sendKeys("123demo@1234");
		
		password.sendKeys(wrong_pwd);
		
		signin_button.click();
		Assert.assertNotEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","sorry, after entering wrong password, navigated to homepage");
		Reporter.log("test case is passed because, signin is not happening with invalid password");
	}

	public Amazon_SigninPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
