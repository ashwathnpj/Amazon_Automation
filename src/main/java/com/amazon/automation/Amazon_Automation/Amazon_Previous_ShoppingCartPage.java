package com.amazon.automation.Amazon_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Previous_ShoppingCartPage {
    WebDriver driver;

    // Cart count on Amazon home page
    @FindBy(id = "nav-cart-count")
    WebElement cart_numbers;

    // Delete button for items in cart
    @FindBy(xpath = "//div[@class='a-row sc-action-links']//input[@value='Delete']")
    WebElement items_delete_button;

    public void clear_cart(WebDriver driver) {
        // Loop until the cart count becomes 0
        while (!cart_numbers.getText().equals("0")) {
            try {
                // Click on the cart icon if items are present
                cart_numbers.click();

                // Delete items one by one
                while (!cart_numbers.getText().equals("0")) {
                    try {
                        // Re-fetch delete button dynamically after each action
                        WebElement delete_button = driver.findElement(By.xpath("//div[@class='a-row sc-action-links']//input[@value='Delete']"));
                        delete_button.click();  // Click on the delete button
                        
                        // Wait for the page to refresh and update the cart count
                        Thread.sleep(2000);  
                    } catch (StaleElementReferenceException e) {
                    }
                }
            } catch (InterruptedException e) {
               
            }
        }
       // System.out.println("Cart is now empty.");
        
    }

    public Amazon_Previous_ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
