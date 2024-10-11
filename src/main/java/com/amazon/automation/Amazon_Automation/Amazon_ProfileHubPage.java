package com.amazon.automation.Amazon_Automation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_ProfileHubPage {
	WebDriver driver;

	@FindBy(xpath = "//button[@class='edit-pencil-icon-button']")
	WebElement name_pencil;

	@FindBy(id = "editProfileNameInputId")
	WebElement name;

	@FindBy(xpath = "//span[@id='editProfileContinueButton']/span[@class='a-button-inner']/input[@class='a-button-input']")
	WebElement continue_button;

	@FindBy(xpath = "//div[.='Preferred department']")
	WebElement department_button;

	@FindBy(xpath = "//div[@class='content-wrapper']/div/button")
	WebElement mini_add_button;

	@FindBy(xpath = "//button[.='Men']")
	WebElement men_button;

	@FindBy(xpath = "//button[.='Clear']")
	WebElement clear_button;

	@FindBy(xpath = "//span[.='Yes, clear my data']")
	WebElement clear_my_data_button;

	@FindBy(xpath = "//button[.='Women']")
	WebElement women_button;

	@FindBy(xpath = "//span[.='Save']")
	WebElement save_button;

	// height and weight
	@FindBy(xpath = "//div[.='Height and weight']")
	WebElement height_and_weight;

	@FindBy(xpath = "(//input[@class='number-input-box'])[1]")
	WebElement height_field;

	@FindBy(xpath = "(//input[@class='number-input-box'])[2]")
	WebElement weight_field;

	// age group
	@FindBy(xpath = "//div[.='Age group']")
	WebElement age_group;

	@FindBy(xpath = "//button[.='25-29']")
	WebElement age_group_selection_button;

	// department preferences
	@FindBy(xpath = "//div[.='Men’s']")
	WebElement men_department_preferences_choice;

	@FindBy(xpath = "//div[.='Women’s']")
	WebElement women_department_preferences_choice;

	@FindBy(xpath = "//div[.='Fit attributes']")
	WebElement fit_attributes_button;

	@FindBy(xpath = "(//button[.='Average'])[1]")
	WebElement shoulders_average_choice;

	@FindBy(xpath = "(//button[.='Average'])[2]")
	WebElement waist_average_choice;

	@FindBy(xpath = "(//button[.='Average'])[3]")
	WebElement thighs_average_choice;

	@FindBy(xpath = "(//button[.='Average'])[4]")
	WebElement chest_average_choice;

	// shoes
	@FindBy(xpath = "//div[.='Shoes']")
	WebElement shoes;

	@FindBy(xpath = "//button[.='8']")
	WebElement button_8;

	@FindBy(xpath = "//button[.='Standard']")
	WebElement standard_button;

	public void edit_profile_name(WebDriver driver) {
		name_pencil.click();
		name.clear();
		name.click();
		// name.sendKeys(Keys.CONTROL+"A");
		name.sendKeys("ashwathnarayan joshi1");
		
		int attempts = 0;
		while (attempts < 2) {
		    try {
		        // Re-fetch the button to avoid StaleElementReferenceException
		        continue_button = driver.findElement(By.xpath("//span[@id='editProfileContinueButton']/span[@class='a-button-inner']/input[@class='a-button-input']"));
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(continue_button));
		        
		        continue_button.click();
		        break; // Break loop if click is successful
		    } catch (NoSuchElementException e) {
		        System.out.println("No such element exception occurred.");
		        attempts++; 
		    } catch (ElementClickInterceptedException e) {
		        System.out.println("Element click intercepted exception occurred.");
		        attempts++;
		    } catch (StaleElementReferenceException e) {
		        System.out.println("Stale element reference exception occurred.");
		        attempts++; 
		    }
		}
	}

	public void click_preferred_department(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[.='Continue']")));
		department_button.click();
	}

	public void add_men_preferred_department(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Add']")));
		mini_add_button.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Men']")));
		men_button.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Save']")));
		save_button.click();
		
		Assert.assertTrue(clear_button.isDisplayed(), "men preferred department not added");;
	}

	public void add_women_preferred_department(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Add']")));
		mini_add_button.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Women']")));
		women_button.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Save']")));
		save_button.click();
		
		Assert.assertTrue(clear_button.isDisplayed(), "women preferred department not added");

	}

	public void click_clear_button() {
		clear_button.click();
		clear_my_data_button.click();

	}

	public void click_height_and_weight() {
		height_and_weight.click();
	}

	public void add_height_weight(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Add']")));
		mini_add_button.click();

		height_field.sendKeys("100");

		weight_field.sendKeys("80");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Save']")));
		save_button.click();
		
		Assert.assertTrue(clear_button.isDisplayed(), "height_weight not added");

	}

	public void click_age_group() {
		age_group.click();
	}

	public void add_age_group(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Add']")));
		mini_add_button.click();

		age_group_selection_button.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Save']")));
		save_button.click();
		
		Assert.assertTrue(clear_button.isDisplayed(), "age_group not added");

	}
		
	public void select_mens_department_preferences() {
		men_department_preferences_choice.click();
	}

	public void select_womens_department_preferences() {
		women_department_preferences_choice.click();
	}

	public void click_fit_attributes_button() {
		fit_attributes_button.click();
	}

	public void add_fit_attributes(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Add']")));
		mini_add_button.click();

		shoulders_average_choice.click();
		waist_average_choice.click();
		thighs_average_choice.click();
		chest_average_choice.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Save']")));
		save_button.click();
		
		Assert.assertTrue(clear_button.isDisplayed(), "fit_attributes values not added");

	}

	public void click_shoes() {
		shoes.click();

	}

	public void add_shoes_details(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Add']")));
		mini_add_button.click();

		button_8.click();
		standard_button.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Save']")));
		save_button.click();
		
		Assert.assertTrue(clear_button.isDisplayed(), "shoes_details values not added");

	}

	public Amazon_ProfileHubPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
