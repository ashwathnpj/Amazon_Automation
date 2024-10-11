package com.amazon.automation.Amazon_Automation;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Amazon_Checkout_Page {
	WebDriver driver;
	
	@FindBy(xpath = "(//input[@name='submissionURL'])[2]")
	WebElement second_address_radio_button;

	@FindBy(xpath = "(//span[@class='a-button-inner']//input[@class='a-button-input'])[2]")
	WebElement use_this_address_button;
	
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[1]")
	WebElement first_payment_type_radio_button;
	
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[2]")
	WebElement second_payment_type_radio_button;
	
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[3]")
	WebElement third_payment_type_radio_button;
	
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[4]")
	WebElement fourth_payment_type_radio_button;
	
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[5]")
	WebElement fifth_payment_type_radio_button;
	
	@FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[6]")
	WebElement sixth_payment_type_radio_button;
	
	@FindBy(name = "ppw-claimCode")
	WebElement claim_code_field;
	
	@FindBy(name = "ppw-claimCodeApplyPressed")
	WebElement claim_code_apply_button;
	
//	@FindBy(xpath = "//span[@class='pmts-instrument-selector']/div[@class='a-radio']/label/input")
//	WebElement credit_debit_card_radio_button;
	
	@FindBy(css = "input[value^='SelectableAddCreditCard']")
	WebElement credit_debit_card_radio_button;
	
	
	
	@FindBy(xpath = "(//div[@class='a-row pmts-add-cc-default-trigger']//a[.='Enter card details'])[1]")
	WebElement enter_card_details_link;
	
	@FindBy(name = "ApxSecureIframe")
	WebElement payment_frame;
	
	@FindBy(xpath = "//input[@name='addCreditCardNumber']")
	WebElement credit_card_number_field;
	
	@FindBy(name = "ppw-accountHolderName")
	WebElement name_field;
	
	@FindBy(name = "ppw-widgetEvent:AddCreditCardEvent")
	WebElement enter_card_details_button;
	
	@FindBy(name = "ppw-widgetEvent:CancelAddCreditCardEvent")
	WebElement card_cancel_button;
	
	@FindBy(xpath = "(//span[.='Cash on Delivery/Pay on Delivery'])[3]")
	WebElement cash_on_delivery_radio_button;
	
	@FindBy(xpath = "(//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'])[1]")
	WebElement use_this_payment_method_button;
	
	@FindBy(id = "revieworder")
	WebElement review_order_box;
	
//	
	
	public void click_change_address_button() {
		second_address_radio_button.click();
		use_this_address_button.click();
	}
	
	public void select_all_payment_methods(WebDriver driver) {
		try {
		    if(first_payment_type_radio_button.isEnabled() && first_payment_type_radio_button.isDisplayed()) {
				first_payment_type_radio_button.click();
				Assert.assertTrue(first_payment_type_radio_button.isSelected(), "The first radio button was not selected!");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("first payment type radio button is not present.");
		}
		
		try {
		    if(second_payment_type_radio_button.isEnabled() && second_payment_type_radio_button.isDisplayed()) {
		        second_payment_type_radio_button.click();
				Assert.assertTrue(second_payment_type_radio_button.isSelected(), "The second radio button was not selected!");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("second payment type radio button is not present.");
		}
		
		try {
		    if(third_payment_type_radio_button.isEnabled() && third_payment_type_radio_button.isDisplayed()) {
		        third_payment_type_radio_button.click();
				Assert.assertTrue(third_payment_type_radio_button.isSelected(), "The third radio button was not selected!");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("third payment type radio button is not present.");
		}
		
		try {
		    if(fourth_payment_type_radio_button.isEnabled() && fourth_payment_type_radio_button.isDisplayed()) {
		        fourth_payment_type_radio_button.click();
				Assert.assertTrue(fourth_payment_type_radio_button.isSelected(), "The fourth radio button was not selected!");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("fourth payment type radio button is not present.");
		}
		
		try {
		    if(fifth_payment_type_radio_button.isEnabled() && fifth_payment_type_radio_button.isDisplayed()) {
		        fifth_payment_type_radio_button.click();
				Assert.assertTrue(fifth_payment_type_radio_button.isSelected(), "The fifth radio button was not selected!");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("fifth payment type radio button is not present.");
		}
			
	}
	
	public void enter_and_apply_claim_code(WebDriver driver) {
		claim_code_field.sendKeys("AS25-NZ1JX-CZCP5");
		claim_code_apply_button.click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'something wrong with the gift card claim code')]")).isDisplayed(), "coupon code not applied");
	}
	
	public void enter_credit_debit_card_details(WebDriver driver) {
	
		credit_debit_card_radio_button.click();
		enter_card_details_link.click();
		driver.switchTo().frame(payment_frame);
		credit_card_number_field.sendKeys("1234 5678 9012 3456");
		name_field.clear();
		name_field.sendKeys("Ashwathnarayan");
		WebElement expiry_month = driver.findElement(By.name("ppw-expirationDate_month"));
		Select selection_month = new Select(expiry_month);
		selection_month.selectByIndex(3);
		WebElement expiry_year = driver.findElement(By.name("ppw-expirationDate_year"));
		Select selection_year = new Select(expiry_year);
		selection_year.selectByIndex(3);
		enter_card_details_button.click();
		card_cancel_button.click();
		driver.switchTo().defaultContent();
		
		
	}
	public void click_cash_on_delivery() {
		cash_on_delivery_radio_button.click();
		use_this_payment_method_button.click();
	}
	
	public void check_review_order_box() {
		Assert.assertFalse(review_order_box.getText().isEmpty());
	}
	
	
//	
	
	public Amazon_Checkout_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
