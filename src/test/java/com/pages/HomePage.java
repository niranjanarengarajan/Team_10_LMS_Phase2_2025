package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
    private WebDriver driver;
     @FindBy(xpath = "//input[@id='username']")
        private WebElement usernamefield;

        @FindBy(xpath = "//input[@id='password']")
        private WebElement passwordfield;
        
        @FindBy(xpath = "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted']")
        private WebElement roleDropdown; 
        
        @FindBy(xpath = "//span[@class='mat-button-wrapper']")
        private WebElement Loginbutton; 



        public HomePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this); // Initialize elements
        }

        public void setLoginDetails(String username, String password,String role) {
        	   System.out.println("Username: " + username);
        	    System.out.println("Password: " + password);
        	    
        	    if (username != null && !username.isEmpty()) {
        	        usernamefield.sendKeys(username);
        	    } else {
        	        System.err.println("Username is null or empty!");
        	    }
        	    
        	    if (password != null && !password.isEmpty()) {
        	        passwordfield.sendKeys(password);
        	    } else {
        	        System.err.println("Password is null or empty!");
        	    }
        }
        private void selectRole(String role) {
            // Assuming roleDropdown is the select element
            Select select = new Select(roleDropdown);
            select.selectByVisibleText(role); // Use visible text to select the role
            System.out.println("+++++Role selected: " + role);
        
        }
        public void clickloginButton() {
        
                System.out.println("Clicking on the login element in the main page");
                Loginbutton.click();
                System.out.println("++++++++Clicked on login button");
        
        }
}